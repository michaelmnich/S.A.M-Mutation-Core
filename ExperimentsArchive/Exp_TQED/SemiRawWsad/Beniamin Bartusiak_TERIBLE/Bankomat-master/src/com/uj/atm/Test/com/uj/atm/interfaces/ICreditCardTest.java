package com.uj.atm.interfaces;

import com.uj.atm.common.AccountBalance;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ICreditCardTest {
    CreditCard card = new CreditCard();
    IAccount account = new AccountBalance();

    @Test
    public void changePin() {
        Assert.assertTrue(card.ChangePin("1234", "234", "234"));
    }

    @Test
    public void isPinValid() {
        Assert.assertTrue(card.IsPinValid("1234"));
    }

    @Test
    public void addAccount() {
        card.AddAccount(account);
        Assert.assertTrue(card.getAccount().equals(account));
    }

    @Test
    public void depositFunds() {
        card.AddAccount(account);
        Assert.assertTrue(card.DepositFunds(22) == true);
        Assert.assertTrue(card.DepositFunds(-11) == false);
    }

    @Test
    public void withdrawFunds() {
        card.AddAccount(account);
        card.DepositFunds(22);
        Assert.assertTrue(card.WithdrawFunds(22) == true);
        Assert.assertTrue(card.WithdrawFunds(-22) == false);
    }
}