package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;


public class CreditCardSample implements ICreditCard {

    private String pin = "1234";
    private IAccount cardAccount;

    public CreditCardSample(){}

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(oldPin.equals(pin) && newPin.equals(newPinConfirm)) {
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
    public void AddAccount(IAccount account) throws IllegalArgumentException {
        if(account != null){
            if(cardAccount == null){
                this.cardAccount = account;
            }else{
                throw new IllegalArgumentException("Card has account");
            }
        }else{
            throw new IllegalArgumentException("Account cannot be null");
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(cardAccount != null){
            cardAccount.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(cardAccount != null){
            cardAccount.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
