package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    double saldo;
    {
        saldo = 0;
    }

    @Override
    public double AccountStatus() {
        return saldo;
    }

    @Override
    public double DepositFunds(double amount) {
        saldo=saldo+amount;
        return saldo;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(saldo-amount>0 && amount>0){
            saldo=saldo-amount;
        }
        return saldo;
    }

}
