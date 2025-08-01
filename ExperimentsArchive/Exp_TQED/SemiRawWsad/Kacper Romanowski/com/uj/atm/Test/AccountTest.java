package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void test01(){
        IAccount account = new Account();
        Assert.assertEquals(0, account.AccountStatus(), 0.0);
        account.DepositFunds(100);
        Assert.assertEquals(100, account.AccountStatus(), 0.0);
        account.WithdrawFunds(60);
        Assert.assertEquals(40, account.AccountStatus(), 0.0);
    }

    @Test
    public void test02(){
        IAccount account = new Account(12);
        Assert.assertEquals(12, account.AccountStatus(), 0.0);
        account.DepositFunds(100);
        Assert.assertEquals(112, account.AccountStatus(), 0.0);
        account.WithdrawFunds(100);
        Assert.assertEquals(12, account.AccountStatus(), 0.0);
    }

    @Test
    public void test03(){
        IAccount account = new Account();
        Assert.assertEquals(0, account.AccountStatus(), 0.0);
        account.DepositFunds(100);
        Assert.assertEquals(100, account.AccountStatus(), 0.0);
        account.WithdrawFunds(120);
        Assert.assertEquals(100, account.AccountStatus(), 0.0);
    }

    @Test
    public void test04(){
        IAccount account = new Account();
        Assert.assertEquals(0, account.AccountStatus(), 0.0);
        account.DepositFunds(-100);
        Assert.assertEquals(0, account.AccountStatus(), 0.0);
        account.WithdrawFunds(0);
        Assert.assertEquals(0, account.AccountStatus(), 0.0);
    }


}
