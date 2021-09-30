package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class AccountSample implements IAccount {

    private double balance;

    public AccountSample(double balance){
        if(balance >= 0){
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be less than 0");
        }

    }

    @Override
    public double AccountStatus() {
        return balance;
    }

    @Override
    public double DepositFunds(double amount) {
        if(amount > 0){
            balance += amount;
        }
        return balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(amount > 0){
            if(balance >= amount){
                balance -= amount;
            } else{
                throw new IllegalArgumentException("You don't have enough money");
            }
        }
        return balance;
    }
}
