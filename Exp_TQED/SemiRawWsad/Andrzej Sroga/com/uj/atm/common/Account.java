package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

    private double _balance;
    private int _actionTimeWaiting; //ms

    public Account(double balance) {
        this._balance = balance;
    }

    public Account(double balance, int actionTimeWaiting) {
        this._balance = balance;
        this._actionTimeWaiting=actionTimeWaiting;
    }

    @Override
    public double AccountStatus(){
        return _balance;
    }

    @Override
    public double DepositFunds(double amount){
        return _balance+=amount;
    }

    @Override
    public double WithdrawFunds(double amount){
        if(amount>_balance){
            System.out.println("You have not enough money in deposit");
            return _balance;
        }
        return _balance-=amount;
    }
}
