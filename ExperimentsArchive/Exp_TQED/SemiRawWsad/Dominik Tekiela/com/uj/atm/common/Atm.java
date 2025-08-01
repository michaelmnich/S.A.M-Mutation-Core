package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {
    private boolean isLogged = false;

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        return isLogged = creditCard.IsPinValid(pin);
    }

    @Override
    public double AccountStatus(IAccount account) {
        if(isLogged) return account.AccountStatus();
        else return 0.0;
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if(isLogged) return card.ChangePin(oldPin, newPin, newPinConfirm);
        else return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if(isLogged) return card.DepositFunds(amount);
        else return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if(isLogged) return card.WithdrawFunds(amount);
        else return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if(card.WithdrawFunds(amount) && isLogged){
            accountRecipient.DepositFunds(amount);
            return true;
        }
        return false;
    }
}
