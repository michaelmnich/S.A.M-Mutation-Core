package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {
        balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public double AccountStatus() {
        return balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if(amount < 0) {
             throw new IllegalArgumentException("Proszę podać dodatnią kwotę do wpłaty");
        }
        balance += amount;
        return balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Bilans po wypłacie nie może być ujemny");
        }
        balance -= amount;
        return balance;
    }
}