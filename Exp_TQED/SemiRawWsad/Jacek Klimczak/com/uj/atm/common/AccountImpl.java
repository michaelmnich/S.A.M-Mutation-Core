package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class AccountImpl implements IAccount {

    private double amount = 0.0;

    @Override
    public double AccountStatus() {
        return amount;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount < 0)
            return AccountStatus();

        this.amount += amount;

        return AccountStatus();
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (amount < 0)
            return AccountStatus();

        if (this.amount < amount)
            return AccountStatus();

        this.amount -= amount;

        return AccountStatus();
    }
}
