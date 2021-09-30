package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void AccountStatusTest01() {
        IAccount account = new Account();
        Assert.assertTrue(account.AccountStatus()==0);
        double l1 = account.AccountStatus();
        double l2 = 0;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);
    }

    @Test
    public void AccountStatusTest02() {
        IAccount account = new Account(200);
        Assert.assertTrue(account.AccountStatus()==200);
        double l1 = account.AccountStatus();
        double l2 = 200;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);
    }

    @Test
    public void DepositFundsTest01() {
        IAccount account = new Account();
        Assert.assertTrue(account.DepositFunds(200)==200);
        double l1 = account.DepositFunds(200);
        double l2 = 200;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);
    }

    @Test
    public void WithdrawFundsTest01() {
        IAccount account = new Account(200);
        Assert.assertTrue(account.WithdrawFunds(150)==50);
        double l1 = account.WithdrawFunds(30);
        double l2 = 20;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);
    }

    @Test(expected = RuntimeException.class)
    public void WithdrawFundsTest02() {
        IAccount account = new Account(200);
        Assert.assertTrue(account.WithdrawFunds(210)==200);
        double l1 = account.WithdrawFunds(210);
        double l2 = 200;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);
    }
}
