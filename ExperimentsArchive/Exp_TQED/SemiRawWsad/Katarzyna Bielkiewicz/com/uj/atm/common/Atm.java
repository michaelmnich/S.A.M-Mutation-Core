package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {

    private boolean logged;
    private IAccount Account1;
    private ICreditCard CreditCard1;

    public Atm(boolean logged) {
        this.logged = false;
        this.Account1 = null;
        this.CreditCard1 = null;
    }



    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if (creditCard.IsPinValid(pin)) {
            this.logged = true;
            this.CreditCard1 = creditCard;
            this.Account1 = ((CreditCard)creditCard).account;
            return true;

        }
        else{
            this.logged = false;
            this.Account1 = null;
            this.CreditCard1 = null;
            return false;
        }


    }

    @Override
    public double AccountStatus(IAccount account) {

        if(logged && (account == Account1)) {
            return account.AccountStatus();
        }
        throw new IllegalArgumentException("Zaloguj się");
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if(logged && (card == CreditCard1)){
            return card.ChangePin(oldPin, newPin, newPinConfirm);
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if(logged && (card == CreditCard1)) {
            return card.DepositFunds(amount);
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if(logged && (card == CreditCard1)) {
            return card.WithdrawFunds(amount);
        }
        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if(logged && (card == CreditCard1) && accountRecipient != Account1) {
            if(card.WithdrawFunds(amount)) {
                accountRecipient.DepositFunds(amount);
                return true;
            }
        }
        return false;
    }
}
