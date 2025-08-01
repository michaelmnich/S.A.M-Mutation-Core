package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void accountStatus() {
        IAccount iAccount = new Account(1000);
        double value = iAccount.AccountStatus();
        Assert.assertTrue(value == 1000);
    }

    @Test
    public void depositFunds() {
        IAccount iAccount = new Account(1000);
        Assert.assertTrue(iAccount.DepositFunds(100) == 1100);

    }

    @Test
    public void withdrawFunds() {
        IAccount iAccount = new Account(1000);
        Assert.assertTrue( iAccount.WithdrawFunds(1000) == 0);

        Assert.assertTrue( iAccount.WithdrawFunds(2000) == -1);
    }
}