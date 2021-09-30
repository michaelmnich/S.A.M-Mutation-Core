package com.uj.atm.common;
import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    public double balance;

    @Override
    public double AccountStatus(){
        return balance;
    }

    @Override
    public double DepositFunds(double amount){
        if(amount>0) {
            balance = balance + amount;
            return balance;
        } else throw new IllegalArgumentException("Amount must be > 0 !!");
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (balance >= amount && amount>0) {
            balance = balance - amount;
            return balance;
        } else throw new IllegalArgumentException("Amount must be > 0 and amount must be > balance!!");
    }

}
