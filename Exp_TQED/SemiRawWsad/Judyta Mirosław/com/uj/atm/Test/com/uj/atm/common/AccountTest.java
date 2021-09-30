package com.uj.atm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account ac = new Account(300);

    @Test
    public void getSaldo() {
        assertEquals(300, ac.getSaldo(), 0.0);
    }

    @Test
    public void createNegativeAccount() {
        Account acc = new Account(-100);
        assertEquals(0, acc.AccountStatus(), 0.0);
    }

    @Test
    public void createEmptyAccount() {
        Account acc = new Account(0);
        assertEquals(0, acc.AccountStatus(), 0.0);
    }

    @Test
    public void createAccount() {
        Account acc = new Account(100);
        assertEquals(100, acc.AccountStatus(), 0.0);
    }

    @Test
    public void setSaldo() {
        ac.setSaldo(305);
        assertEquals(305, ac.getSaldo(), 0.0);
    }

    @Test
    public void accountStatus() {
        assertEquals(300, ac.AccountStatus(), 0.0);
    }

    @Test
    public void depositFunds() {
        assertEquals(350, ac.DepositFunds(50), 0.0);
    }

    @Test
    public void withdrawFunds() {
        assertEquals(250, ac.WithdrawFunds(50), 0.0);
    }

    @Test
    public void withdrawTooMuchFunds() {
        assertEquals(0, ac.WithdrawFunds(350), 0.0);
        assertEquals(0, ac.WithdrawFunds(300.1), 0.0);
    }
}