package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {
    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        CreditCard credit = (CreditCard) creditCard;
        return credit.getPin().equals(pin);
    }

    @Override
    public double AccountStatus(IAccount account) {
        Account account1 = (Account) account;
        return account1.getBalance();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        CreditCard credit_card = (CreditCard) card;
        return credit_card.ChangePin(oldPin, newPin, newPinConfirm);
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        CreditCard credit_card = (CreditCard) card;
        return credit_card.DepositFunds(amount);
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        CreditCard credit_card = (CreditCard) card;
        return credit_card.WithdrawFunds(amount);
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        CreditCard credit_card = (CreditCard) card;
        Account account1 = (Account) accountRecipient;
        if (credit_card.WithdrawFunds(amount)){
            account1.DepositFunds(amount);
            return true;
        }
        return false;
    }
}
