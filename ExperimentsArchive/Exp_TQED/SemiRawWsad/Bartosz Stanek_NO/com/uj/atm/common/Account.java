package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    double balance;
    int acc_ID;

    public Account(double v, int id) {
        this.balance=v;
        this.acc_ID=id;
    }

    @Override
    public double AccountStatus() {
        return balance;
    }

    @Override
    public double DepositFunds(double amount) {
        return balance+amount;

    }

    @Override
    public double WithdrawFunds(double amount) {
        if (balance-amount<=0 || balance ==0){
            System.out.println("Cannot withdraw funds, your balance would be below 0!!");
            return balance;
        }
        else{
            System.out.println("....");
        }

            return balance - amount;
        }

}
