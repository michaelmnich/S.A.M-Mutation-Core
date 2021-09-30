package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {

    CreditCard card_1 = null;
    Account acc = null;

    @Override
    public boolean CheckPinAndLogIn(CreditCard creditCard, String pin) {
        card_1 = creditCard;
        if(card_1.IsPinValid(pin)){
            return true;
        }
        return false;
    }

    @Override
    public double AccountStatus(Account account) {
        acc = account;
        return acc.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(CreditCard card, String oldPin, String newPin, String newPinConfirm) {
        card_1 = card;
        if(card_1.ChangePin(oldPin, newPin, newPinConfirm)){
            return true;
        }
        return false;
    }

    @Override
    public boolean DepositFunds(CreditCard card, double amount) {
        card_1 = card;
        card_1.AddAccount(acc);
        if(card.DepositFunds(amount)){
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(CreditCard card, double amount) {
        card_1 = card;
        if(card.WithdrawFunds(amount)){
            return true;
        }
        return false;
    }

    @Override
    public boolean Transfer(CreditCard card, Account accountRecipient, double amount) {
        card_1 = card;
       if(amount>=0) {
           if (card.WithdrawFunds(amount)) {
               card.WithdrawFunds(amount);
               accountRecipient.DepositFunds(amount);
               return true;
           }
       }
        return false;
    }
}
