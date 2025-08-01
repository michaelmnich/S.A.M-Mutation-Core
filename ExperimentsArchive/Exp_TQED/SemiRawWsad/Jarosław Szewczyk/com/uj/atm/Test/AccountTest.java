package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


public class AccountTest {

    @Test
    public void TestDefaultAccountBalance() {
        IAccount account = new Account();
        double result = account.AccountStatus();
        Assert.assertTrue("Initial Balance does not have zeroed value", result == 0 || result == 0.0);
    }

    @Test
    public void TestDepositNegativeValue() {
        IAccount account = new Account();
        double amount = -1;
        double accountStatusBeforeDeposit = account.AccountStatus();
        double result = account.DepositFunds(amount);
        Assert.assertTrue("Deposit negative amount should be blocked", accountStatusBeforeDeposit == result);
    }

    @Test
    public void TestDepositPositiveValue() {
        IAccount account = new Account();
        double amount = 1.0;
        double accountStatusBeforeDeposit = account.AccountStatus();
        double result = account.DepositFunds(amount);
        Assert.assertTrue((accountStatusBeforeDeposit + amount) == result);
    }

    @Test
    public void TestDepositOverMaxTypeValue() {
        IAccount account = new Account();

        double result = account.DepositFunds(Double.MAX_VALUE);
        double resultOfOverflow = account.DepositFunds(10.0);

        Assert.assertTrue(result == Double.MAX_VALUE && result == resultOfOverflow);
    }

    @Test
    public void TestWithdrawFunds() {
        IAccount account = new Account();
        double depositedAmount = 100;
        account.DepositFunds(depositedAmount);
        double accountStatusBeforeWithdraw = account.AccountStatus();

        Assert.assertTrue("Cannot validate withdraw method without set account balance", accountStatusBeforeWithdraw >= depositedAmount);

        double result = account.WithdrawFunds(depositedAmount);
        Assert.assertTrue((accountStatusBeforeWithdraw - depositedAmount) == result);
    }

    @Test
    public void TestWithdrawFundsOverAccountBalance() {
        IAccount account = new Account();
        double accountStatusBeforeWithdraw = account.AccountStatus();
        double amount = accountStatusBeforeWithdraw + 0.01;

        double result = account.WithdrawFunds(amount);
        Assert.assertTrue(accountStatusBeforeWithdraw == result);
        Assert.assertTrue(account.AccountStatus() >= 0);
    }

    @Test
    public void TestWithdrawNegativeAmount() {
        IAccount account = new Account();
        double accountStatusBeforeWithdraw = account.AccountStatus();
        double amount = -10.0;
        double result = account.WithdrawFunds(amount);

        Assert.assertTrue(accountStatusBeforeWithdraw == result);
    }
}
