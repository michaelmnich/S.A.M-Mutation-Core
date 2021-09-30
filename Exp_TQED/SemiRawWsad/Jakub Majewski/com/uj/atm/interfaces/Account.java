package com.uj.atm.interfaces;

public class Account implements IAccount{
    double Status = 100;

    @Override
    public double AccountStatus() {

        return Status;
    }

    @Override
    public double DepositFunds(double amount) {
        Status = AccountStatus() + amount;
        return AccountStatus();
    }

    @Override
    public double WithdrawFunds(double amount) {
        Status = AccountStatus() - amount;
        return AccountStatus();
    }
}
