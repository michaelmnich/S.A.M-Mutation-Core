package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double balance = 0;

    @Override
    public double AccountStatus() {
        return balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount >  0){
            this.balance += amount;
        }
        return this.balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (amount < 0){
            return  this.balance;
            }
        if (amount <= this.balance) {
            this.balance -= amount;
            return this.balance;
        }
        else {
            throw new IllegalArgumentException("Can't withdraw more than deposited!");
        }
    }
}
