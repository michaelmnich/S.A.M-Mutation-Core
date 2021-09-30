package com.uj.atm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    
    CreditCard TestCard = new CreditCard();
    Account TestAccount = new Account();

    @Test
    public void ChangePin() {
        assertTrue(TestCard.ChangePin("1234", "1233", "1233"));
        // poprawna zmiana pinu
        assertFalse(TestCard.ChangePin("1224", "1233", "1233"));
        // zmiana pinu nie powiodła się, zły stary pin
        assertFalse(TestCard.ChangePin("1234", "1233", "1223"));
        // zmiana pinu nie powiodła się, nowy pin nie podany poprawnie dwa razy
        assertFalse(TestCard.ChangePin("1234", "12A3", "1233"));
        // zmiana pinu nie powiodła się, pin nie jest liczbą
        assertFalse(TestCard.ChangePin("1234", "12333", "12333"));
        //zmiana pinu nie powiodła się, pin za długi
    }

    @Test
    public void IsPinValid() {

        assertTrue(TestCard.IsPinValid("1234"));
        // sprawdza czy pin poprawny został podany
        assertFalse(TestCard.IsPinValid("1233"));
        // reakcja na podanie złego pinu
        assertFalse(TestCard.IsPinValid("12344"));
        // reakcja na za długi pin
        assertFalse(TestCard.IsPinValid("12a4"));
        // reakcja na pin niepoprawnego formatu

    }

    @Test
    public void DepositFunds() {

        TestCard.AddAccount(TestAccount);
        assertTrue(TestCard.DepositFunds(20));
        // działa dodanie środków na konto
        assertFalse(TestCard.DepositFunds(-20));
        // nie można dodać ujemnej liczby środków
    }

    @Test
    public void WithdrawFunds() {

        TestCard.AddAccount(TestAccount);
        assertTrue(TestCard.WithdrawFunds(0));
        // działa odjęcie środków z konta
        assertFalse(TestCard.WithdrawFunds(-20));
        // nie można odjąć ujemnej liczby środków
        assertFalse(TestCard.WithdrawFunds(20));
        // nie można odjąć więcej niż się ma na koncie


    }
}