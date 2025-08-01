package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private String Pin = "0000";
    private IAccount myAccount;
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        for (int i=0;i<4;i++) {
            char c = newPin.charAt(i);
            if(c<'0' || c>'9') return false;
        }
        if(oldPin.equals(this.Pin) && newPin.equals(newPinConfirm)){
            this.Pin =new String(newPin);
            return true;
        }
        else
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        return pin.equals(this.Pin);
    }

    @Override
    public void AddAccount(IAccount account) {
        if(this.myAccount == null)
        this.myAccount=account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(this.myAccount == null)return false;
        else{
            this.myAccount.DepositFunds(amount);
            return true;
        }

    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(this.myAccount == null || this.myAccount.AccountStatus()<amount)return false;
        else{
            this.myAccount.WithdrawFunds(amount);
            return true;
        }
    }
}
