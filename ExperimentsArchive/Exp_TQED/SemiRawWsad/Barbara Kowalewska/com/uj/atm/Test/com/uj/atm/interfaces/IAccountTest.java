package com.uj.atm.interfaces;

import com.uj.atm.common.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class IAccountTest {
    Account myAccount = new Account();
    double amount1 = 145.4, amount2 = 260;

    @Test
    public void CreateAccount() {
        assertNotNull(myAccount);
    }

    @Test
    public void StartAccountStatusTrue() {//zakładam że saldo konta jest 0 na start
        assertEquals(0.0, myAccount.AccountStatus(), 0.01);
    }

    @Test
    public void StartAccountStatusFalse() {//zakładam że saldo konta jest 0 na start
        assertNotEquals(0.02, myAccount.AccountStatus(), 0.01);
    }

    @Test
    public void depositFundsTrue() {
        double saldo = myAccount.AccountStatus();
        assertEquals(saldo + amount1, myAccount.DepositFunds(amount1), 0.01);
    }

    @Test
    public void depositFundsFalse() {
        double saldo = myAccount.AccountStatus();
        myAccount.DepositFunds(amount1);
        assertNotEquals(saldo, myAccount.DepositFunds(amount1), 0.01);
    }

    @Test
    public void withdrawFundsTrue() {
        double saldo = myAccount.AccountStatus() + amount2 - amount1;
        myAccount.DepositFunds(amount2);
        assertEquals(saldo, myAccount.WithdrawFunds(amount1), 0.01);
    }

    @Test
    public void withdrawFundsFalse() {
        double saldo = myAccount.AccountStatus() + amount2 - amount1;
        myAccount.DepositFunds(amount2 * 2);
        assertNotEquals(saldo, myAccount.WithdrawFunds(amount1), 0.01);
    }
}