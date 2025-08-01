package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    String Pin="0000";
    IAccount account;
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(oldPin==Pin && newPin==newPinConfirm){
            Pin=newPin;
            return true;
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(Pin==pin) {
            Pin = pin;
            return true;
        }
        return false;
    }

    @Override
    public void AddAccount(IAccount account) {
    this.account=account;

    }

    @Override
    public boolean DepositFunds(double amount) {
        if(account!=null){
            account.DepositFunds(amount);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(account!=null && account.AccountStatus()>amount) {
            account.WithdrawFunds(amount);
            return true;
        }
        else
            return false;
    }
}
