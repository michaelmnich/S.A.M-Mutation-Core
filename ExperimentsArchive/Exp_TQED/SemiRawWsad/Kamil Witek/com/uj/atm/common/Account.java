package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    private double saldo = 0;

    @Override
    public double AccountStatus() {
        return this.saldo;
    }

    @Override
    public double DepositFunds(double amount) {
        this.saldo += amount;
        return saldo;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(this.saldo >= amount) {
            this.saldo -= amount;
        }
        return saldo;
    }
}
