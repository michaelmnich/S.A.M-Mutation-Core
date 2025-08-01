package com.uj.atm.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePin() {
        ICreditCard pin = new CreditCard();
        Assert.assertTrue(pin.ChangePin("0000","1234","1234")==true);
    }

    @Test
    public void isPinValid() {
        ICreditCard pin = new CreditCard();
        Assert.assertTrue(pin.IsPinValid("0000")==true);
    }

    @Test
    public void addAccount() {
        ICreditCard karta = new CreditCard();
        ICreditCard karta2 = new CreditCard();
        IAccount konto = new Account();
        karta.AddAccount(konto);
        karta2.AddAccount(konto);
    }

    @Test
    public void depositFunds() {
        ICreditCard karta = new CreditCard();
        IAccount konto = new Account();
        karta.AddAccount(konto);
        Assert.assertTrue(karta.DepositFunds(-50));
    }

    @Test
    public void withdrawFunds() {
        ICreditCard karta = new CreditCard();
        IAccount konto = new Account();
        karta.AddAccount(konto);
        double wyplata = konto.AccountStatus()+1;
        Assert.assertFalse(karta.WithdrawFunds(wyplata));
    }
}