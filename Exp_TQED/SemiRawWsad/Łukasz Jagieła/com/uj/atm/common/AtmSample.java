package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class AtmSample implements IAtm {

    private final String regex = "[0-9]{4}";



    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if(pin != null && pin.matches(regex) && creditCard != null){
            return creditCard.IsPinValid(pin);
        } else{
            return false;
        }
    }

    @Override
    public double AccountStatus(IAccount account) {
        if(account != null){
            return account.AccountStatus();
        } else {
            throw new IllegalArgumentException("Account cannot be null");
        }
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if(card != null && newPinConfirm != null  && newPin != null && oldPin != null){
            if(oldPin.matches(regex) && newPin.matches(regex) && newPinConfirm.matches(regex)){
                if(newPin.equals(newPinConfirm)){
                    return card.ChangePin(oldPin, newPin, newPinConfirm);
                }
            }
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if(amount > 0){
            if(card != null){
                return card.DepositFunds(amount);
            }
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if(amount > 0){
            if(card != null){
                return card.WithdrawFunds(amount);
            }
        }
        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if(amount > 0 && card != null && accountRecipient != null){
            if(card.WithdrawFunds(amount)){
                accountRecipient.DepositFunds(amount);
                return true;
            }
        }
        return false;
    }
}
