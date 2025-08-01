package com.uj.atm.Test;
import com.uj.atm.common.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    @Test
    public void AccountStatusRightTEST(){
        Account konto = new Account();
        Assert.assertTrue(konto.AccountStatus() == 0);
    }

    @Test
    public void AccountStatusWrongTEST(){
        Account konto = new Account();
        Assert.assertFalse(konto.AccountStatus() == -30);
    }

    @Test
    public void DepositFoundsTEST(){
        Account konto = new Account();
        Assert.assertTrue(konto.DepositFunds(-100) == 0);
    }

    @Test
    public void DepositFoundsAndStatusTEST(){
        Account konto = new Account();
        Assert.assertTrue(konto.DepositFunds(-100) == 0);
        Assert.assertTrue(konto.AccountStatus() == 0);
    }

    @Test
    public void DepositWrongFoundsAndStatusTEST(){
        Account konto = new Account();
        Assert.assertFalse(konto.DepositFunds(100) == 1000);
        Assert.assertFalse(konto.AccountStatus() == 1000);
    }

    @Test
    public void DepositFoundsDuzoTEST(){
        Account konto = new Account();
        Assert.assertTrue(konto.DepositFunds(-100) == 0);
        Assert.assertTrue(konto.DepositFunds(-100) == 0);
        Assert.assertTrue(konto.DepositFunds(-100) == 0);
        Assert.assertTrue(konto.DepositFunds(-100) == 0);
        Assert.assertTrue(konto.DepositFunds(-100) == 0);
    }

    @Test
    public void DepositFoundsPapiezTEST(){
        Account konto = new Account();
        Assert.assertTrue(konto.DepositFunds(21.37) == 21.37);
    }

    @Test
    public void WithdrawFoundsTEST(){
        Account konto = new Account();
        Assert.assertTrue(konto.DepositFunds(100) == 100);
    }

    @Test
    public void WithdrawZlyFoundsTEST(){
        Account konto = new Account();
        Assert.assertFalse(konto.DepositFunds(1000) == 100);
    }

    @Test
    public void WithdrawDuzoZlychIDobrychFoundsTEST(){
        Account konto = new Account();
        Assert.assertTrue(konto.WithdrawFunds(100) == 0);
        Assert.assertTrue(konto.WithdrawFunds(100) == 0);
        Assert.assertTrue(konto.WithdrawFunds(-100) == 0);
        Assert.assertTrue(konto.DepositFunds(1) == 1);
        Assert.assertTrue(konto.DepositFunds(10) == 11);
        Assert.assertTrue(konto.DepositFunds(100) == 111);
        Assert.assertFalse(konto.DepositFunds(1) == 1);
        Assert.assertFalse(konto.DepositFunds(10) == 11);
        Assert.assertFalse(konto.DepositFunds(100) == 111);
    }
}
