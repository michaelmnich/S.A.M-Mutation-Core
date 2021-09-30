package com.uj.atm.common;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IAccount implements com.uj.atm.interfaces.IAccount {
    ReentrantLock externalLock;
    ReentrantLock accountLock;
    private BigDecimal accountBalance;

    public IAccount() {
        this.externalLock = new ReentrantLock(true);
        this.accountLock = new ReentrantLock(true);
        this.accountBalance = Helpers.CreateBigDecimal("0.00");
    }
//    I don't know if others will create this method also, so I am commenting out
//    public IAccount(double accountBalance) {
//        this.externalLock = new ReentrantLock(true);
//        this.accountLock = new ReentrantLock(true);
//        this.accountBalance = Helpers.CreateBigDecimal(Double.toString(accountBalance));
//    }

    private BigDecimal getAccountBalance() {
        return this.accountBalance;
    }

    private void setAccountBalance(BigDecimal newBalance) {
        this.accountBalance = newBalance;
    }

    private boolean checkIfZeroOrLess(BigDecimal value) {
        int tmp = value.compareTo(BigDecimal.ZERO);
        return (tmp == 0 || tmp < 0);
    }


    @Override
    public double AccountStatus() {
        return this.getAccountBalance().doubleValue();
    }

    @Override
    public double DepositFunds(double amount) {
        accountLock.lock();
        try {
            BigDecimal convertedAmount = Helpers.CreateBigDecimal(Double.toString(amount));
            if (this.checkIfZeroOrLess(convertedAmount)) {
                return this.getAccountBalance().doubleValue();
            }
            BigDecimal newBalance = Helpers.SetScaleInBigDecimal(this.getAccountBalance().add(convertedAmount));

            this.setAccountBalance(newBalance);
            return newBalance.doubleValue();
        } finally {
            accountLock.unlock();
        }
    }


    @Override
    public double WithdrawFunds(double amount) {
        // it should return tuple (status: bool, currentAccountBalance: double)
        accountLock.lock();
        try {
            BigDecimal convertedAmount = Helpers.CreateBigDecimal(Double.toString(amount));
            if (this.checkIfZeroOrLess(convertedAmount)) {
                return this.getAccountBalance().doubleValue();
            }
            BigDecimal newBalance = Helpers.SetScaleInBigDecimal(this.getAccountBalance().subtract(convertedAmount));

            if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                // return (false, this.getAccountBalance().doubleValue())
                return this.getAccountBalance().doubleValue();
            }

            this.setAccountBalance(newBalance);
            // return (true, this.getAccountBalance().doubleValue())
            return this.getAccountBalance().doubleValue();
        } finally {
            accountLock.unlock();
        }
    }

    @Override
    public Lock getExternalLockInstance() {
        return this.externalLock;
    }
}
