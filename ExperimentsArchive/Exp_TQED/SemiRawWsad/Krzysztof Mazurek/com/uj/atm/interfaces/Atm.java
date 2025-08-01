package com.uj.atm.interfaces;

public class Atm implements IAtm{


    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if(pin.length()==4){
            if ( creditCard.IsPinValid(pin) ){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public double AccountStatus(IAccount account) {
        return account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {

        if ( card.ChangePin(oldPin, newPin, newPinConfirm) == true ){
            return  true;
        } else {
            return false;}
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if (card.DepositFunds(amount) == true){
            return  true;
        }else {
            return false;
        }

    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if (card.WithdrawFunds(amount) == true){
            return  true;
        }else {
            return false;
        }
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        double stan = accountRecipient.AccountStatus();
        if (card.WithdrawFunds(amount) == true) {
            if (accountRecipient.DepositFunds(amount) == stan+amount ) {
                return true;
            }else {
                card.DepositFunds(amount);
                return false;
            }
        } else {
            return false;
        }
    }
}