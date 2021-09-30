package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

import java.text.DecimalFormat;

public class Account implements IAccount {

    private double balance = 0;

    @Override
    public double AccountStatus() {
        return balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount >= 0)
            balance += amount;

        return balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if ((amount >= 0) && ((balance - amount) >= 0))
            balance -= amount;

        return balance;
    }
}
