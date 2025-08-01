package com.uj.atm.Test;

import com.uj.atm.common.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void testAccountStatus() {
        Account account = new Account();
        Assert.assertEquals(account.AccountStatus(), 0, 0.0001);
        account.DepositFunds(20);
        Assert.assertEquals(account.AccountStatus(), 20, 0.0001);
    }

    @Test
    public void testDepositFunds() {
        Account account = new Account();

        account.DepositFunds(20);
        Assert.assertEquals(account.AccountStatus(), 20.0, 0.0001);


        account.DepositFunds(50);
        Assert.assertEquals(account.AccountStatus(), 70.0, 0.0001);
    }

    @Test
    public void testDepositNoAmount(){
        Account account = new Account();

        account.DepositFunds(0);
        Assert.assertEquals(account.AccountStatus(), 0.0, 0.0001);
    }

    @Test
    public void testWithdrawAmount() {
        Account account = new Account();

        account.WithdrawFunds(20);
        Assert.assertEquals(account.AccountStatus(), 0.0, 0.0001);

        account.DepositFunds(10);

        account.WithdrawFunds(20);
        Assert.assertEquals(account.AccountStatus(), 10, 0.0001);

        account.WithdrawFunds(5);
        Assert.assertEquals(account.AccountStatus(), 5, 0.0001);
    }
}
