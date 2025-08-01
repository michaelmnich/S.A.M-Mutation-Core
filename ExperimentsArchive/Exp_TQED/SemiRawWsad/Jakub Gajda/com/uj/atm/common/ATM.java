package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class ATM implements IAtm {
    String Pin = "0000"; /** pin jako domyślny */


    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if(creditCard.IsPinValid(pin)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double AccountStatus(IAccount account) {
        return account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if (card.ChangePin(oldPin, newPin, newPinConfirm)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if (card.DepositFunds(amount)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if (card.WithdrawFunds(amount)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if (card.WithdrawFunds(amount)) {
            card.WithdrawFunds(amount);
            accountRecipient.DepositFunds(amount);
            return true;
        } else {
            return false;
        }
    }
}

