package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {
    @Test
    public void testTooLongPin() {
        String pin = "51235";
        CreditCard card = new CreditCard();

        Assert.assertFalse(card.IsPinValid(pin));
    }

    @Test
    public void testTooShortPin() {
        String pin = "123";
        CreditCard card = new CreditCard();

        Assert.assertFalse(card.IsPinValid(pin));
    }

    @Test
    public void testChangePinWithoutAccount() {
        Account acc = new Account();
        CreditCard card = new CreditCard();
        String pin = "0000";
        String newPin = "3212";

        Assert.assertFalse(card.ChangePin(pin, newPin, newPin));
        card.AddAccount(acc);
        Assert.assertTrue(card.ChangePin(pin, newPin, newPin));
    }

    @Test
    public void testAlphanumericPin() {
        String pin = "0a4b";
        CreditCard card = new CreditCard();

        Assert.assertFalse(card.IsPinValid(pin));
    }

    @Test
    public void testValidPin() {
        String pin = "0000";
        String newPin = "3212";

        CreditCard card = new CreditCard();
        Account acc = new Account();
        card.AddAccount(acc);
        Assert.assertTrue(card.IsPinValid(pin));

        card.ChangePin(pin, newPin, newPin);
        Assert.assertTrue(card.IsPinValid(newPin));
        Assert.assertFalse(card.IsPinValid(pin));
    }

    @Test
    public void testWithoutCorrectPin() {
        String pin = "1234";
        String newPin = "0000";

        CreditCard card = new CreditCard();
        Assert.assertFalse(card.ChangePin(pin, newPin, newPin));
    }

    @Test
    public void testChangeToSamePin() {
        String pin = "0000";
        String newPin = "0000";

        CreditCard card = new CreditCard();
        Assert.assertFalse(card.ChangePin(pin, newPin, newPin));
    }

    @Test
    public void testCorrectConfirmedPin() {
        String pin = "0000";
        String newPin = "4312";
        String confirmPin = "3214";

        CreditCard card = new CreditCard();
        Account acc = new Account();
        card.AddAccount(acc);

        Assert.assertFalse(card.ChangePin(pin, newPin, confirmPin));

        confirmPin = "4312";
        Assert.assertTrue(card.ChangePin(pin, newPin, confirmPin));
    }

    @Test
    public void testChangePin() {
        String pin = "0000";
        String newPin = "1111";
        String confirmPin = "1111";

        CreditCard card = new CreditCard();
        Account acc = new Account();
        card.AddAccount(acc);

        Assert.assertTrue(card.ChangePin(pin, newPin, confirmPin));
    }

    @Test
    public void testAddAccount() {
        CreditCard cc = new CreditCard();

        Account acc = new Account();
        Account newAcc = new Account();

        cc.AddAccount(acc);
        Assert.assertSame(acc, cc.account);
        cc.AddAccount(newAcc);
        Assert.assertNotSame(newAcc, cc.account);
        Assert.assertSame(acc, cc.account);
    }

    @Test
    public void testDepositFunds() {
        CreditCard cc = new CreditCard();
        Account acc = new Account();

        Assert.assertFalse(cc.DepositFunds(20));
        cc.AddAccount(acc);

        Assert.assertTrue(cc.DepositFunds(20));
        Assert.assertEquals(acc.AccountStatus(), 20, 0.0001);
    }

    @Test
    public void testWithdrawFunds() {
        CreditCard cc = new CreditCard();
        Account acc = new Account();

        Assert.assertFalse(cc.WithdrawFunds(20));
        cc.AddAccount(acc);

        Assert.assertFalse(cc.WithdrawFunds(20));

        cc.DepositFunds(30);
        Assert.assertTrue(cc.WithdrawFunds(20));
    }
}
