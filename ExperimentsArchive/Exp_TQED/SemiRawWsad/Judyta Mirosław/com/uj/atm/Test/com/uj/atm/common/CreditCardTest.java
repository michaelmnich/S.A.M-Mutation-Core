package com.uj.atm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    CreditCard cc = new CreditCard();
    Account ac = new Account(300);

    @Test
    public void getPIN() {
        assertEquals("0000", cc.getPIN());
    }

    @Test
    public void isStowarzyszona() {
        assertFalse(cc.isStowarzyszona());
    }

    @Test
    public void getAccount() {
        assertEquals(null, cc.getAccount());
    }

    @Test
    public void setPIN() {
        cc.setPIN("1234");
        assertEquals("1234", cc.getPIN());
    }

    @Test
    public void setStowarzyszona() {
        cc.setStowarzyszona(true);
        assertTrue(cc.isStowarzyszona());
    }

    @Test
    public void setAccount() {
        cc.setAccount(ac);
        assertTrue(cc.isStowarzyszona());
        assertEquals(ac, cc.getAccount());
    }

    @Test
    public void changePin() {
        assertTrue(cc.ChangePin("0000", "1234", "1234"));
        assertFalse(cc.ChangePin("0000", "0000", "0000"));
        assertFalse(cc.ChangePin("0000", "1234", "1111"));
    }

    @Test
    public void isPinValid() {
        assertTrue(cc.IsPinValid("0000"));
        assertFalse(cc.IsPinValid("1234"));
    }

    @Test
    public void addAccount() {
        assertFalse(cc.isStowarzyszona());
        cc.AddAccount(ac);
        assertEquals(ac, cc.getAccount());
        assertTrue(cc.isStowarzyszona());
        //proba przypisania innego konta
        Account ac2 = new Account(200);
        cc.AddAccount(ac2);
        assertEquals(ac, cc.getAccount());
        assertTrue(cc.isStowarzyszona());
    }

    @Test
    public void depositFunds() {
        assertFalse(cc.DepositFunds(300));
        cc.AddAccount(ac);
        assertEquals(ac, cc.getAccount());
        assertTrue(cc.DepositFunds(300));
        assertEquals(600, cc.getAccount().AccountStatus(), 0.0);
    }

    @Test
    public void withdrawFunds() {
        assertFalse(cc.WithdrawFunds(300));
        cc.AddAccount(ac);
        assertEquals(ac, cc.getAccount());
        assertTrue(cc.WithdrawFunds(300));
        assertFalse(cc.WithdrawFunds(300)); //stan konta = 0, nie mozna wiecej odjac
        assertEquals(0, cc.getAccount().AccountStatus(), 0.0);
    }
}