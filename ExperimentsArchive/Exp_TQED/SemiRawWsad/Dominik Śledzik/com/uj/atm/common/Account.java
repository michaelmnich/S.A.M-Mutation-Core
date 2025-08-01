package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    double saldo = 0;

    @Override
    public double AccountStatus(){
        return saldo;
    }

    @Override
    public double DepositFunds(double amount){
        if(amount > 0){
            saldo += amount;
        }
        return saldo;
    }

    @Override
    public double WithdrawFunds(double amount){
        if(amount>0){
            if(amount<=saldo){
                saldo -= amount;
            }
        }
    return saldo;
    }
}
