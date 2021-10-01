package com.uj.atm.common;


import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {


    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if (creditCard.IsPinValid(pin)) {
            return true;

        } else
            return false;


    }

    @Override
    public double AccountStatus(IAccount account) {
        if(account.AccountStatus()>0) {
            return account.AccountStatus();
        }
        else  throw new IllegalArgumentException("Balans na koncie nie może być ujemny");
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        return card.ChangePin(oldPin, newPin, newPinConfirm);
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        return card.DepositFunds(amount);


    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        return card.WithdrawFunds(amount);
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
      if( card.WithdrawFunds(amount)) {
          accountRecipient.DepositFunds(amount);
      return true;
      }else
          return false;

    }
}
