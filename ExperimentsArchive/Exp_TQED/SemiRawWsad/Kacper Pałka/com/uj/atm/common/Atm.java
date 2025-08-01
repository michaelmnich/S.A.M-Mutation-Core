package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {

public Atm(){}

public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
    return (creditCard.IsPinValid(pin));
    }

public double AccountStatus(IAccount account){
    return account.AccountStatus();
    }

public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
    return (card.ChangePin(oldPin, newPin, newPinConfirm));
}

public boolean DepositFunds(ICreditCard card, double amount) {
    return card.DepositFunds(amount);
    }

public boolean WithdrawFunds(ICreditCard card, double amount){
    return card.WithdrawFunds(amount);
    }

public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
    if(card.WithdrawFunds(amount)){
        accountRecipient.DepositFunds(amount);
        return true;
    }
    else return false;
    }
}

