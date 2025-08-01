package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    IAccount account;

    @Before
    public void Initialize() {
        account = new Account();
    }

    @Test
    public void NewAccountHasBalanceOfZero() {
        Assert.assertEquals(0, account.AccountStatus(), 0);
    }

    @Test
    public void DepositUpdatesAccountForValidInput () {
        Assert.assertEquals(10, account.DepositFunds(10), 0);
    }

    @Test
    public void WithdrawUpdatesAccountForValidInput () {
        account.DepositFunds(10);
        Assert.assertEquals(0, account.WithdrawFunds(10), 0);
    }

    @Test
    public void DepositDoesNotUpdateAccountForNonPositiveInput() {
        Assert.assertEquals(account.DepositFunds(-10), account.AccountStatus(), 0);
        Assert.assertEquals(account.DepositFunds(0), account.AccountStatus(), 0);
        Assert.assertEquals(account.DepositFunds(Double.NEGATIVE_INFINITY), account.AccountStatus(), 0);
        Assert.assertEquals(account.DepositFunds(-Double.MAX_VALUE), account.AccountStatus(), 0);
        Assert.assertEquals(account.DepositFunds(Double.NaN), account.AccountStatus(), 0);
    }

    @Test
    public void WithdrawDoesNotUpdateAccountForNonPositiveInput() {
        account.DepositFunds(10);
        Assert.assertEquals(account.WithdrawFunds(-10), account.AccountStatus(), 0);
        Assert.assertEquals(account.WithdrawFunds(0), account.AccountStatus(), 0);
        Assert.assertEquals(account.WithdrawFunds(Double.NEGATIVE_INFINITY), account.AccountStatus(), 0);
        Assert.assertEquals(account.WithdrawFunds(-Double.MAX_VALUE), account.AccountStatus(), 0);
        Assert.assertEquals(account.DepositFunds(Double.NaN), account.AccountStatus(), 0);
    }

    @Test
    public void AccountBalanceCanNotGoBelowZero() {
        Assert.assertEquals(0, account.WithdrawFunds(100), 0);
    }

    @Test
    public void InfinityDepositAndWithdrawDoesNotWork() {
        Assert.assertEquals(0, account.DepositFunds(Double.POSITIVE_INFINITY), 0);
        Assert.assertEquals(0, account.WithdrawFunds(Double.POSITIVE_INFINITY), 0);
    }

    @Test
    public void DepositOfSmallestDoubleNumber () {
        Assert.assertEquals(Double.MIN_VALUE, account.DepositFunds(Double.MIN_VALUE), 0);
    }

    @Test
    public void WithdrawOfSmallestDoubleNumber () {
        account.DepositFunds(10);
        Assert.assertEquals(10 - Double.MIN_VALUE, account.WithdrawFunds(Double.MIN_VALUE), 0);
    }

    @Test
    public void DepositOfNumberLargerThanDouble () {
        Assert.assertTrue(account.DepositFunds(Double.MAX_VALUE + 1) > Double.MAX_VALUE);
    }

    @Test
    public void DepositOfNumberSmallerThanDouble () {
        Assert.assertTrue( account.DepositFunds(Double.MIN_VALUE / 10) > 0);
    }

    @Test
    public void WithdrawOfNumberSmallerThanDouble () {
        account.DepositFunds(10);
        Assert.assertTrue( account.DepositFunds(Double.MIN_VALUE / 10) < 10);
    }

    @Test
    public void WithdrawOfNumberLargerThanDouble () {
        account.DepositFunds(Double.MAX_VALUE + 100);
        Assert.assertEquals( 90, account.WithdrawFunds(Double.MAX_VALUE + 10), 0);
    }
}