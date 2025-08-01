package com.uj.atm.interfaces;

public class Account implements  IAccount{
double saldo;
    @Override
    public double AccountStatus() {
        return saldo;
    }

    @Override
    public double DepositFunds(double amount) {
        saldo = AccountStatus()+amount;
        return saldo;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(amount<=AccountStatus()){
            saldo=AccountStatus()-amount;
        }else{
            System.out.println("Nie posiadasz takich środków!");
        }
        return saldo;
    }
}
