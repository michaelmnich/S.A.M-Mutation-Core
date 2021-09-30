package com.uj.atm.Test;

import com.uj.atm.common.Account;


import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePin() {
        Account test;
        test = new Account();
        assertTrue(test!=null);
        CreditCard karta1;
        karta1 = new CreditCard();
        assertTrue(karta1!=null);
        assertTrue(karta1.IsPinValid("0000")); //wprowadzenie pinu
        assertTrue(karta1.ChangePin("0000","1949","1949")); //prawidłowo
        assertFalse(karta1.ChangePin("1949","1949","1949")); //zły pin na początku, dobre powtórzenie
        assertFalse(karta1.ChangePin("0000","1949","1951")); //złe powtórzenie pinu
        assertFalse(karta1.ChangePin("0000","1951","1949")); //j.w.
        assertFalse(karta1.ChangePin("0000","0000","0000")); //ten sam nowy pin co stary
        assertFalse(karta1.ChangePin("0001","0002","1949")); //wszystkie piny źle
        assertFalse(karta1.ChangePin("0000","333","333")); //za krótko nowe
        assertFalse(karta1.ChangePin("0000","55555","55555")); //za długo nowe //nowy pin za długi
    }

    @Test
    public void isPinValid() {
        CreditCard karta2 = new CreditCard();
        assertTrue(karta2.IsPinValid("0000"));
        assertTrue(karta2.ChangePin("0000","1949","1949"));
        assertTrue(karta2.IsPinValid("1949"));
    }

    @Test
    public void addAccount() {
        IAccount Konto3 = new Account();
        CreditCard karta3 = new CreditCard();
        assertFalse(karta3.WithdrawFunds(19.49));
        karta3.AddAccount(Konto3);
        assertTrue(karta3.WithdrawFunds(19.51));
        assertTrue(Konto3.AccountStatus()==0);
    }

    @Test
    public void depositFunds() {
        IAccount Konto4 = new Account();
        CreditCard karta4 = new CreditCard();
        Konto4.DepositFunds(1949);
        assertTrue(Konto4.AccountStatus()==1949);
        /*Konto4.DepositFunds(-1949);
        assertTrue(Konto4.AccountStatus()==0);
        Konto4.DepositFunds(666.66);
        assertTrue(Konto4.AccountStatus()==666.66);
        Konto4.DepositFunds(-66.66);
        assertTrue(Konto4.AccountStatus()==600.00);
        Konto4.DepositFunds(-100.00);
        assertTrue(Konto4.AccountStatus()==500.00);
        Konto4.DepositFunds(1449.51);
        assertTrue(Konto4.AccountStatus()==1949.51);
        Konto4.DepositFunds(-.51);
        assertTrue(Konto4.AccountStatus()==1949);*/
    }

    @Test
    public void withdrawFunds() {
        IAccount Konto5 = new Account();
        CreditCard karta5 = new CreditCard();
//        karta5.DepositFunds(1500);
        assertTrue(Konto5.AccountStatus()==0);
        Konto5.DepositFunds(50);
        assertTrue(Konto5.AccountStatus()==50);
    }
}