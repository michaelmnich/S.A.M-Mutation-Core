package com.uj.atm.common;


import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    double balance = 0;

    @Override
    public double AccountStatus() {
        return this.balance;
    }

    @Override
    public double DepositFunds(double amount) {
        this.balance = balance + amount;
        return balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(this.balance >= amount) {
            this.balance = balance - amount;
        }
        return balance;
    }
}
