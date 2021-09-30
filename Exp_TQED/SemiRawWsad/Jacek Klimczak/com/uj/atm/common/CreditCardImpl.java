package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.util.Objects;

public class CreditCardImpl implements ICreditCard {
    private IAccount account = null;
    private String pin = "0000";

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin == null || newPin == null || newPinConfirm == null)
            return false;

        if (!IsPinValid(oldPin))
            return false;

        if (!isNewPinValid(newPin, newPinConfirm))
            return false;

        this.pin = newPin;

        return true;
    }

    @Override
    public boolean IsPinValid(String pin) {
        return Objects.equals(this.pin, pin);
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.account == null)
            this.account = account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.account == null)
            return false;

        double balanceBeforeDeposit = account.AccountStatus();
        double newBalance = account.DepositFunds(amount);

        return newBalance != balanceBeforeDeposit;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.account == null)
            return false;

        double balanceBeforeWithdraw = account.AccountStatus();
        double newBalance = account.WithdrawFunds(amount);

        return newBalance != balanceBeforeWithdraw;
    }

    private boolean isNewPinValid(String newPin, String newPinConfirm) {
        if (newPin.length() != 4)
            return false;

        if (newPin.startsWith("-") || newPin.startsWith("+"))
            return false;

        try
        {
            int newPinNumeric = Integer.parseInt(newPin);
            int newPinConfirmNumeric = Integer.parseInt(newPinConfirm);

            if (newPinNumeric != newPinConfirmNumeric)
                return false;

        } catch (NumberFormatException e)
        {
            return false;
        }

        return true;
    }
}
