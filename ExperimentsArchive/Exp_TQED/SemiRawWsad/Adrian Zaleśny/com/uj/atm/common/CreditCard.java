package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private Account account = null;
    public String pin;

    public String getPin() {
        return pin;
    }

    public CreditCard() {
        this.pin = "0000";
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin.equals(this.getPin()) && newPin.equals(newPinConfirm) && newPin.length() == 4) {
            this.setPin(newPin);
            return true;
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        return pin.equals(this.getPin());
    }

    @Override
    public void AddAccount(IAccount account) {
        Account account_1 = (Account) account;
        account_1.setObjects_credit_card(this);
        this.account = (Account) account;
    }


    @Override
    public boolean DepositFunds(double amount) {
        if (this.account != null){
            this.account.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.account != null){
            this.account.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
