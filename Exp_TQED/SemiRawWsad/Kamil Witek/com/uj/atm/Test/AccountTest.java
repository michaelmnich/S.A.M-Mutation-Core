package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {



    @Test
    public void AccountStatusTest01(){
        IAccount test = new Account();
        Assert.assertTrue(test.AccountStatus() == 0);
        Double s1 = test.AccountStatus();
        Double s2 = 0d;
        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void DepositFoundsTest01(){
        IAccount test1 = new Account();
        Assert.assertTrue(test1.DepositFunds(35.01) == 35.01);
        IAccount test2 = new Account();
        Double s1 = test2.DepositFunds(35.01);
        Double s2 = 35.01d;
        Assert.assertTrue(s1.equals(s2));
        Assert.assertTrue(test1.DepositFunds(35.01) == 70.02);
        s2 = 70.02;
        s1 = test2.DepositFunds(35.01);
        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void WithdrawFundsTest01(){
        IAccount test = new Account();
        Assert.assertTrue(test.WithdrawFunds(0.01) == 0);
        Double s1 = test.WithdrawFunds(0.01);
        Double s2 = 0d;
        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void WithdrawFundsTest02(){
        IAccount test1 = new Account();
        test1.DepositFunds(50);
        Assert.assertTrue(test1.WithdrawFunds(50) == 0);
        IAccount test2 = new Account();
        test2.DepositFunds(50);
        Double s1 = test2.WithdrawFunds(50);
        Double s2 = 0d;
        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void WithdrawFundsTest03(){
        IAccount test1 = new Account();
        test1.DepositFunds(50);
        Assert.assertTrue(test1.WithdrawFunds(25.5) == 24.5);
        IAccount test2 = new Account();
        test2.DepositFunds(50);
        Double s1 = test2.WithdrawFunds(25.5);
        Double s2 = 24.5d;
        Assert.assertTrue(s1.equals(s2));
    }

}
