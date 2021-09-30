package com.uj.atm.interfaces;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class ICreditCardTest {

    CreditCard myCard = new CreditCard();
    double amount1 = 148, amount2 = 489.34;

    @Test
    public void StartPin() {
        assertTrue(myCard.IsPinValid("0000"));
    }

    @Test
    public void changePin1() {
        assertTrue(myCard.ChangePin("0000", "1234", "1234"));
    }

    @Test
    public void changePin2() {
        myCard.ChangePin("0000", "1234", "1234");
        assertTrue(myCard.IsPinValid("1234"));
    }

    @Test
    public void changePinWrongOldPin() {
        assertFalse(myCard.ChangePin("9999", "0000", "0000"));
    }

    @Test
    public void changePinNewPinsNotEqual() {
        assertFalse(myCard.ChangePin("0000", "0010", "0001"));
    }

    @Test
    public void changePinNewPinNotNumber() {
        assertFalse(myCard.ChangePin("0000", "Alas", "Alas"));
    }

    @Test
    public void AddAccountTrue() {
        Account myAccount = new Account();
        myCard.AddAccount(myAccount);
        myCard.DepositFunds(141);
        assertEquals(141, myAccount.AccountStatus(), 0.01);

    }

    @Test
    public void AddAccountFalse() {
        Account myAccount = new Account();
        myCard.AddAccount(myAccount);
        myCard.DepositFunds(141);
        Account myAccount2 = new Account();
        myCard.AddAccount(myAccount2);
        myCard.DepositFunds(171);
        assertNotEquals(171, myAccount.AccountStatus(), 0.01);
    }

    @Test
    public void depositFundsNoAccount() {
        assertFalse(myCard.DepositFunds(amount1));
    }

    @Test
    public void depositFundsTrue() {
        myCard.AddAccount(new Account());
        assertTrue(myCard.DepositFunds(amount1));
    }

    @Test
    public void withdrawFundsTrue() {
        myCard.AddAccount(new Account());
        myCard.DepositFunds(amount2);
        assertTrue(myCard.WithdrawFunds(amount1));
    }

    @Test
    public void withdrawFundsFalse() {
        myCard.AddAccount(new Account());
        myCard.DepositFunds(amount1);
        assertFalse(myCard.WithdrawFunds(amount2));
    }
}