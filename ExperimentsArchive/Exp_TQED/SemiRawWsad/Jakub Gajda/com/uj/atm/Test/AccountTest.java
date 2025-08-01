package com.uj.atm.Test;

import org.junit.Test;
import com.uj.atm.common.Account;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void accountStatus() {
        Account konto1 = new Account();
        assertTrue(konto1.AccountStatus()==0);
    }

    @Test
    public void depositFunds() {
        Account konto2 = new Account();
        konto2.DepositFunds(600);
        assertTrue(konto2.AccountStatus()==600);
        assertFalse(konto2.AccountStatus()==500);
        konto2.DepositFunds(-100);
        assertTrue(konto2.AccountStatus()==500);
        assertFalse(konto2.AccountStatus()==600);

    }

    @Test
    public void withdrawFunds() {
        Account konto3 = new Account();
        konto3.DepositFunds(680);
        konto3.WithdrawFunds(600);
        assertTrue(konto3.AccountStatus()==80);
        assertFalse(konto3.AccountStatus()==100);
    }
}