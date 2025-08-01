package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private String PIN = "0000";
    private Account konto = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {

      if(oldPin.equals(this.PIN))
          if(newPin.matches("[0-9]{4}") && newPinConfirm.equals(newPin)){
            this.PIN = newPin;
          return true;}
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (pin.matches("[0-9]{4}")){
            if(pin.equals(this.PIN))
            return true;}
        return  false;
    }

    @Override
    public boolean AddAccount(IAccount account) {

        if(this.konto == null){
            this.konto = (Account) account;
            return true;
        }return false;


    }

    @Override
    public boolean DepositFunds(double amount) {
        if(this.konto != null){
        if(konto.DepositFunds(amount)>=konto.AccountStatus())

            return true;
        }

        return false;
    }
    @Override
    public boolean WithdrawFunds(double amount) {
        if(this.konto != null) {
            double status = konto.AccountStatus();
            double wynik = konto.WithdrawFunds(amount);
            if (wynik == -1)
                return false;
            return true;

        }
        return false;
    }
}
