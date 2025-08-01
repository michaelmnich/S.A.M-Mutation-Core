package com.uj.atm.Bank;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest
{
    CreditCard newCard = new CreditCard("0000");


    @Test(expected = IllegalArgumentException.class)
    public void emptyPinFailed()
    {
        newCard = new CreditCard("");
        if(newCard.pin.isEmpty()) throw new IllegalArgumentException();
    }

    @Test
    public void isPinCorrect()
    {
        Assert.assertEquals("0000", newCard.pin);
    }

    @Test
    public void changePin() {
        boolean tmp = newCard.ChangePin("0000","1111","1111");
        Assert.assertTrue(tmp);
    }
    @Test
    public void isPinValid() {
        boolean tmp = newCard.IsPinValid("0000");
        Assert.assertTrue(tmp);
    }
    @Test
    public void isPinValid2() {
        boolean tmp = newCard.IsPinValid("0001");
        Assert.assertFalse(tmp);
    }

    @Test
    public void addAccount() {
        Account accountTest = new Account(100.00);
        newCard.AddAccount(accountTest);
        Assert.assertEquals(newCard.accountCard.balance, accountTest.balance,0.0);
    }
    @Test
    public void testAccount() {
        Account test = new Account();
        newCard.AddAccount(test);
        Assert.assertEquals(test, newCard.accountCard);
    }
    @Test
    public void testAccount2() {
        Account test = new Account();
        Account test2 = new Account();
        newCard.AddAccount(test);
        Assert.assertNotEquals(test2, newCard.accountCard);
    }

    @Test
    public void depositFunds() {
        Assert.assertTrue(newCard.DepositFunds(3000.00));
    }
    @Test
    public void depositFunds2() {
        double depositAmount = 100.00;
        newCard.DepositFunds(depositAmount);
        double depositedAmount = newCard.accountCard.balance;
        Assert.assertEquals(depositAmount,depositedAmount,0.0);
    }

    @Test
    public void withdrawFunds() {
        newCard.accountCard.balance = 4000.00;
        Assert.assertTrue(newCard.WithdrawFunds(3000.00));
    }
    @Test
    public void withdrawFunds1() {
        newCard.accountCard.balance = 4000.00;
        Assert.assertFalse(newCard.WithdrawFunds(-100.00));
    }
    @Test
    public void withdrawFunds2() {
        newCard.accountCard.balance = 4000.00;
        newCard.WithdrawFunds(3000.00);
        Assert.assertEquals(newCard.accountCard.balance, 1000.00, 0.0);
    }
}