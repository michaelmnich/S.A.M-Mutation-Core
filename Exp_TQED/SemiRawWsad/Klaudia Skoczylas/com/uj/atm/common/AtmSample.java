package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class AtmSample implements IAtm {
    private ICreditCard crCard;
    private IAccount accountN;

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        this.crCard = creditCard;
        if(this.crCard.IsPinValid(pin) == true){
            return true;
        } else{
            return false;
        }

    }

    @Override
    public double AccountStatus(IAccount account) {
        this.accountN = account;
        return account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        this.crCard = card;
        if(card.ChangePin(oldPin, newPin, newPinConfirm) == true){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        this.crCard = card;
        if(card.DepositFunds(amount) == true){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        this.crCard = card;
        if(card.WithdrawFunds(amount) == true){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        this.crCard = card;
        this.accountN = accountRecipient;

        if(card.WithdrawFunds(amount) == true){
            accountRecipient.DepositFunds(amount);
            return true;
        }
        else{
            return false;

        }

    }
}
