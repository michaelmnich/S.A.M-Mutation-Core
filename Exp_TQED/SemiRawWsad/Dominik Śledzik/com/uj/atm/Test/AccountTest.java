package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class AccountTest {

    //Sprawdzamy czy konto zostało utworzone oraz czy bank wyświetla ilość środków na koncie
    @Test
    public void test1(){
        Account test = new Account();
        assertTrue(test!=null);
        assertTrue(test.AccountStatus() ==0);
    }

    @Test
    public void test2(){
        Account test = new Account();
        test.DepositFunds(420.20);
        assertTrue(test.AccountStatus() == 420.20);
        test.DepositFunds(-420.20);
        assertFalse(test.AccountStatus() == 0);
        assertTrue(test.AccountStatus() == 420.20);
    }

    @Test
    public void test3(){
        Account test = new Account();
        assertFalse(test.WithdrawFunds(420) == -420);
        assertTrue(test.WithdrawFunds(420) == 0);
        assertTrue(test.WithdrawFunds(-420) == 0);

        test.DepositFunds(2115);
        test.WithdrawFunds(2100);
        assertTrue(test.AccountStatus() == 15);
        assertFalse(test.AccountStatus() == -15);
        assertFalse(test.AccountStatus() == 0);
    }
}
