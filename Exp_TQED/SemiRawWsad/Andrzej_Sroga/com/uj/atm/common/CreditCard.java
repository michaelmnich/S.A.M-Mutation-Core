package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    private String _oldPin=null;
    private String _pin;
    public IAccount iaccount=null;

    public CreditCard(){};
    public CreditCard(String pin) {
        _pin=pin;
    }

    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm){

        if(newPin==newPinConfirm&&_pin==oldPin){
            _oldPin=oldPin;
            _pin=newPin;
            return true;
        }
        return false;
    }

    public boolean IsPinValid(String pin){

        if (pin.matches("[0-9]+")&& pin.length() ==4){
            return true;
        }
        return false;
    }

    public void AddAccount(IAccount account){
        if(iaccount==null){
            iaccount=account;
        }else{
            System.out.println("cannot assign more than 1 cards to account");
        }
    }

    public boolean DepositFunds(double amount){

        if(iaccount==null){
            System.out.println("no card assigned to account");
            return false;
        }
        iaccount.DepositFunds(amount);
        return true;
    }

    public boolean WithdrawFunds(double amount){

        if(iaccount==null){
            System.out.println("no card assigned to account");
            return false;
        }
        iaccount.WithdrawFunds(amount);
        return true;
    }
}
