package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    private String pin;
    private boolean created_account;
    private IAccount account;

    public CreditCard(String pin) {
        this.pin = pin;
        this.created_account = false;
        this.account = null;
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin.equals(this.pin)) {
            if (newPin.equals(newPinConfirm)) {
                if (newPin.length() == 4 && newPinConfirm.length() == 4) {
                    if (this.CheckInteger(newPin)) {
                        this.pin = newPin;
                        return true;
                    }
                }
                return false;
            }
//            pin was not changed
            return false;
        }
//        pin was not changed
        return false;
    }

    public boolean CheckInteger(String num) {
        int value;
        try {
            value = Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (this.pin.equals(pin) && this.CheckInteger(pin)) {
            return true;
        }
        return false;
    }

    @Override
    public void AddAccount(IAccount new_account) {
        if (this.created_account == false) {
            this.account = new_account;
            this.created_account = true;
            System.out.println("Connected account");
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (amount > 0 && this.account != null) {
            this.account.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (amount > 0 && this.account != null) {
            this.account.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
