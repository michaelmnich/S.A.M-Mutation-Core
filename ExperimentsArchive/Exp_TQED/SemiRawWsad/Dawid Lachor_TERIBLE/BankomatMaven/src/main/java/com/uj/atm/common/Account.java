package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

import java.math.BigDecimal;

public class Account implements IAccount {
    private double bankBalance;

    @Override
    public double AccountStatus() {
        return bankBalance;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount can't by negative or equal 0");
        }
        bankBalance = (BigDecimal.valueOf(amount).add(BigDecimal.valueOf(bankBalance))).doubleValue();
        return bankBalance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount can't by negative or equal 0");
        }
        if (bankBalance - amount < 0){
            throw new RuntimeException("Amount can't be more the bankBalance");
        }
        bankBalance = (BigDecimal.valueOf(bankBalance).subtract(BigDecimal.valueOf(amount))).doubleValue();
        return bankBalance;
    }
}
