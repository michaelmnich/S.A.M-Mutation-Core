package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double saldo;

    public Account(){
        saldo = 0 ;
    }

    public Account(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double AccountStatus() {
        return saldo;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount > 0 ){
            saldo = saldo + amount;
            return  saldo;
        }
        else {
            return saldo;
        }
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (amount >= 0 ){
            if (amount <= this.saldo){
                this.saldo = this.saldo - amount;
                return  this.saldo;
            }
            else {
                return this.saldo;
            }
        }
        else {
            return this.saldo;
        }
    }
}
