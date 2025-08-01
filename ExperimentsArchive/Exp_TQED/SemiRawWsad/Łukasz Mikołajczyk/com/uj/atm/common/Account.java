package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    private double accoount_balance;

    public Account(double accoount_balance) {
        this.accoount_balance = accoount_balance;
    }

    @Override
    public double AccountStatus() {
        return this.accoount_balance;
    }

    @Override
    public double DepositFunds(double amount) {
        this.accoount_balance += amount;
        return this.accoount_balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (this.accoount_balance - amount < 0) {
            System.out.println("Can\'t withraw moneny, you don\'t have enough money.");
            return -1;
        }
        this.accoount_balance -= amount;
        return this.accoount_balance;
    }
}
