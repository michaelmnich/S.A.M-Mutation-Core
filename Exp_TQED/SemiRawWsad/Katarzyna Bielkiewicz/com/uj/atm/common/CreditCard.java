package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    private Integer pinCorrect;
    public IAccount account;

    public CreditCard() {

        this.pinCorrect = 0000;

    }


    private boolean PinForm (String pin) {
        if(pin.length() == 4 && pin.matches("[0-9][0-9][0-9][0-9]")) {
            return true;}

        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {

        if (PinForm(pin)) {
            if (Integer.parseUnsignedInt(pin) == pinCorrect) {
                return true;
            }
        }
        return false;
    }



    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (IsPinValid(oldPin)) {
            if (PinForm(newPin)) {
                if (Integer.parseUnsignedInt(newPin) == Integer.parseUnsignedInt(newPinConfirm)) {
                    if (Integer.parseUnsignedInt(newPin) != Integer.parseUnsignedInt(oldPin)) {
                        pinCorrect = Integer.parseUnsignedInt(newPin);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public void AddAccount(IAccount account) {
        if(this.account == null) {
            this.account = account;
        }
        else{
        throw new IllegalArgumentException("Do tej karty jest już przypisane konto");
        }

    }

    @Override
    public boolean DepositFunds(double amount) {
        if(amount > 0 && account!= null) {
            account.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(amount > 0 && account != null && account.AccountStatus() >=amount) {
            account.WithdrawFunds(amount);
            return  true;
        }
        return false;
    }


}

