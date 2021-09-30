package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    public String pin;
    public IAccount ACCOUNT;

    public CreditCard(){
        pin = "0000";
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm){

            if (newPin.matches("\\d{4}") && oldPin.matches("\\d{4}")
                    && newPin.equals(newPinConfirm) && oldPin != newPin) {
                oldPin = newPin;
                this.pin = oldPin;
                return true;
            }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {

        if(pin.matches("\\d{4}") && this.pin.equals(pin)) {
            return true;
        }
        else return false;
    }

    @Override
    public void AddAccount(IAccount account) {
       if(ACCOUNT == null){
           ACCOUNT = account;
       } else throw new IllegalArgumentException("Account exists!");
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(ACCOUNT != null) {
           ACCOUNT.DepositFunds(amount);
           return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(ACCOUNT != null) {
            ACCOUNT.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
