package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.DummySample;
import com.uj.atm.interfaces.IDummySample;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void TestAccountStatus(){
        Account acc_test = new Account();
        Assert.assertTrue(acc_test.getBalance() == 0);

        acc_test.setBalance(100);
        Assert.assertTrue(acc_test.getBalance() == 100);
    }


    @Test
    public void TestDepositFunds(){
        Account acc_test = new Account();
        Assert.assertTrue(acc_test.DepositFunds(-111.1) == 0);
        Assert.assertTrue(acc_test.DepositFunds(111.1) == 111.1);
    }

    @Test
    public void TestWithdrawFunds(){
        Account acc_test = new Account();
        Assert.assertTrue(acc_test.WithdrawFunds(111.1) == 0);
        acc_test.setBalance(200);
        Assert.assertTrue(acc_test.WithdrawFunds(100) == 100);
        Assert.assertTrue(acc_test.WithdrawFunds(100) == 0);

    }
}
