package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;


public class AccountTest {

    @Test
    public void accountStatus01() {
        IAccount account = new Account(0.0);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Double s1 = account.AccountStatus();
        Double s2 = 0.0;
        Assert.assertTrue(s1.equals(s2));

    }
    @Test
    public void accountStatus02() {
        IAccount account = new Account(1000.0);
        Assert.assertTrue(account.AccountStatus() == 1000.0);
        Double s1 = account.AccountStatus();
        Double s2 = 1000.0;
        Assert.assertTrue(s1.equals(s2));

    }

    @Test
    public void depositFunds01() {
        IAccount account = new Account(0.0);
        Double s0 = account.AccountStatus();
        Assert.assertTrue(account.DepositFunds(50) == 50 + s0 );
        Double s1 = account.DepositFunds(50);
        Double s2 = s0  + 100;
        Assert.assertTrue(s1.equals(s2));
    }
    @Test
    public void depositFunds02() {
        IAccount account = new Account(20.0);
        Double s0 = account.AccountStatus();
        Assert.assertTrue(account.DepositFunds(-50.0) == s0);
        Double s1 = account.DepositFunds(-50.0);
        Double s2 = s0;
        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void withdrawFunds01() {
        IAccount account = new Account(0.0);
        Double s0 = account.AccountStatus();
        Assert.assertTrue(account.WithdrawFunds(50.0) == s0);
        Double s1 = account.WithdrawFunds(50.0);
        Assert.assertTrue(s0.equals(s1));

    }
    @Test
    public void withdrawFunds02() {
        IAccount account = new Account(400.0);
        Assert.assertTrue(account.WithdrawFunds(400) == 0.0);
        Double s1 = account.WithdrawFunds(400);
        Assert.assertTrue(s1.equals(0.0));

    }
    @Test
    public void withdrawFunds03() {
        IAccount account = new Account(100.0);
        Assert.assertTrue(account.WithdrawFunds(-50) == account.AccountStatus());
        Double s1 = account.AccountStatus();
        Double s2 = account.WithdrawFunds(-50);
        Assert.assertTrue(s1.equals(s2));

    }
}