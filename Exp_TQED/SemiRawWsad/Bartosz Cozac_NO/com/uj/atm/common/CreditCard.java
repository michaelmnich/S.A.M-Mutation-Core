package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    public String Pin = "0000";
    IAccount user = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if ((oldPin.equals(Pin))
                &&(newPin.equals(newPinConfirm))
                &&(Character.isDigit(newPin.charAt(0)))
                &&(Character.isDigit(newPin.charAt(1)))
                &&(Character.isDigit(newPin.charAt(2)))
                &&(Character.isDigit(newPin.charAt(3)))){
            Pin = newPin;
            return true;
        }else return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (Pin.equals(pin)){
            return true;
        }else return false;
    }

    @Override
    public void AddAccount(IAccount account) {
    user = account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if((user!=null)){
            user.DepositFunds(amount);
            return true;
        }else return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if((user.AccountStatus()>user.WithdrawFunds(amount))&&(user!=null)){
            return true;
        }else return false;
    }

}
