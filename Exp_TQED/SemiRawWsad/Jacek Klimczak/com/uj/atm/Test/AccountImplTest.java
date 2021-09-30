package com.uj.atm.Test;

import com.uj.atm.common.AccountImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountImplTest {

    @Test
    public void ShouldDepositFundsInAccount()
    {
        //Given
        AccountImpl account = new AccountImpl();
        double amount = 4.2;
        //When
        account.DepositFunds(amount);

        //Then
        Assert.assertEquals(amount, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldNotDepositMinusAmount()
    {
        //Given
        AccountImpl account = new AccountImpl();
        double amountMinus = -4.2;

        //When
        account.DepositFunds(amountMinus);

        //Then
        Assert.assertEquals(0.0, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldWithdrawAmount()
    {
        //Given
        AccountImpl account = new AccountImpl();
        double initialAmount = 4;
        account.DepositFunds(initialAmount);

        double amountToWithdraw = 2;

        //When
        account.WithdrawFunds(amountToWithdraw);

        //Then
        Assert.assertEquals(initialAmount - amountToWithdraw, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldNotWithdrawMinusAmount()
    {
        //Given
        AccountImpl account = new AccountImpl();
        double initialAmount = 4;
        account.DepositFunds(initialAmount);

        double amountToWithdraw = -2;

        //When
        account.WithdrawFunds(amountToWithdraw);

        //Then
        Assert.assertEquals(initialAmount, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldNotWithdrawMoreThanCurrentAmount()
    {
        //Given
        AccountImpl account = new AccountImpl();
        double initialAmount = 4;
        account.DepositFunds(initialAmount);

        double amountToWithdraw = 1000;

        //When
        account.WithdrawFunds(amountToWithdraw);

        //Then
        Assert.assertEquals(initialAmount, account.AccountStatus(), 0.1);
    }
}