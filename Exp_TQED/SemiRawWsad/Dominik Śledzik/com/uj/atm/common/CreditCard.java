package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;



public class CreditCard implements ICreditCard {
    String accPin = "1234";
    IAccount acc = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm){
        if (oldPin == accPin){
            if(newPin.length() == 4 && newPin.compareTo(accPin) != 0) {
                if (newPin == newPinConfirm) {
                    accPin = newPin;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin){
        if(pin.compareTo(accPin) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account){
        if(acc == null){
            acc = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount){
        if(acc != null){
            double b = acc.AccountStatus();
            double c = acc.DepositFunds(amount);
            if(b != c) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(amount > 0 && acc != null){
           double a = acc.AccountStatus();
           double b = acc.WithdrawFunds(amount);
           if (b >= a){
               return false;
           }
        }
        return true;
    }

}
