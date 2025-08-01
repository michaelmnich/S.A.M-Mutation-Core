package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void acctest(){
        IAccount acc = new Account(0);
        Assert.assertTrue(acc.AccountStatus()==0);
        acc.WithdrawFunds(10);
        Assert.assertTrue(acc.AccountStatus()==-10);
        Assert.assertTrue(acc.AccountStatus()==0);
        acc.DepositFunds(10);
        Assert.assertTrue(acc.AccountStatus()==10);
        acc.WithdrawFunds(5);
        Assert.assertTrue(acc.AccountStatus()==5);
    }

    @Test
    public void acctest2(){
        IAccount acc = new Account(0);
        Assert.assertTrue(acc.AccountStatus()==0);
        acc.DepositFunds(10);
        Assert.assertTrue(acc.AccountStatus()==10);
        acc.WithdrawFunds(5);
        Assert.assertTrue(acc.AccountStatus()==5);
    }

}
