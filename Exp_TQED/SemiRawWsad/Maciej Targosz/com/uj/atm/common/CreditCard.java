package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private String pindoKarty = "0000";
    private Account konto = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm){
        if(oldPin.equals(this.pindoKarty)){
            if(newPin.length()==4 && newPin.equals(newPinConfirm)){
                this.pindoKarty = newPin;
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }

    @Override
    public boolean IsPinValid(String pin) {
        return pin.equals(this.pindoKarty);
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.konto==null){
            this.konto = (Account) account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(this.konto!=null){
            this.konto.DepositFunds(amount);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(this.konto!=null){
            this.konto.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
