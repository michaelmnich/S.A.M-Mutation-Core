package com.uj.atm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {
    CreditCard cc = new CreditCard();
    Account ac = new Account(300);
    Atm atm = new Atm();

    @Test
    public void checkPinAndLogIn() {
        assertTrue(atm.CheckPinAndLogIn(cc, "0000"));
        assertFalse(atm.CheckPinAndLogIn(cc, "00000"));
        assertFalse(atm.CheckPinAndLogIn(cc, "000"));
        assertFalse(atm.CheckPinAndLogIn(cc, "abcdS"));
        assertFalse(atm.CheckPinAndLogIn(cc, ""));
        assertFalse(atm.CheckPinAndLogIn(cc, "000a"));
    }

    @Test
    public void accountStatus() {
        assertEquals(300, atm.AccountStatus(ac), 0.0);
    }

    @Test
    public void changePinCard() {
        //poprawna zmiana
        assertTrue(atm.ChangePinCard(cc, "0000", "1234", "1234"));
        //zly oldPin
        assertFalse(atm.ChangePinCard(cc, "00000", "1234", "1234"));
        assertFalse(atm.ChangePinCard(cc, "000", "1234", "1234"));
        assertFalse(atm.ChangePinCard(cc, "abcs", "1234", "1234"));
        assertFalse(atm.ChangePinCard(cc, "", "12345", "1234"));
        //dobry oldPin, zly newPin
        assertFalse(atm.ChangePinCard(cc, "1234", "12345", "1234"));
        assertFalse(atm.ChangePinCard(cc, "1234", "123", "1234"));
        assertFalse(atm.ChangePinCard(cc, "1234", "abcd", "1234"));
        assertFalse(atm.ChangePinCard(cc, "1234", "", "1234"));
        //dobry oldPin, dobry newPin, zly newPinConfirm
        assertFalse(atm.ChangePinCard(cc, "1234", "1234", "12345"));
        assertFalse(atm.ChangePinCard(cc, "1234", "1234", "123"));
        assertFalse(atm.ChangePinCard(cc, "1234", "1234", "abcd"));
        assertFalse(atm.ChangePinCard(cc, "1234", "1234", ""));
        //dobry oldPin, rozny newPin z newPinConfirm
        assertFalse(atm.ChangePinCard(cc, "1234", "1234", "1233"));
    }

    @Test
    public void depositFunds() {
        assertFalse(cc.isStowarzyszona());
        assertFalse(atm.DepositFunds(cc, 300));
        cc.AddAccount(ac);
        assertTrue(cc.isStowarzyszona());
        assertTrue(atm.DepositFunds(cc, 300));
    }

    @Test
    public void withdrawFunds() {
        assertFalse(cc.isStowarzyszona());
        assertFalse(atm.WithdrawFunds(cc, 300));
        cc.AddAccount(ac);
        assertTrue(cc.isStowarzyszona());
        assertTrue(atm.WithdrawFunds(cc, 200));
        assertFalse(atm.WithdrawFunds(cc, 200)); //za duzo do wyplaty
    }

    @Test
    public void transfer() {
        Account ac2 = new Account(100);
        assertFalse(cc.isStowarzyszona());
        assertFalse(atm.Transfer(cc, ac2, 100));
        cc.AddAccount(ac);
        assertTrue(cc.isStowarzyszona());
        assertTrue(atm.Transfer(cc, ac2, 100));
        assertEquals(200, ac2.AccountStatus(), 0.0);
        assertEquals(200, cc.getAccount().AccountStatus(), 0.0);
        assertFalse(atm.Transfer(cc, ac2, 300)); //proba przelania zbyt duzej kwoty
    }
}