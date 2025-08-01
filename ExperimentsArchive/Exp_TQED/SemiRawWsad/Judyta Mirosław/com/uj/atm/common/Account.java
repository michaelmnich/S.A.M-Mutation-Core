package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double saldo = 0;

    public Account(double saldo) {
        if(saldo >= 0)
            this.saldo = saldo;
        else
            this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double AccountStatus() {
        return getSaldo();
    }

    @Override
    public double DepositFunds(double amount) {
        saldo += amount;
        return saldo;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(saldo >= amount) {
            saldo -= amount;
            return saldo;}
        else
            return 0;
    }
}
