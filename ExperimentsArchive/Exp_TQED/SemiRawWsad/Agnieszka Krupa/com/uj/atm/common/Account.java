package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double account=0;

    public Account(double i) {
        account=i;
    }

    @Override
    public double AccountStatus() {
        return account;
    }

    @Override
    public double DepositFunds(double amount) {
        account+=amount;
        return account;
    }

    @Override
    public double WithdrawFunds(double amount) {
        account-=amount;
        return account;
    }
}
