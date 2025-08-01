package com.uj.atm;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    double balance;

    public Account(double balance) {
        if(balance > 0) {
            this.balance = balance;
        }
    }

    @Override
    public double AccountStatus() {
        return this.balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if(amount>0)
            return this.balance += amount;
        System.out.println("Kwota ma być dodatnia!");
        return this.balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(amount>0)
            return this.balance -= amount;
        System.out.println("Kwota ma być dodatnia!");
        return this.balance;
    }
}
