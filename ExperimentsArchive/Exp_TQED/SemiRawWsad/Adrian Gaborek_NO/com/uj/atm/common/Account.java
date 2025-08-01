package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    private double accountStatus;

    public Account() {
        this.accountStatus = 0;
    }

    @Override
    public double AccountStatus() {
        return accountStatus;
    }

    @Override
    public double DepositFunds(double amount) {
        if(Double.isFinite(amount)) {
            setAccountStatus(AccountStatus() + Math.max(0, amount));
        }
        return AccountStatus();
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(Double.isFinite(amount)) {
            setAccountStatus(AccountStatus() - Math.max(0, amount));
        }
        return AccountStatus();
    }

    private void setAccountStatus(double newAccountStatus) {
        this.accountStatus = Math.max(newAccountStatus, 0);
    }
}
