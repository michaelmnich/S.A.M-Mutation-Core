package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements IAccount {
    private double currentBalance = 0.0;
    @Override
    public double AccountStatus() {
        return currentBalance;
    }

    @Override
    public double DepositFunds(double amount) {
        if(amount >= 0) {
            Double roundedAmount = BigDecimal.valueOf(amount)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
            return currentBalance += roundedAmount;
        }
        else return AccountStatus();
    }

    @Override
    public double WithdrawFunds(double amount) {
        if(amount >= 0 && amount <= currentBalance) {
            Double roundedAmount = BigDecimal.valueOf(amount)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            return currentBalance -= roundedAmount;
        }
        else return AccountStatus();
    }
}
