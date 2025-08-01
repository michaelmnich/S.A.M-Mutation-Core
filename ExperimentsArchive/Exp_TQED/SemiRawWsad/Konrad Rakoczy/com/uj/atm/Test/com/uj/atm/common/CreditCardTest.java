package com.uj.atm.common;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    private Account account = new Account();
    private CreditCard creditCard = new CreditCard();
    private Atm atm = new Atm();

    @Test
    public void changePin() {
        creditCard.AddAccount(account);

        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);
        Assert.assertTrue(creditCard.ChangePin("0000", "1111", "1111"));
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "1111"));

    }

    @Test
    public void isPinValid() {
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.IsPinValid("0000") == true);
        Assert.assertTrue(creditCard.IsPinValid("a0d0") == false);

    }

    @Test
    public void addAccount() {


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