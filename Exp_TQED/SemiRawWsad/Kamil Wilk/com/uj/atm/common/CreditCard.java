package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    public String pin = "0000";
    public IAccount account = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(oldPin.equals(this.pin) && newPin.equals(newPinConfirm)){
            this.pin = newPin;
            return true;
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(pin.equals(this.pin)){
            return true;
        }
        return false;
    }

    @Override
    public void AddAccount(IAccount account) {
        if(this.account == null) {
            this.account = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(this.account != null){
            this.account.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(this.account != null){
            double accountstatusTemp = this.account.AccountStatus();
            this.account.WithdrawFunds(amount);
            if(accountstatusTemp != this.account.AccountStatus()){
                return true;
            }

        }
        return false;
    }
}
