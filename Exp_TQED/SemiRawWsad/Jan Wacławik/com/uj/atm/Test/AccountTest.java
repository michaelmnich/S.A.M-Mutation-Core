package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void test01() {
        IAccount wplata = new Account();
        double saldo = wplata.AccountStatus();
        Assert.assertTrue(wplata.DepositFunds(200) == 325);
        double l1 = wplata.DepositFunds(200);
        double l2 = 525;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);


    }

    @Test
    public void test02() {
        IAccount wyplata = new Account();
        double saldo = wyplata.AccountStatus();
        Assert.assertTrue(wyplata.WithdrawFunds(100) == 25);
        double l1 = wyplata.WithdrawFunds(10);
        double l2 = 15;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);
    }

}
