package com.uj.atm;

import com.uj.atm.interfaces.IAccount;

import static java.lang.Math.abs;

public class Account implements IAccount {

    private double cashBalance;

    public Account(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    @Override
    public double AccountStatus() {
        return cashBalance;
    }

    @Override
    public double DepositFunds(double amount) {

        if (amount > 0) {
            this.cashBalance = (AccountStatus() + abs(amount));
        }
        return AccountStatus();
    }

    @Override
    public double WithdrawFunds(double amount) {

        if (amount > 0) {
            this.cashBalance = (AccountStatus() - abs(amount));
        }
        return AccountStatus();
    }

}
