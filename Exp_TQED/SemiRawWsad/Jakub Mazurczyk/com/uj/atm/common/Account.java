package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double Saldo = 0;

    @Override
    public double AccountStatus() {
        return this.Saldo;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount > 0) {

            this.Saldo = this.Saldo + amount;
        }
        return this.Saldo;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (amount > 0 && this.AccountStatus()>=amount) {

            this.Saldo = this.Saldo - amount;
            return this.Saldo;
        }else
        {
            return -1;
        }

    }
}