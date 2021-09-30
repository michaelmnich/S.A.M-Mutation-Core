package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePinTest01() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("0000", "1234", "123"));
    }

    @Test
    public void changePinTest02() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("0001", "1234", "1234"));
    }

    @Test
    public void changePinTest03() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("0000", "123", "123"));
    }

    @Test
    public void changePinTest04() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("0000", "123", "1234"));
    }

    @Test
    public void changePinTest05() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.ChangePin("0000", "1234", "1234"));
    }

    @Test
    public void isPinValidTest01() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
    }

    @Test
    public void isPinValidTest02() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.IsPinValid("0001"));
    }

    @Test
    public void addAccountTest01() {
        ICreditCard cardTest = new CreditCard();
        IAccount accountTest = new Account();
        cardTest.AddAccount(accountTest);
        Assert.assertNotNull(((CreditCard) cardTest).konto);
        Assert.assertTrue(accountTest == ((CreditCard) cardTest).konto);
        Assert.assertTrue(((CreditCard) cardTest).konto.equals(accountTest));
    }

    @Test
    public void addAccountTest02() {
        ICreditCard cardTest = new CreditCard();
        IAccount accountTest1 = new Account();
        IAccount accountTest2 = new Account();
        cardTest.AddAccount(accountTest1);
        cardTest.AddAccount(accountTest2);
        Assert.assertFalse(accountTest2 == ((CreditCard) cardTest).konto);
        Assert.assertFalse(((CreditCard) cardTest).konto.equals(accountTest2));
    }

    @Test
    public void depositFundsTest01() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.DepositFunds(50));
    }

    @Test
    public void depositFundsTest02() {
        ICreditCard cardTest = new CreditCard();
        IAccount accountTest1 = new Account();
        cardTest.AddAccount(accountTest1);
        Assert.assertTrue(cardTest.DepositFunds(50));
    }

    @Test
    public void withdrawFundsTest01() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.WithdrawFunds(50));
    }

    @Test
    public void withdrawFundsTest02() {
        ICreditCard cardTest = new CreditCard();
        IAccount accountTest1 = new Account();
        cardTest.AddAccount(accountTest1);
        Assert.assertFalse(cardTest.WithdrawFunds(50));
    }

    @Test
    public void withdrawFundsTest03() {
        ICreditCard cardTest = new CreditCard();
        IAccount accountTest1 = new Account();
        cardTest.AddAccount(accountTest1);
        cardTest.DepositFunds(50);
        Assert.assertTrue(cardTest.WithdrawFunds(50));
    }
}