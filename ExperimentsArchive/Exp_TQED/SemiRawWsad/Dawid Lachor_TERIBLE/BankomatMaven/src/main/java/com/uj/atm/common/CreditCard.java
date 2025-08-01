package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private Account account;
    private String pin = "0000";

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (!oldPin.equals(pin)) {
            return false;
        }
        if (!newPin.equals(newPinConfirm)) {
            return false;
        }
        if (newPin.length() != 4) {
            return false;
        }
        try {
            Double.parseDouble(newPin);
        } catch (NumberFormatException e) {
            return false;
        }

        pin = newPin;
        return true;
    }

    @Override
    public boolean IsPinValid(String pin) {
        return pin.equals(this.pin);
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.account != null) {
            throw new IllegalArgumentException("Card has assign account");
        }
        if (account == null) {
            throw new IllegalArgumentException("Account can't be null");
        }

        this.account = (Account) account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (amount <= 0 || account == null)
            return false;

        account.DepositFunds(amount);
        return true;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (amount <= 0)
            return false;
        if (account.AccountStatus() - amount < 0)
            return false;

        account.WithdrawFunds(amount);
        return true;
    }
}
