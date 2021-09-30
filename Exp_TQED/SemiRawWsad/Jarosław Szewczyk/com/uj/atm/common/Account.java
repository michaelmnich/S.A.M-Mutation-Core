package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double Balance = 0.0;

    @Override
    public double AccountStatus() {
        return Balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount > 0) {
            if (this.Balance == Double.MAX_VALUE || (Double.MAX_VALUE - this.Balance) < amount) // prevent overflow max value of Double type
                return AccountStatus();
            else
                this.Balance = this.Balance + amount;
        }
        return AccountStatus();
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (this.AccountStatus() >= amount && amount > 0.0)
            this.Balance = this.Balance - amount;

        return AccountStatus();
    }

}
