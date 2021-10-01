package com.uj.atm.Test;

import com.uj.atm.common.Account;
import org.junit.Rule;
import org.junit.Test;

import org.junit.Assert;
import org.junit.rules.ExpectedException;


public class AccountTest {

    @Test
    public void test_InitialValues(){
        Account sampleAccount = new Account();
        Assert.assertTrue(sampleAccount.AccountStatus() == 0);
    }

    @Test
    public  void test_deposid(){
        Account sampleAccount = new Account();
        double res = sampleAccount.DepositFunds(100);
        Assert.assertTrue(res == 100);
        Assert.assertTrue(sampleAccount.AccountStatus() == 100) ;
        double resFromDepositingNegativeValue = sampleAccount.DepositFunds(-1);
        Assert.assertTrue(resFromDepositingNegativeValue == 100);
        Assert.assertTrue(sampleAccount.AccountStatus() == 100) ;

    }

    @Test
    public void test_Withdraw(){
        Account sampleAccount = new Account();
        double res = sampleAccount.DepositFunds(1000);
        Assert.assertTrue(res == 1000);
        double withdrawn = sampleAccount.WithdrawFunds(300);
        Assert.assertTrue(withdrawn == 700);
        Assert.assertTrue(sampleAccount.AccountStatus() == 700);
    }

    @Rule

    public ExpectedException ex = ExpectedException.none();

    @Test
    public  void testWithdrawMoreThanYouHave(){
        ex.expect(IllegalArgumentException.class);
        ex.expectMessage("Can't withdraw more than deposited!");
        Account sampleAccount = new Account();
        sampleAccount.DepositFunds(1000);
        sampleAccount.WithdrawFunds(3000);
    }


}