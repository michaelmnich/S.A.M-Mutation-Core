package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePin01() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertTrue(creditCard.ChangePin("0000","1234","1234"));
    }
    @Test
    public void changePin02() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.ChangePin("0001","1234","1234"));
    }
    @Test
    public void changePin03() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.ChangePin("0000","2222","1234"));
    }
    @Test
    public void changePin04() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.ChangePin("0000","22222","22222"));
    }
    @Test
    public void changePin05() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.ChangePin("0000","12t4","12t4"));
    }


    @Test
    public void isPinValid01() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertTrue(creditCard.IsPinValid("0000"));
    }
    @Test
    public void isPinValid02() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.IsPinValid("0220"));
    }
    @Test
    public void isPinValid03() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.IsPinValid("0#00"));
    }
    @Test
    public void isPinValid04() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.IsPinValid("00000"));
    }

    @Test
    public void addAccount01() throws Exception {
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.DepositFunds(2000));
        creditCard.AddAccount(new Account());
        Assert.assertTrue(creditCard.DepositFunds(2000));
    }
    @Test (expected = Exception.class)
    public void addAccount02() throws Exception {
        ICreditCard creditCard = new CreditCard(new Account());
        creditCard.AddAccount(new Account()); }

    @Test
    public void depositFunds01() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertTrue(creditCard.DepositFunds(50.0));
    }
    @Test
    public void depositFunds02() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.DepositFunds(0.0));
    }

    @Test
    public void depositFunds03() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.DepositFunds(-10.0));
    }
    @Test
    public void depositFunds04() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.DepositFunds(100.0));
    }

    @Test
    public void withdrawFunds01() {
        ICreditCard creditCard = new CreditCard(new Account(100.0));
        Assert.assertTrue(creditCard.WithdrawFunds(50.0));
    }
    @Test
    public void withdrawFunds02() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.WithdrawFunds(0.0));
    }
    @Test
    public void withdrawFunds03() {
        ICreditCard creditCard = new CreditCard(new Account());
        Assert.assertFalse(creditCard.WithdrawFunds(-350.0));
    }
    @Test
    public void withdrawFunds04() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.WithdrawFunds(502.0));
    }

}