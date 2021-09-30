package com.uj.atm;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePin() {
        CreditCard testCard = new CreditCard("4444");
        assertFalse(testCard.ChangePin("4444", "asdd", "asdd"));
        assertFalse("Pin musi składać się z cyfr", testCard.ChangePin("dddd", "asdd", "asdd"));
        assertFalse(testCard.ChangePin("dddd", "asdd", "asdd"));
        assertFalse(testCard.ChangePin("44","4444","4444"));
        assertFalse(testCard.ChangePin("4444","433","433"));
        assertFalse(testCard.ChangePin("4444","4333","433"));
        assertFalse(testCard.ChangePin("4444","4444","4444"));
        assertTrue(testCard.ChangePin("4444", "5555", "5555"));
        assertFalse("Pin musi składać się z cyfr", testCard.ChangePin("dddd", "asdd", "asdd"));
    }

    @Test
    public void isPinValid() {
        CreditCard testCard = new CreditCard("4444");
        CreditCard testCard1 = new CreditCard("dddd");
        assertTrue(testCard.IsPinValid("4444"));
        assertFalse(testCard1.IsPinValid("dddd"));
        assertFalse("Brak karty",testCard1.IsPinValid("dddd"));
        assertFalse("Pin musi składać się z cyfr",testCard1.IsPinValid("dddd"));
    }

    @Test
    public void addAccount() {
        CreditCard testCard = new CreditCard("4444");
        Account testAcc = new Account(100);
        Account testAcc1 = new Account(200);
        assertNull(((CreditCard) testCard).account);
        testCard.AddAccount(testAcc);
        assertNotNull(((CreditCard) testCard).account);
        testCard.AddAccount(testAcc1);
        assertNotNull(((CreditCard) testCard).account);
    }

    @Test
    public void depositFunds() {
        CreditCard testCard = new CreditCard("4444");
        Account testAcc = new Account(100);
        assertFalse(testCard.DepositFunds(200));
        testCard.AddAccount(testAcc);
        assertTrue(testCard.DepositFunds(200));
        assertFalse(testCard.DepositFunds(-200));
    }

    @Test
    public void withdrawFunds() {
        CreditCard testCard = new CreditCard("4444");
        Account testAcc = new Account(100);
        assertFalse(testCard.WithdrawFunds(200));
        testCard.AddAccount(testAcc);
        assertFalse(testCard.WithdrawFunds(200));
        assertFalse(testCard.WithdrawFunds(-200));
        assertTrue(testCard.WithdrawFunds(50));
    }
}