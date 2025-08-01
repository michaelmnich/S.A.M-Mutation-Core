package com.uj.atm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    Account TestAccount = new Account();

    @Test
    public void AccountStatus() {
        assertTrue(TestAccount.AccountStatus()==0); // sprawdzenie czy poprawnie odczytuje saldo
        assertFalse(TestAccount.AccountStatus()==20); // sprawdzenie czy saldo nie jest inne niż powinno
    }

    @Test
    public void DepositFunds() {
        TestAccount.DepositFunds(20);
        assertTrue(TestAccount.AccountStatus()==20); // sprawdzenie dodania pieniędzy na konto
        TestAccount.DepositFunds(-20);
        assertFalse(TestAccount.AccountStatus()==40); // sprawdzenie iż mimo że funkcja się wykonała, nie dodała nam źle wartości
        assertFalse(TestAccount.AccountStatus()==0); // sprawdzenie że ujemne wartości nie odejmują nam środków na koncie

    }

    @Test
    public void WithdrawFunds() {
        TestAccount.WithdrawFunds(20);
        assertTrue(TestAccount.AccountStatus()==0); // odbieranie działa poprawnie
        TestAccount.WithdrawFunds(-20);
        assertFalse(TestAccount.AccountStatus()<0); // nie da się zmieniać statusu ujemnymi liczbami
        TestAccount.WithdrawFunds(200);
        assertFalse(TestAccount.AccountStatus()<0); // nie da się wyciągnąć więcej niż się ma
    }
}