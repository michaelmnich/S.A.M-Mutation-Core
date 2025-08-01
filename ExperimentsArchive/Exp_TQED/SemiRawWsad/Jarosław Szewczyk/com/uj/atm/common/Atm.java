package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {

    private ICreditCard CurrentCreditCard = null;
    private Boolean LoggedIn = false;

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        this.CurrentCreditCard = null;
        this.LoggedIn = false;

        if (creditCard != null || pin.matches("^\\d{4}$")) {
            try {
                if (creditCard.IsPinValid(pin)) {
                    this.CurrentCreditCard = creditCard;
                    this.LoggedIn = true;
                    return true;
                }
            } catch (NullPointerException exception) {
                return false;
            }

        }
        return false;
    }

    @Override
    public double AccountStatus(IAccount account) {
        if (account != null) {
            return account.AccountStatus();
        }
        return 0;
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if (card != null) {
            return card.ChangePin(oldPin, newPin, newPinConfirm);
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if (card != null && amount >= 0.0) {
            return card.DepositFunds(amount);
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if (card != null && amount >= 0.0) {
            return card.WithdrawFunds(amount);
        }
        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if (card == null || accountRecipient == null || amount <= 0) {
            return false;
        }

        if (card.WithdrawFunds(amount)) {
            double accountRecipientStatusBefore = accountRecipient.AccountStatus();
            accountRecipient.DepositFunds(amount);

            if ((accountRecipientStatusBefore + amount) == accountRecipient.AccountStatus()) {
                return true;
            } else {
                // can't deposit money for the recipient, return funds to the card balance
                card.DepositFunds(amount);
                return false;
            }
        }
        return false;
    }
}
