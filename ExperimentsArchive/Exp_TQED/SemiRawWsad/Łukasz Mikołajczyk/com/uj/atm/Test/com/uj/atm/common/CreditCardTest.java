package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;

import static org.junit.Assert.*;

public class CreditCardTest {

    @org.junit.Test
    public void changePin() {
        ICreditCard creditCard = new CreditCard("2345");
        Assert.assertTrue(creditCard.ChangePin("2345", "6572", "6572"));
        Assert.assertFalse(creditCard.ChangePin("6572", "2345", "3212"));
        Assert.assertFalse(creditCard.ChangePin("6572", "65725", "32125"));

        Assert.assertFalse(creditCard.ChangePin("6572", "657xx", "321xx") );
        Assert.assertTrue(creditCard.ChangePin("6572", "6572", "6572"));
    }

    @org.junit.Test
    public void isPinValid() {
        ICreditCard creditCard = new CreditCard("2345");
        Assert.assertTrue(creditCard.IsPinValid("2345"));
        Assert.assertFalse(creditCard.IsPinValid("22XA"));

    }

    @org.junit.Test
    public void addAccount() {
        ICreditCard creditCard = new CreditCard("2345");
        IAccount account = new Account(1000);
        creditCard.AddAccount(account);
    }

    @org.junit.Test
    public void depositFunds() {
        ICreditCard creditCard = new CreditCard("2345");
        Assert.assertFalse( creditCard.DepositFunds(5000) );
        Assert.assertFalse( creditCard.DepositFunds(-5000) );

        IAccount account = new Account(1000);
        creditCard.AddAccount(account);

        Assert.assertFalse( creditCard.DepositFunds(-5000) );
        Assert.assertTrue( creditCard.DepositFunds(500) );
//        Assert.assertTrue( creditCard.DepositFunds(5000) == -1);
    }

    @org.junit.Test
    public void withdrawFunds() {
        ICreditCard creditCard = new CreditCard("2345");
        Assert.assertFalse( creditCard.DepositFunds(5000) );
        Assert.assertFalse( creditCard.DepositFunds(-5000) );

        IAccount account = new Account(1000);
        creditCard.AddAccount(account);

        Assert.assertFalse( creditCard.DepositFunds(-5000) );
        Assert.assertTrue( creditCard.DepositFunds(500) );
    }
}