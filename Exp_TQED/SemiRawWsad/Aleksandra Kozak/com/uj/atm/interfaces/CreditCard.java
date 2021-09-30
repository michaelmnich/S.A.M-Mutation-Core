package com.uj.atm.interfaces;

public class CreditCard implements ICreditCard {
    String OurPin = "0000";
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin == OurPin){
            if (newPin == newPinConfirm){
                oldPin = newPin;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (pin == OurPin){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) {

    }

    @Override
    public boolean DepositFunds(double amount) {
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        return false;
    }
}
