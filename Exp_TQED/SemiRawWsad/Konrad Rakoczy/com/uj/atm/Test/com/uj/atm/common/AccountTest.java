package com.uj.atm.common;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private Account account = new Account();
    private CreditCard creditCard = new CreditCard();
    private Atm atm = new Atm();


    @Test
    public void accountStatus() {

        Assert.assertTrue(account.AccountStatus() == 0);

    }

    @Test
    public void depositFunds() {

        creditCard.AddAccount(account);

        Assert.assertTrue(atm.DepositFunds(creditCard, 500) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 500);

    }

    @Test
    public void withdrawFunds() {

        creditCard.AddAccount(account);

        Assert.assertTrue(atm.WithdrawFunds(creditCard, 100) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 0);


    }
}