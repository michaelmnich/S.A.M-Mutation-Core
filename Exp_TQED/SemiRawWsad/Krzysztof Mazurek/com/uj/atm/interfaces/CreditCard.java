package com.uj.atm.interfaces;


public class CreditCard implements  ICreditCard{
    String pin1="0000";

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin==pin1){
            if (newPin == newPinConfirm) {
                oldPin = newPin;
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(pin==pin1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) {

    }

    @Override
    public boolean DepositFunds(double amount) {
        return true;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        return true;
    }
}
