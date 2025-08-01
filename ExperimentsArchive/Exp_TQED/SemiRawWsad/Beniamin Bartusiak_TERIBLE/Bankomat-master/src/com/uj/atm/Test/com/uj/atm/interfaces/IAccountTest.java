package com.uj.atm.interfaces;
import com.uj.atm.common.AccountBalance;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IAccountTest {
    IAccount amount = new AccountBalance();
    @Test
    public void accountStatus() {
        //IAccountTest price = new AccountTest();
        Assert.assertTrue(amount.AccountStatus()>=0);
    }

    @Test
    public void depositFunds() {
        Assert.assertTrue(amount.DepositFunds(22)==22);
        Assert.assertTrue(amount.DepositFunds(-11)==22);
    }

    @Test
    public void withdrawFunds() {
        amount.DepositFunds(22);
        Assert.assertTrue(amount.WithdrawFunds(22)==0);
        Assert.assertTrue(amount.WithdrawFunds(-11)==0);
    }
}