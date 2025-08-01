package com.uj.atm.common;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    private Account account = new Account();
    private CreditCard creditCard = new CreditCard();
    private Atm atm = new Atm();

    private Account account2 = new Account();
    private CreditCard creditCard2 = new CreditCard();
    private Atm atm2 = new Atm();


    @Test
    public void checkPinAndLogIn() {

        creditCard.AddAccount(account);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);

    }

    @Test
    public void accountStatus() {
        Assert.assertTrue(atm.AccountStatus(account) == 0);
    }

    @Test
    public void changePinCard() {

        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "1111", "1111") == true);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "1111"));

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

    @Test
    public void transfer() {

        creditCard.AddAccount(account);
        creditCard2.AddAccount(account2);

        Assert.assertTrue(atm.DepositFunds(creditCard,100) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 100);

        Assert.assertTrue(atm.Transfer(creditCard, account2, 100) == true);
        Assert.assertTrue(atm2.AccountStatus(account2) == 100);

//        Assert.assertTrue(atm.WithdrawFunds(creditCard, 100) == true);
//        Assert.assertTrue(atm2.DepositFunds(creditCard, 100));

    }
}