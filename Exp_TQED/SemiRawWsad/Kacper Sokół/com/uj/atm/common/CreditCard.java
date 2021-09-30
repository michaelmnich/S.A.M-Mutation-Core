package com.uj.atm.common;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    public String pinX="0000";
    private IAccount acc;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (IsPinValid(oldPin)){
            if(newPin.equals(newPinConfirm) && newPin.matches("[0-9]{4}")){
                pinX = newPin;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if((pinX.equals(pin) && pinX.matches("[0-9]{4}"))) return true;
        return false;
    }

    @Override
    public void AddAccount(IAccount account) {
        acc = account;

    }

    @Override
    public boolean DepositFunds(double amount) {
        if(amount<0){
            throw new IllegalArgumentException("Amount can not be negative value!");
        }
        acc.DepositFunds(amount);
        return true;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(acc.AccountStatus()-amount<0){
            throw new IllegalArgumentException("Withdraw amount can not be higher than account's balance!");
        }
        acc.WithdrawFunds(amount);
        return true;
    }

}
