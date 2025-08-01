package com.uj.atm.common;

import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private String PIN = "0000";
    private boolean Stowarzyszona = false;
    private Account account = null;

    public String getPIN() {
        return PIN;
    }

    public boolean isStowarzyszona() {
        return Stowarzyszona;
    }

    public Account getAccount() {
        return account;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setStowarzyszona(boolean stowarzyszona) {
        Stowarzyszona = stowarzyszona;
    }

    public void setAccount(Account account) {
        this.account = account;
        setStowarzyszona(true);
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(oldPin.equals(PIN)) {
            if(newPin.equals(newPinConfirm)) {
                setPIN(newPin);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(pin.equals(PIN))
            return true;
        return false;
    }

    @Override
    public void AddAccount(Account account) {
        if(Stowarzyszona == false) {
            setAccount(account);
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(account != null) {
            double currentSaldo = account.AccountStatus();
            if(account.DepositFunds(amount) == (currentSaldo + amount))
                return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(account != null) {
            double currentSaldo = account.AccountStatus();
            if(account.WithdrawFunds(amount) == (currentSaldo - amount))
                return true;
        }
        return false;
    }
}
