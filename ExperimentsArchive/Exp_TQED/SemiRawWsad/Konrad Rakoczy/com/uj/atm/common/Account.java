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
        balance = balance + amount;

        return balance;
    }

    @Override
    public double WithdrawFunds(double amount) {

        if (balance >= amount)
            balance = balance - amount;
        else
            System.out.println("Kwota wyplacana jest wieksza niz saldo.");

        return balance;
    }

}
