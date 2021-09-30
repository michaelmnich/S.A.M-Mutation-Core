package com.uj.atm.Test.IAccount;

import com.uj.atm.common.IAccount;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


@RunWith(Parameterized.class)
public class IAccountTestWithdrawParameterized {
    @Parameterized.Parameters(name = "{index}: initial balance: {0}, expected initial balance: {1}, withdraw: {2}, expected return {3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {0, 0, 50, 0},
                        {149.98, 149.98, 50, 99.98},
                        {149.98, 149.98, 50.454, 99.53},
                        {149.98, 149.98, 50.455, 99.52},
                        {149.984, 149.98, 50.455, 99.52},
                        {149.986, 149.99, 50.455, 99.53},
                        {149.50, 149.50, 149.50, 0.00},
                        {149.50, 149.50, 149.495, 0.00},
                        {149.50, 149.50, 149.494, 0.01},
                        {149.50, 149.50, 150, 149.50},
                        {200.024, 200.02, 200.025, 200.02}, // test RoundingMode.HALF_UP
                        {200.024, 200.02, 200.024, 0},
                }
        );
    }

    private double initialBalance, expectedInitialBalance, withdrawAmount, expectedBalance;

    public IAccountTestWithdrawParameterized(double initialBalance, double expectedInitialBalance, double withdrawAmount, double expectedBalance) {
        this.initialBalance = initialBalance;
        this.expectedInitialBalance = expectedInitialBalance;
        this.withdrawAmount = withdrawAmount;
        this.expectedBalance = expectedBalance;
    }

    @Test
    public void test_withdraw_from_account() {
        IAccount account = new IAccount();
        account.DepositFunds(initialBalance);
        double oldBalance = account.AccountStatus();
        Assert.assertEquals(oldBalance, expectedInitialBalance, 0);
        double newBalance = account.WithdrawFunds(withdrawAmount);
        Assert.assertEquals(newBalance, expectedBalance, 0);
    }
}
