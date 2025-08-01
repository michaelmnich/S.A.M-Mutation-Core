package com.uj.atm.Test.IAccount;

import com.uj.atm.common.IAccount;
import org.junit.Assert;
import org.junit.Test;


public class IAccountTest {

    @Test
    public void test_account_status_new_account() {
        IAccount account = new IAccount();
        Assert.assertEquals(account.AccountStatus(), 0, 0);
    }

    @Test
    public void test_account_status_new_account_with_one_deposit() {
        IAccount account = new IAccount();
        account.DepositFunds(50);
        Assert.assertEquals(account.AccountStatus(), 50, 0);
    }

    @Test
    public void test_new_account_with_many_deposits() {
        IAccount account = new IAccount();
        double currentBalance = account.DepositFunds(50);
        Assert.assertEquals(currentBalance, account.AccountStatus(), 0);
        Assert.assertEquals(account.AccountStatus(), 50, 0);

        double currentBalance2 = account.DepositFunds(65.404);
        Assert.assertEquals(currentBalance2, account.AccountStatus(), 0);
        Assert.assertEquals(account.AccountStatus(), 115.40, 0);

        double currentBalance3 = account.DepositFunds(70.513);
        Assert.assertEquals(currentBalance3, account.AccountStatus(), 0);
        Assert.assertEquals(account.AccountStatus(), 185.91, 0);
    }

    @Test
    public void test_new_account_with_many_deposits_2() {
        IAccount account = new IAccount();
        double currentBalance = account.DepositFunds(50);
        Assert.assertEquals(currentBalance, account.AccountStatus(), 0);
        Assert.assertEquals(account.AccountStatus(), 50, 0);

        double currentBalance2 = account.DepositFunds(65.404);
        Assert.assertEquals(currentBalance2, account.AccountStatus(), 0);
        Assert.assertEquals(account.AccountStatus(), 115.40, 0);

        double currentBalance3 = account.DepositFunds(70.535);
        Assert.assertEquals(currentBalance3, account.AccountStatus(), 0);
        Assert.assertEquals(account.AccountStatus(), 185.94, 0);
    }

    @Test
    public void test_withdraw_many_times_from_account() {
        IAccount account = new IAccount();
        account.DepositFunds(300);
        double oldBalance = account.AccountStatus();
        Assert.assertEquals(oldBalance, 300, 0);
        double newBalance = account.WithdrawFunds(100); // success
        Assert.assertEquals(newBalance, 200, 0);
        double newBalance2 = account.WithdrawFunds(50); // success
        Assert.assertEquals(newBalance2, 150, 0);
        double newBalance3 = account.WithdrawFunds(300); // fail
        Assert.assertEquals(newBalance3, 150, 0);
    }




}

