package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    private String pin = "0000";
    public IAccount konto = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        String regex = "[0-9][0-9][0-9][0-9]";
        if(oldPin.equals(this.pin) && newPin.matches(regex) && newPin.equals(newPinConfirm)){
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
        if(this.konto == null) {
            this.konto = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(this.konto != null){
            this.konto.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(this.konto != null){
            double stareSaldo = this.konto.AccountStatus();
            this.konto.WithdrawFunds(amount);
            if(stareSaldo != this.konto.AccountStatus()){
                return true;
            }

        }
        return false;
    }
}
