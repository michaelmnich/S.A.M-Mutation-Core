package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class CreditCardTest {

    @Test
    public void ChangePinTest1() {
        ICreditCard card = new CreditCard();
        Assert.assertFalse(card.ChangePin("0000", "1111", "1112"));
    }

    @Test
    public void ChangePinTest2() {
        ICreditCard card = new CreditCard();
        Assert.assertFalse(card.ChangePin("0101", "1111", "1111"));
    }


    @Test
    public void ChangePinTest3() {
        ICreditCard card = new CreditCard();
        Assert.assertTrue(card.ChangePin("0000", "1111", "1111"));
    }

    @Test
    public void IsPinValidTest1() {
        ICreditCard card = new CreditCard();
        Assert.assertTrue(card.IsPinValid("0000"));
    }

    @Test
    public void IsPinValidTest2() {
        ICreditCard card = new CreditCard();
        Assert.assertFalse(card.IsPinValid("0001"));
    }


    @Test
    public void DepositFundsTest1() {
        ICreditCard card = new CreditCard();
        Assert.assertFalse(card.DepositFunds(10));
    }

    @Test
    public void DepositFundsTest2() {
        ICreditCard card = new CreditCard();
        IAccount account = new Account();
        card.AddAccount(account);
        Assert.assertTrue(card.DepositFunds(10));
    }

    @Test
    public void WithdrawFundsTest1() {
        ICreditCard card = new CreditCard();
        Assert.assertFalse(card.WithdrawFunds(10));
    }

    @Test
    public void WithdrawFundsTest2() {
        ICreditCard card = new CreditCard();
        IAccount account = new Account();
        card.AddAccount(account);
        Assert.assertFalse(card.WithdrawFunds(10));
    }

    @Test
    public void WithdrawFundsTest3() {
        ICreditCard card = new CreditCard();
        IAccount account = new Account();
        card.AddAccount(account);
        card.DepositFunds(50);
        Assert.assertTrue(card.WithdrawFunds(10));
    }
}

