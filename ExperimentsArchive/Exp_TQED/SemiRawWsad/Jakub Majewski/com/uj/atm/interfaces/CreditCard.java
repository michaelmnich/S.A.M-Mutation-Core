package com.uj.atm.interfaces;

public class CreditCard implements ICreditCard{
    String pinek = "0000";
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (pinek == oldPin){
            pinek = newPin;
            System.out.print(pinek);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (pin==pinek){
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
