package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {

    private boolean loggedIn;
    private IAccount currentAccount;
    private ICreditCard currentCreditCard;

    public Atm() {
        this.loggedIn = false;
        this.currentAccount = null;
        this.currentCreditCard = null;
    }

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if (creditCard != null && creditCard.IsPinValid(pin)) {
            this.loggedIn = true;
            this.currentAccount = ((CreditCard)creditCard).account;
            this.currentCreditCard = creditCard;
            return true;
        }
        this.loggedIn = false;
        this.currentAccount = null;
        this.currentCreditCard = null;
        return false;
    }

    @Override
    public double AccountStatus(IAccount account) {
        if(loggedIn && account != null && account.equals(currentAccount)) {
            return account.AccountStatus();
        }

        return Double.NaN;
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if(loggedIn && card.equals(currentCreditCard)){
            return card.ChangePin(oldPin, newPin, newPinConfirm);
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if(loggedIn && card != null && card.equals(currentCreditCard)) {
            return card.DepositFunds(amount);
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if(loggedIn && card != null && card.equals(currentCreditCard)) {
            return card.WithdrawFunds(amount);
        }
        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if (Double.isFinite(amount) &&
            card != null &&
            card.equals(currentCreditCard) &&
            accountRecipient != null &&
            card.WithdrawFunds(Math.max(0, amount)))
        {
            accountRecipient.DepositFunds(Math.max(0, amount));
            return true;
        }
        return false;
    }
}
