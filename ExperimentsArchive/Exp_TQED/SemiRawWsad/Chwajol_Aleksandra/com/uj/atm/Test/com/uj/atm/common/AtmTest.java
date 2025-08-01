package com.uj.atm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    Atm TestAtm = new Atm();
    CreditCard TestCard = new CreditCard();
    Account TestAccount = new Account();
     Account TestRecAccount = new Account();


    @Test
    public void CheckPinandLogIn() {
            assertTrue(TestAtm.CheckPinAndLogIn(TestCard, "1234"));
            // sytuacja kiedy pin do karty jest poprawny
            assertFalse(TestAtm.CheckPinAndLogIn(TestCard, "12344"));
            // sytuacja kiedy pin jest niepoprawny
            assertFalse(TestAtm.CheckPinAndLogIn(TestCard, "12a3"));
            //sytuacja kiedy pin jest w niepoprawnym formacie
    }

    @Test
    public void AccountStatus() {
        assertTrue(TestAtm.AccountStatus(TestAccount)==0);
        // zwraca popawną ilość saldo na koncie
        assertFalse(TestAtm. AccountStatus(TestAccount)==20);
        // sytuacja kiedy saldo na koncie się nie zgadza
    }

    @Test
    public void ChangePinCard() {
        assertTrue(TestAtm.ChangePinCard(TestCard, "1234", "1233", "1233"));
        // poprawna zmiana pinu karty
        assertFalse(TestAtm.ChangePinCard(TestCard, "1233", "1222", "1222"));
        // zmiana nie powiedzie się - zły pin stary
        assertFalse(TestAtm.ChangePinCard(TestCard, "1234", "1232", "1222"));
        // zmiana nie powiedzie się - nowy pin nie wpisany poprawnie dwa razy
        assertFalse(TestAtm.ChangePinCard(TestCard, "1234", "12222", "12222"));
        //zmiana nie powiedzie się - nowy pin za długi
        assertFalse(TestAtm.ChangePinCard(TestCard, "1233", "1a22", "1a22"));
        // zmiana nie powiedzie się - nowy pin nie jest poprawnego typu (liczbowego)
    }

    @Test
    public void DepositFunds() {

        TestCard.AddAccount(TestAccount);
        assertTrue(TestAtm.DepositFunds(TestCard, 20));
        //dodaną zostane środki na konto
        assertFalse(TestAtm.DepositFunds(TestCard, -20));
        // nie można dodać środków o wartości ujemnej
    }

    @Test
    public void WithdrawFunds() {

        TestCard.AddAccount(TestAccount);
        assertTrue(TestAtm.WithdrawFunds(TestCard, 0));
        //zostanie zabrana odpowiednia ilośćśrodków
        assertFalse(TestAtm.WithdrawFunds(TestCard, -20));
        // nie można pobrać ujemnej wartości z konta
        assertFalse(TestAtm.WithdrawFunds(TestCard, 2000));
        // nie można pobrać większej ilośći środków niż jest na koncie.
    }

    @Test
    public void Transfer() {

        TestCard.AddAccount(TestAccount);
        TestAccount.DepositFunds(10);

        TestRecAccount.DepositFunds(10);

        assertTrue(TestAtm.Transfer(TestCard, TestRecAccount, 0));
        //poprawne wysłanie pieniędzy na czyjeś konto
        assertFalse(TestAtm.Transfer(TestCard, TestRecAccount,-20));
        //nie można wysłać ujemnej liczby pieniedzy
        assertFalse((TestAtm.Transfer(TestCard, TestRecAccount, 20)));
        // nie można wysłać większej ilości pieniedzy niż się ma
    }
}