package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.math.BigDecimal;

import static com.uj.atm.common.Helpers.CreateBigDecimal;

public class IAtm implements com.uj.atm.interfaces.IAtm {
    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        return creditCard.IsPinValid(pin);
    }

    @Override
    public double AccountStatus(IAccount account) {

        account.getExternalLockInstance().lock();
        try {
            return account.AccountStatus();
        } finally {
            account.getExternalLockInstance().unlock();
        }
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        return card.ChangePin(oldPin, newPin, newPinConfirm);
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        return card.DepositFunds(amount);
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        return card.WithdrawFunds(amount);
    }

    @Override
    public synchronized boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        boolean withdrawStatus = card.WithdrawFunds(amount);
        if (!withdrawStatus) {
            return false;
        }

        accountRecipient.getExternalLockInstance().lock();
        try {
            BigDecimal accountStatusBefore = CreateBigDecimal(Double.toString(accountRecipient.AccountStatus()));

            BigDecimal accountStatusAfter = CreateBigDecimal(Double.toString(
                    accountRecipient.DepositFunds(amount)
            ));

            boolean depositStatus = accountStatusBefore.compareTo(accountStatusAfter) != 0;

            if (!depositStatus) {
                card.DepositFunds(amount);
            }
            return depositStatus;

        } finally {
            accountRecipient.getExternalLockInstance().unlock();
        }

    }
}
