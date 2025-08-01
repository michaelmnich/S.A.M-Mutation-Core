package com.uj.atm.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    /**
     * Sprawdzam czy konto jest z dodatnim bilansem
     */
    @Test
    public void accountStatus() {
        IAccount konto1 = new Account();
        Assert.assertTrue(konto1.AccountStatus()>0);
    }
    /**
     * Sprawdzam czy wpłata 50zł na konto działa poprawnie
     */
    @Test
    public void depositFunds() {
        IAccount konto1 = new Account();
        double wplata = konto1.AccountStatus();
        wplata=wplata+50;
        konto1.DepositFunds(50);
        Assert.assertTrue(wplata==konto1.AccountStatus());
    }
    /**
     * Sprawdzam czy wypłata 50zł z konta działa poprawnie
     */
    @Test
    public void withdrawFunds() {
        IAccount konto1 = new Account();
        double wyplata = konto1.AccountStatus();
        wyplata=wyplata-50;
        konto1.WithdrawFunds(50);
        Assert.assertTrue(wyplata==konto1.AccountStatus());
    }
}