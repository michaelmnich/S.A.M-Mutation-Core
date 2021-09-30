package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private int currentPin = 0000;
    public IAccount linkedAcc;
    private boolean isAccLinked = false;

    private boolean isAcceptable(String pin){
        try{
            int n = Integer.parseInt(pin);
            return (pin.length() == 4);
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(IsPinValid(oldPin)){
            if(newPin.equals(newPinConfirm) && isAcceptable(newPin)){
                currentPin = Integer.parseInt(newPin);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(isAcceptable(pin)){
            return (currentPin == Integer.parseInt(pin));
        }
        else {
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) {
        if(!isAccLinked) {
            linkedAcc = account;
            isAccLinked = true;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(isAccLinked){
                linkedAcc.DepositFunds(amount);
                return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(isAccLinked){
                linkedAcc.WithdrawFunds(amount);
                return true;
        }
        return false;
    }
}
