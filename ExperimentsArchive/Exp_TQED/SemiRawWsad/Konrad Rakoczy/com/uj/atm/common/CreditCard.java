package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.util.regex.Pattern;

public class CreditCard implements ICreditCard {

    private Pattern pattern = Pattern.compile("\\d\\d\\d\\d");
    private IAccount account = null;


    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {

        if (oldPin.equals(newPin)) {
            System.out.println("Nie udana zmiana kodu PIN. Nowy PIN nie może być taki sam jak stary!");
            return false;
        } else if (newPinConfirm.equals(newPin))
            return true;
        else
            return true;
    }

    @Override
    public boolean IsPinValid(String pin) {

        if (pin.length() == 4 && pattern.matcher(pin).matches())
            return true;
        else
            return false;

    }

    @Override
    public void AddAccount(IAccount account) {

        if (this.account == null && account != null)
            this.account = account;


    }

    @Override
    public boolean DepositFunds(double amount) {

        if (account != null) {
            account.DepositFunds(amount);
            return true;
        } else
            return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (account != null) {
            account.WithdrawFunds(amount);
            return true;
        } else
            return false;
    }
}
