package com.uj.atm;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

import static java.lang.StrictMath.abs;

public class Atm implements IAtm {

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if(creditCard.IsPinValid(pin))
            return true;
        return false;
    }

    @Override
    public double AccountStatus(IAccount account) {
        return account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if(card.IsPinValid(oldPin)){
            card.ChangePin(oldPin, newPin, newPinConfirm);
            return true;
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if(card.DepositFunds(amount)){
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if(card.WithdrawFunds(amount)){
            return true;
        }
        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if(card.DepositFunds(abs(amount))) {
            accountRecipient.DepositFunds(abs(amount));
            return true;
        }

        return false;
    }
}
