package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import static java.lang.Integer.parseInt;

public class CreditCard implements ICreditCard {
    public int pin = 0;
    public IAccount account = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        try {
            if ((parseInt(oldPin) == pin) && (newPin.length() == 4))
                if (newPin.equals(newPinConfirm)) {
                    pin = parseInt(newPin);
                    return true;
                }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        try {
            if ((parseInt(pin) == this.pin) && (pin.length() == 4))
                return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return false;
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.account == null)
            this.account = account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.account != null) {
            double tmp_balance = account.AccountStatus();
            account.DepositFunds(amount);

            return tmp_balance != account.AccountStatus();
        } else
            return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.account != null) {
            double tmp_balance = account.AccountStatus();
            account.WithdrawFunds(amount);

            return tmp_balance != account.AccountStatus();
        } else
            return false;
    }
}
