package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCardSample implements ICreditCard {

    private String pin = "0000";
    private IAccount bindedAccount;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(pin.equals(oldPin) && newPin.equals(newPinConfirm)){
            pin = newPin;
            return true;
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
            return this.pin.equals(pin);
    }

    @Override
    public void AddAccount(IAccount account) {
        if(account != null){
            if(bindedAccount == null){
                bindedAccount = account;
            } else {
                throw new IllegalArgumentException("Card has already binded account");
            }
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(bindedAccount != null) {
            bindedAccount.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(bindedAccount != null){
            bindedAccount.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
