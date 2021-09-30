package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    private String Pin = "1234";
    private Account bank = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(oldPin == null){
            return false;
        }
        try {
            int a = Integer.parseInt(oldPin);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if(newPin == null){
            return false;
        }
        try {
            int a = Integer.parseInt(newPin);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if(newPinConfirm == null){
            return false;
        }
        try {
            int a = Integer.parseInt(newPinConfirm);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if(oldPin == Pin){
            if(newPin == newPinConfirm){
                if(newPinConfirm.length()==4) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(pin == null){
            return false;
        }
try {
    int a = Integer.parseInt(pin);
} catch (NumberFormatException nfe) {
    return false;
}
            if (pin == Pin) {
                if (pin.length() == 4) {

                    return true;
                }
            }
        return false;
    }

    @Override
    public void AddAccount(Account account) {
        if(bank == null){
            bank = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(bank!=null) {
            if(amount>=0) {
                bank.DepositFunds(amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(bank!=null){
            if(amount>=0) {
                if(amount<=bank.AccountStatus()) {
                    bank.WithdrawFunds(amount);
                    return true;
                }
            }
        }
        return false;
    }
}
