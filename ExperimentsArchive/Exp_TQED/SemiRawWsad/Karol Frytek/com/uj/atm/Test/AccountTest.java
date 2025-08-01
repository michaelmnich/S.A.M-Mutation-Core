package com.uj.atm.Test;

import com.uj.atm.common.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void accountStatus() {
        Account test = new Account();
        assertTrue(test!=null);  //sprawdzenie czy w ogole utworzylo konto
        assertTrue(test.AccountStatus()==0); // sprawdzenie czy bank wyswietla kase

    }
    @Test
    public void depositFunds() {
        Account test = new Account();
        test.DepositFunds(20);
        assertTrue(test.AccountStatus()==20);  // sprawdzenie dodawania pieniedzy
        test.DepositFunds(-20);
        assertFalse(test.AccountStatus()==0); // wylapanie liczby ujemnej
        assertTrue(test.AccountStatus()==20);
    }

    @Test
    public void withdrawFunds() {
        Account test = new Account();
        assertFalse(test.WithdrawFunds(99)==-99); //sprawdzenie czy kasa moze byc ujemna
        assertTrue(test.WithdrawFunds(99)==0);
        assertTrue(test.WithdrawFunds(-20)==0); // sprawdzenie ujemnej liczby przy wyplacie

        test.DepositFunds(20);  // przykladowa sytuacja
        test.WithdrawFunds(40);
        assertTrue(test.AccountStatus()==20);
        assertFalse(test.AccountStatus()==-20);
        assertFalse(test.AccountStatus()==0);

    }
}