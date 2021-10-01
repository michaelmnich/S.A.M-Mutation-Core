package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {
    private String pin = "0000";
    private CreditCard karta;

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin){
        int dugosc;
        dugosc = pin.length();
        if(dugosc==4){
            if(creditCard.IsPinValid(pin)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public double AccountStatus(IAccount account){
        double obecnyStatus = account.AccountStatus();
        return obecnyStatus;
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm){
        if(card.ChangePin(oldPin, newPin, newPinConfirm)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount){
        if(card.DepositFunds(amount)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount){
        if(card.WithdrawFunds(amount)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount){
        if(card.WithdrawFunds(amount)){
            accountRecipient.DepositFunds(amount);
            return true;
        }
        else{
            return false;
        }
    }
}
