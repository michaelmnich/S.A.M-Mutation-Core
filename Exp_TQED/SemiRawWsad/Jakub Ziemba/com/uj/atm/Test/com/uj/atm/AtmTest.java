package com.uj.atm;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogIn() {
        Account testAcc = new Account(100);
        CreditCard testCard = new CreditCard("4444");
        testCard.AddAccount(testAcc);
        Atm testAtm = new Atm();
        assertTrue(testAtm.CheckPinAndLogIn(testCard, "4444"));
        assertFalse(testAtm.CheckPinAndLogIn(testCard, "5555"));
        assertFalse(testAtm.CheckPinAndLogIn(testCard, "asdd"));
        assertFalse(testAtm.CheckPinAndLogIn(testCard, "ad5"));
    }

    @Test
    public void accountStatus() {
        Account testAcc = new Account(100);
        Atm testAtm = new Atm();
        assertEquals(100,testAtm.AccountStatus(testAcc),0);
    }

    @Test
    public void changePinCard() {
        CreditCard testCard = new CreditCard("4444");
        Atm testAtm = new Atm();
        assertFalse(testAtm.ChangePinCard(testCard,"4444","5","5"));
        assertFalse(testAtm.ChangePinCard(testCard,"4444","sddd","sddd"));
        assertFalse(testAtm.ChangePinCard(testCard,"4444","dss","dd"));
        assertTrue(testAtm.ChangePinCard(testCard,"4444","5555","5555"));
    }

    @Test
    public void depositFunds() {
        Account testAcc = new Account(100);
        CreditCard testCard = new CreditCard("4444");
        testCard.AddAccount(testAcc);
        Atm testAtm = new Atm();
        assertTrue(testAtm.DepositFunds(testCard,200));
        assertFalse(testAtm.DepositFunds(testCard, -200));
    }

    @Test
    public void withdrawFunds() {
        Account testAcc = new Account(100);
        CreditCard testCard = new CreditCard("4444");
        testCard.AddAccount(testAcc);
        Atm testAtm = new Atm();
        assertFalse(testAtm.WithdrawFunds(testCard,200));
        assertFalse(testAtm.WithdrawFunds(testCard, -200));
        assertTrue(testAtm.WithdrawFunds(testCard,50));
    }

    @Test
    public void transfer() {
        Account testAcc = new Account(100);
        Account testAcc1 = new Account(0);
        CreditCard testCard = new CreditCard("4444");
        testCard.AddAccount(testAcc);
        Atm testAtm = new Atm();
        assertTrue(testAtm.Transfer(testCard,testAcc1,50));
        assertFalse(testAtm.Transfer(testCard,testAcc1,-50));
    }
}