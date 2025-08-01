package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    IAccount Aaccount = null;
    String accountPin = "0000";

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin == accountPin) {
            if (newPin.length() == 4 && newPin.compareTo(accountPin) != 0) {
                if (newPin == newPinConfirm) {
                    accountPin = newPin;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (pin.equals(accountPin)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) {
         Aaccount = account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (Aaccount != null) {
            if (amount > 0) {
                double y = Aaccount.AccountStatus();
                double x = Aaccount.DepositFunds(amount);
                if (y != x) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (amount > 0) {
            double y = Aaccount.AccountStatus();
            double x = Aaccount.DepositFunds(amount);
            if (y != x) {
                return true;
            }
        }
        return false;
    }
}
