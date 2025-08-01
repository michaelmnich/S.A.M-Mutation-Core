package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double balance;

    public Account() {

        this.balance = 0;
    }

    @Override
    public double AccountStatus() {

        return balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return balance; }
        else {
            throw new IllegalArgumentException("Liczba musi byc większa niż zero");
        }
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(balance-amount >= 0 && amount > 0) {
            balance = balance - amount;
            return balance;
        }
        else {
                throw new IllegalArgumentException("Liczba musi byc większa niż zero");
        }

    }




}
