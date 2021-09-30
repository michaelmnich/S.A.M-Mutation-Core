package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard{

    private String pin;
    private IAccount account;


    public CreditCard() {
        this.pin = "0000";
        this.account = null;
    }

    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm){
        if(oldPin.equals(pin)) {
            if (newPin.equals(newPinConfirm)) {
                pin = newPin;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean IsPinValid(String pin) {
        if(this.pin.equals(pin))
            return true;
        else
            return false;
    }
    public void AddAccount(IAccount account)
    {
        this.account = account;
    }

    public boolean DepositFunds(double amount) {
        if (account != null) {
            account.DepositFunds(amount);
            return true;
        } else {
            return false;
        }
    }
    public boolean WithdrawFunds(double amount) {
        try {
            if(account != null) {
                account.WithdrawFunds(amount);
                return true;
            } else {
                return false;
            }
        } catch (RuntimeException e) {
            return false;
        }
    }
}
