package com.uj.atm.common;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    @Test
    public void shouldAdd200_34ToBankBalanceReturn200_34(){
        Account account = new Account();

        account.DepositFunds(200.34);

        Assert.assertEquals(account.AccountStatus(),200.34,0.001);
    }

    @Test
    public void shouldAdd2ToBankBalanceReturn2(){
        Account account = new Account();

        account.DepositFunds(2);

        Assert.assertEquals(account.AccountStatus(),2,0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativeAmountToDepositFundsReturnException(){
        Account account = new Account();

        account.DepositFunds(-2);
    }

    @Test
    public void shouldSubtract2ToBankBalanceReturn0(){
        Account account = new Account();
        account.DepositFunds(2);

        account.WithdrawFunds(2);

        Assert.assertEquals(account.AccountStatus(),0,0.001);
    }

    @Test
    public void shouldSubtract2_1ToBankBalanceReturn0(){
        Account account = new Account();
        account.DepositFunds(5);

        account.WithdrawFunds(2.1);

        Assert.assertEquals(account.AccountStatus(),2.9,0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativeAmountToWithdrawFundsReturnException(){
        Account account = new Account();

        account.WithdrawFunds(-2);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenWithdrawFundsIsMoreThenBankBalanceReturnException(){
        Account account = new Account();

        account.WithdrawFunds(2);
    }

}
