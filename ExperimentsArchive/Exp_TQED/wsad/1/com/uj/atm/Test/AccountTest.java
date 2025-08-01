package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    private static double money=100;
    @Test
    public void AddFoundsTest(){
        Account account = new Account(0);
        account.DepositFunds(money);
        assertEquals(money, account.AccountStatus(), 0);
    }
    @Test
    public void removeFoundsTest(){
        Account account = new Account(500);
        account.WithdrawFunds(money);
        assertEquals(400, account.AccountStatus(), 0);
    }

}

