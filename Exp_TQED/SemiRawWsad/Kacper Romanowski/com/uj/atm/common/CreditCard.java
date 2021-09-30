package com.uj.atm.common;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    private String pinX;
    private IAccount acc;

    public CreditCard() { this.pinX="0000"; }
    public CreditCard(String pin) { this.pinX=pin; }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (IsPinValid(oldPin)){
            if(newPin.equals(newPinConfirm)){
                pinX = newPin;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        return pinX.equals(pin);
    }

    @Override
    public void AddAccount(IAccount account) {
        acc = account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(amount<0){
            throw new IllegalArgumentException("Ammount can not be negative value ");
        }
        acc.DepositFunds(amount);
        return true;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(acc.AccountStatus()-amount<0){
            throw new IllegalArgumentException("Withdraw ammount can not be higher than account's balance");
        }
        acc.WithdrawFunds(amount);
        return true;
    }
}