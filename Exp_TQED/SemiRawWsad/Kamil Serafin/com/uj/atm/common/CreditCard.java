package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private String PIN = "0000";

    public IAccount account;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (this.account == null) {
            return false;
        }

        if (!(newPin.matches("^[0-9]{4}+$"))) {
            return false;
        }

        if (!oldPin.equals(PIN)) {
            return false;
        }

        if (oldPin.equals(newPin)) {
            return false;
        }

        if (!newPin.equals(newPinConfirm)) {
            return false;
        }

        PIN = newPin;

        return true;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (!(pin.matches("^[0-9]{4}+$"))) {
            return false;
        }

        return PIN.equals(pin);
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.account == null) {
            this.account = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.account == null) {
            return false;
        }

        return this.account.DepositFunds(amount) == this.account.AccountStatus();
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.account == null) {
            return false;
        }

        if (this.account.AccountStatus() < amount) {
            return false;
        }

        return this.account.DepositFunds(amount) == this.account.AccountStatus();
    }
}
