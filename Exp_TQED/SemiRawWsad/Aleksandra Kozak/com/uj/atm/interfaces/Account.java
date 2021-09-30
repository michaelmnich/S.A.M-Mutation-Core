package com.uj.atm.interfaces;

import jdk.jshell.Snippet;

public class Account implements IAccount{
    double AccountStatus;
    @Override
    public double AccountStatus() {
        return AccountStatus;
    }

    @Override
    public double DepositFunds(double amount) {
        AccountStatus = AccountStatus() + amount;
        return AccountStatus();
    }

    @Override
    public double WithdrawFunds(double amount) {
        AccountStatus = AccountStatus() - amount;
        return AccountStatus();
    }
}
