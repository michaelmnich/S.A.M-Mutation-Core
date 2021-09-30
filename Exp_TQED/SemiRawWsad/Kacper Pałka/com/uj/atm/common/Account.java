package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    private double balance;

    public Account() {
        this.balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double AccountStatus() {

        return balance;
    }

    public double DepositFunds(double amount) {
        balance =+ amount;

        return balance;
    }
    public double WithdrawFunds(double amount) {
        if(balance >= amount)
            balance = balance - amount;
        else
            throw new RuntimeException("Insufficient Funds");
        return balance;
    }
}
