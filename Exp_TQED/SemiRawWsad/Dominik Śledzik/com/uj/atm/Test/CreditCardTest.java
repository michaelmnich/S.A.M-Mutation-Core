package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    @Test
    public void test(){
        CreditCard testcard = new CreditCard();
        assertNotNull(testcard);
        assertTrue(testcard.IsPinValid("1234"));
        assertTrue(testcard.ChangePin("1234","2222","2222"));
        assertFalse(testcard.ChangePin("2115","2222","2222"));
        assertFalse(testcard.ChangePin("12e4","2222","2222"));
        assertFalse(testcard.ChangePin("1234","abcd","abcd"));
        assertFalse(testcard.ChangePin("1234","1234","1234"));
    }
    @Test
    public void test2(){
        CreditCard testcard = new CreditCard();
        assertTrue(testcard.IsPinValid("1234"));
        assertTrue(testcard.ChangePin("1234","4206","4206"));
        assertTrue(testcard.IsPinValid("4206"));
    }

    @Test
    public void test3(){
        IAccount testaccount = new Account();
        CreditCard testcard = new CreditCard();
        testcard.AddAccount(testaccount);
        assertFalse(testcard.WithdrawFunds(69.4));
        assertFalse(testcard.WithdrawFunds(420.9));
        assertEquals(0, testaccount.AccountStatus(), 0.001);
    }

    @Test
    public void test4(){
        IAccount testaccount = new Account();
        testaccount.DepositFunds(999);
        assertEquals(999, testaccount.AccountStatus(), 0.001);
        testaccount.DepositFunds(-999);
        assertEquals(999, testaccount.AccountStatus(), 0.001);
        testaccount.DepositFunds(6.9);
        assertEquals(1005.9, testaccount.AccountStatus(), 0.001);
        testaccount.DepositFunds(-6.9);
        assertEquals(1005.9, testaccount.AccountStatus(), 0.001);
    }

    @Test
    public void test5(){
        IAccount testaccount = new Account();
        testaccount.WithdrawFunds(-50);
        assertEquals(0, testaccount.AccountStatus(), 0.001);
        testaccount.DepositFunds(8080);
        assertEquals(8080, testaccount.AccountStatus(), 0.001);
        testaccount.WithdrawFunds(-8080);
        assertEquals(8080, testaccount.AccountStatus() , 0.001);
        testaccount.WithdrawFunds(8080);
        assertEquals(0, testaccount.AccountStatus(), 0.001);
        testaccount.WithdrawFunds(69.1);
        assertEquals(0, testaccount.AccountStatus(), 0.001);
    }
}
