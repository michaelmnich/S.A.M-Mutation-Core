package com.uj.atm.Test;
import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class AccountTest {

    //Check if AccountStatus returs correct balance
    @Test
    public void AccountStatus_ReturnsCorrectAccountBalanceValue(){
        IAccount iAccount=new Account(100);
        Assert.assertTrue(iAccount.AccountStatus()==100);

        Double result = iAccount.AccountStatus();
        Double expected = 100d;
        Assert.assertTrue(result.equals(expected));
    }

    //Check if DepositFunds add cash correctly
    @Test
    public void DepositFunds_AddingAndReturnsCorrectAccountBalanceValue(){
        IAccount iAccount=new Account(100);
        Assert.assertTrue(iAccount.DepositFunds(100)==200);

        IAccount iAccount1=new Account(100);
        Double result = iAccount1.DepositFunds(100);
        Double expected = 200d;
        Assert.assertTrue(result.equals(expected));
    }

    //Check if WithdrawFunds subtracts cash correctly
    @Test
    public void WithdrawFunds_WithdrawingAndReturnsCorrectAccountBalanceValue(){
        IAccount iAccount=new Account(100);
        Assert.assertTrue(iAccount.WithdrawFunds(50)==50);

        IAccount iAccount1=new Account(100);
        Double result = iAccount1.WithdrawFunds(50);
        Double expected = 50d;
        Assert.assertTrue(result.equals(expected));
    }

    //Check if there is no ability to withdraw more money than balance has
    @Test
    public void WithdrawFunds_CannotWithdrawMoreThanBalanceHas(){
        IAccount iAccount=new Account(100);
        Assert.assertTrue(iAccount.WithdrawFunds(150)==100);

        IAccount iAccount1=new Account(100);
        Double result = iAccount1.WithdrawFunds(150);
        Double expected = 100d;
        Assert.assertTrue(result.equals(expected));
    }

}
