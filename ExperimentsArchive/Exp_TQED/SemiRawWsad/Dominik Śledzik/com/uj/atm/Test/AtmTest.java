package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void test1(){
        IAtm testatm = new Atm();
        ICreditCard testcard = new CreditCard();
        assertTrue(testatm.CheckPinAndLogIn(testcard,"1234"));
        assertFalse(testatm.CheckPinAndLogIn(testcard,"1233"));
        assertFalse(testatm.CheckPinAndLogIn(testcard,""));
        assertFalse(testatm.CheckPinAndLogIn(testcard,"1f34"));
    }

    @Test
    public void test2(){
        IAccount testacc = new Account();
        IAtm testatm = new Atm();
        assertEquals(0, testatm.AccountStatus(testacc), 0.0);
    }

    @Test
    public void test3(){
        IAtm testatm = new Atm();
        ICreditCard testcredit = new CreditCard();
        assertTrue(testatm.ChangePinCard(testcredit,"1234","5555","5555"));
        assertTrue(testatm.CheckPinAndLogIn(testcredit,"5555"));
    }

    @Test
    public void test4(){
        IAccount testacc = new Account();
        IAtm testatm = new Atm();
        ICreditCard testcard = new CreditCard();

        testcard.AddAccount(testacc);
        assertTrue(testatm.DepositFunds(testcard,420.69));
        assertEquals(420.69, testatm.AccountStatus(testacc), 0.001);
    }

    @Test
    public void test5(){
        IAccount testacc = new Account();
        IAtm testatm = new Atm();
        ICreditCard testcard = new CreditCard();
        testcard.AddAccount(testacc);
        testcard.DepositFunds(100);
        assertTrue(testatm.WithdrawFunds(testcard,90));
        assertEquals(10, testatm.AccountStatus(testacc), 0.01);
        assertTrue(testatm.WithdrawFunds(testcard,10));
        assertEquals(0, testatm.AccountStatus(testacc), 0.01);
    }

    @Test
    public void test6(){
        ICreditCard testcard = new CreditCard();
        IAtm testatm = new Atm();
        IAccount testacc1 = new Account();
        IAccount testacc2 = new Account();

        testcard.AddAccount(testacc1);
        testacc1.DepositFunds(90);
        assertEquals(90, testacc1.AccountStatus(), 0.0);
        assertNotEquals(50, testacc1.AccountStatus(), 0.0);
        testacc2.DepositFunds(40);
        testatm.Transfer(testcard,testacc2,30);
        assertEquals(70, testacc2.AccountStatus(), 0.0);
        testatm.Transfer(testcard,testacc2,-30);
        assertEquals(70, testacc2.AccountStatus(), 0.0);
    }
}

