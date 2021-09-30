package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {
    ICreditCard cc;
    IAccount account;

    public Atm(ICreditCard cc, IAccount account) {
        this.cc = cc;
        this.account = account;
    }


    @Override
    public boolean CheckPinAndLogIn(ICreditCard cc, String pin) {
        if(this.cc!=null){
            cc.IsPinValid(pin);
            return true;
        }
        return false;
    }

    @Override
    public double AccountStatus(IAccount account) {
        return this.account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if(this.cc!=null){
            cc.ChangePin(oldPin,newPin,newPinConfirm);
            return true;
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if(this.cc!=null) {
            cc.DepositFunds(amount);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if (this.cc!=null){
            cc.WithdrawFunds(amount);
            return true;
        }

        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if(accountRecipient!=null && card!=null){

            if(accountRecipient.AccountStatus()>0 && accountRecipient.AccountStatus()>amount)
                card.WithdrawFunds(amount);
                accountRecipient.DepositFunds(amount);
            return true;
        }


        return false;
    }
}
