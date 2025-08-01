package com.uj.atm.common;
import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private  double balance;

    public Account() {
        balance = 0;
    }

    public Account(double balance) {
        this.balance=balance;
    }

    @Override
    public double AccountStatus() {

        return balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if(amount<0){
            throw new IllegalArgumentException("Ammount can not be negative value ");
        }
        balance += amount;
        return balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (0>balance-amount){
            throw new IllegalArgumentException("Balance can not be negative value");
        }
        balance -= amount;
        return balance;
    }
}
