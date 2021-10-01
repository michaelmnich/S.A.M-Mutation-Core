package com.uj.atm.Bank;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest
{
    Account newAccount = new Account(4000.00);

    @Test
    public void accountStatus()
    {
        Assert.assertEquals(4000.00,newAccount.balance,0);
    }
    @Test
    public void accountStatus2()
    {
        Assert.assertNotEquals(40000.00,newAccount.balance,0);
    }
    @Test
    public void isObjectExist()
    {
        newAccount = new Account();
        Assert.assertNotNull(newAccount);
    }
    @Test
    public void depositFunds()
    {
        double test = 5000.00;
        double saldoTest = newAccount.DepositFunds(1000.00);
        Assert.assertEquals(test,saldoTest,0.00);
    }
    @Test
    public void depositFunds2()
    {
        double test = 4000.00;
        double saldoTest = newAccount.DepositFunds(1000.00);
        Assert.assertNotEquals(test,saldoTest,0.00);
    }
    @Test
    public void withdrawFunds() {
        double test = 4000.00;
        double saldoTest = newAccount.WithdrawFunds(1000.00);
        Assert.assertNotEquals(test,saldoTest,0.00);
    }
    @Test
    public void withdrawFunds2() {
        double test = 3000.00;
        double saldoTest = newAccount.WithdrawFunds(1000.00);
        Assert.assertEquals(test,saldoTest,0.00);
    }
}