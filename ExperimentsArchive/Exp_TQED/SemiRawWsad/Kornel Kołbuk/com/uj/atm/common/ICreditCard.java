package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

import java.math.BigDecimal;

import static com.uj.atm.common.Helpers.CreateBigDecimal;

public class ICreditCard implements com.uj.atm.interfaces.ICreditCard {
    private IAccount bindedAccount;
    private String cardPin;
    private final int maxPinLength = 4;

    public ICreditCard() {
        this.cardPin = "0000";
        this.bindedAccount = null;
    }

    // I don't know if others will create this method also, so I am commenting out
//    public ICreditCard(String cardPin, IAccount account) {
//        this.cardPin = cardPin;
//        this.bindedAccount = account;
//    }


    @Override
    public synchronized boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (
                newPin.length() != maxPinLength ||
                        newPinConfirm.length() != maxPinLength ||
                        !newPin.equals(newPinConfirm) ||
                        !this.IsPinValid(oldPin)

        ) {
            return false;
        }
        this.cardPin = newPin;
        return true;
    }

    @Override
    public boolean IsPinValid(String pin) {
        return pin.length() == this.maxPinLength && this.cardPin.equals(pin);
    }

    @Override
    public synchronized void AddAccount(IAccount account) {
        if (this.bindedAccount == null) {
            this.bindedAccount = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.bindedAccount == null) {
            return false;
        }
        this.bindedAccount.getExternalLockInstance().lock();
        try {
            BigDecimal accountStatusBefore = CreateBigDecimal(Double.toString(this.bindedAccount.AccountStatus()));

            BigDecimal accountStatusAfter = CreateBigDecimal(Double.toString(
                    this.bindedAccount.DepositFunds(amount)
            ));

            return accountStatusBefore.compareTo(accountStatusAfter) != 0;
        } finally {
            this.bindedAccount.getExternalLockInstance().unlock();
        }
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.bindedAccount == null) {
            return false;
        }
        this.bindedAccount.getExternalLockInstance().lock();
        try {
            BigDecimal accountStatusBefore = CreateBigDecimal(Double.toString(this.bindedAccount.AccountStatus()));
            BigDecimal accountStatusAfter = CreateBigDecimal(Double.toString(
                    this.bindedAccount.WithdrawFunds(amount)
            ));

            return accountStatusBefore.compareTo(accountStatusAfter) != 0;
        } finally {
            this.bindedAccount.getExternalLockInstance().unlock();
        }
    }
}
