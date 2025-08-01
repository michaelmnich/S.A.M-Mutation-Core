package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCardSample implements ICreditCard {

    private IAccount acountN;
    private String pinNumber = "0000";

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        oldPin = pinNumber;
        if(oldPin.equals(newPin)){
            System.out.println("Nowy PIN jest taki sam jak wcześniejszy.");
            return false;
        }
        else{
            if(newPin.equals(newPinConfirm)){
                oldPin = newPin;
                pinNumber = newPin;
                System.out.println("Twój nowy PIN: " + oldPin);
                return true;
            }
            else {
                System.out.println("PINy się różnią! Nowy PIN i jego potwierdzenie muszą być takie same");
                return false;
            }
        }
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(pinNumber.equals(pin)){
            System.out.println("PIN jest poprawny");
            return true;
        }
        else{
            System.out.println("PIN jest niepoprawny");
            return false;
        }

    }

    @Override
    public void AddAccount(IAccount account) {
        this.acountN = account;


    }

    @Override
    public boolean DepositFunds(double amount) {
       if( this.acountN == null){
           return false;
       }else{
           if(amount < 0)
               {
                   return false;
               } else {
                   this.acountN.DepositFunds(amount);
                   return true;
               }
           }
    }



    @Override
    public boolean WithdrawFunds(double amount) {
        if( this.acountN == null){
            return false;
        }else{
            if(this.acountN.AccountStatus() > 0)
            {
                if(amount < 0)
                {
                    return false;
                } else{
                if(this.acountN.AccountStatus() < amount)
                {
                    return false;
                }
                else{
                    this.acountN.WithdrawFunds(amount);
                    return true;
                }}
            }else{
                return false;
            }
        }
    }
}
