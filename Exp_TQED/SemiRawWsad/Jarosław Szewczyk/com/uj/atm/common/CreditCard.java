package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private String Pin = "0000";
    private IAccount Account = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        String pinPattern = "^\\d{4}$";
        if (!oldPin.matches(pinPattern) ||
                !newPin.matches(pinPattern) ||
                !newPinConfirm.matches(pinPattern)) {
            return false;
        }

        if (this.Pin.equals(oldPin) && newPin.equals(newPinConfirm) && !newPin.equals(oldPin)) {
            this.Pin = newPin;
            return true;
        }

        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        String pinPattern = "^\\d{4}$";
        if (pin.matches(pinPattern)) {
            return pin.equals(this.Pin);
        }
        return false;
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.Account != null || account == null) return;
        this.Account = account;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.Account == null || amount <= 0) {
            return false;
        }
        double accountBalanceBeforeWithdraw = this.Account.AccountStatus();
        double operationResult = this.Account.WithdrawFunds(amount);

        return (accountBalanceBeforeWithdraw - amount) == operationResult;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.Account == null) {
            return false;
        }
        double accountBalanceBeforeDeposit = this.Account.AccountStatus();
        double operationResult = this.Account.DepositFunds(amount);

        return (accountBalanceBeforeDeposit + amount) == operationResult && accountBalanceBeforeDeposit != operationResult;
    }
}
