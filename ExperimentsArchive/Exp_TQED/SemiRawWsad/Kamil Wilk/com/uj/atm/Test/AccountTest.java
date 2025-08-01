package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {


    @Test
    public void AccountStatusTest1(){
        IAccount account = new Account();
        Assert.assertTrue(account.AccountStatus() == 0);
        Double d1 = account.AccountStatus();
        Double d2 = 0d;
        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void DepositFoundsTest1(){
        IAccount account1 = new Account();
        Assert.assertTrue(account1.DepositFunds(10.21) == 10.21);
        Double d1 = account1.DepositFunds(10.21);
        Double d2 = 20.42d;
        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void DepositFoundsTest2() {
        IAccount account2 = new Account();
        account2.DepositFunds(10);
        Assert.assertTrue(account2.DepositFunds(10.21) == 20.21);
        Double d1 = account2.DepositFunds(10.21);
        Double d2 = 30.42;
        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void WithdrawFundsTest1(){
        IAccount account3 = new Account();
        Assert.assertTrue(account3.WithdrawFunds(10.21) == 0);
        Double d1 = account3.WithdrawFunds(10.21);
        Double d2 = 0d;
        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void WithdrawFundsTest2(){
        IAccount account4 = new Account();
        account4.DepositFunds(10);
        Assert.assertTrue(account4.WithdrawFunds(5.51) == 4.49);
        Double d1 = account4.WithdrawFunds(5.51);
        Double d2 = 4.49d;
        Assert.assertTrue(d1.equals(d2));
    }
}