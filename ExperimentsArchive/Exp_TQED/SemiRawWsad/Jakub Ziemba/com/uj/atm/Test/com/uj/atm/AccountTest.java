package com.uj.atm;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void accountStatus() {
        Account testAcc = new Account(100);
        Account testAcc1 = new Account(-100);
        assertEquals(100, testAcc.AccountStatus(),0);
        assertEquals(0,testAcc1.AccountStatus(),0);
    }

    @Test
    public void depositFunds() {
        Account testAcc = new Account(100);
        assertEquals(200,testAcc.DepositFunds(100),0);
        assertEquals("Kwota musi być dodatnia!",200,testAcc.DepositFunds(-100),0);
    }

    @Test
    public void withdrawFunds() {
        Account testAcc = new Account(100);
        assertEquals(50,testAcc.WithdrawFunds(50),0);
        assertEquals("Kwota musi być dodatnia!",50,testAcc.WithdrawFunds(-100),0);
    }
}