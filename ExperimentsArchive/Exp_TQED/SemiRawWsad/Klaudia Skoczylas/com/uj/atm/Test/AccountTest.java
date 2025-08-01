package com.uj.atm.Test;

import com.uj.atm.common.AccountSample;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    /*Test sprawdzający wpłatę oraz wypłatę dodatnich kwot*/
    @Test
    public void test01(){
        IAccount accountSample = new AccountSample();
        Assert.assertTrue(accountSample.AccountStatus() == 0.0);
        Assert.assertTrue(accountSample.DepositFunds(15.35) == 15.35);
        Assert.assertTrue(accountSample.WithdrawFunds(6.8) == 8.55);

    }

    /*Test sprawdzający wpłatę kwoty 0.0 oraz wypłatę kwoty ujemnej*/
    @Test
    public void test02(){
        IAccount accountSample = new AccountSample();
        Assert.assertTrue(accountSample.AccountStatus() == 0.0);
        Assert.assertTrue(accountSample.DepositFunds(0.0) == 0.0);
        Assert.assertTrue(accountSample.WithdrawFunds(-90.0) == 0.0);

    }

    /*Test sprawdzający wpłatę kwoty ujemnej oraz wypłatę kwoty dodatniej*/
    @Test
    public void test03(){
        IAccount accountSample = new AccountSample();
        Assert.assertTrue(accountSample.AccountStatus() == 0.0);
        Assert.assertTrue(accountSample.DepositFunds(-80.0) == 0.0);
        Assert.assertTrue(accountSample.WithdrawFunds(20.0) == 0.0);

    }

    /*Test sprawdzający wpłatę oraz wypłatę kwoty 0.0 */
    @Test
    public void test04(){
        IAccount accountSample = new AccountSample();
        Assert.assertTrue(accountSample.AccountStatus() == 0.0);
        Assert.assertTrue(accountSample.DepositFunds(0.0) == 0.0);
        Assert.assertTrue(accountSample.WithdrawFunds(0.0) == 0.0);
    }

    /*Test sprawdzający wpłatę kwoty dodatniej oraz wypłatę całej kwoty*/
    @Test
    public void test05(){
        IAccount accountSample = new AccountSample();
        Assert.assertTrue(accountSample.AccountStatus() == 0.0);
        Assert.assertTrue(accountSample.DepositFunds(0.11) == 0.11);
        Assert.assertTrue(accountSample.WithdrawFunds(0.11) == 0.0);
    }

    /*Test sprawdzający wpłatę kwoty dodatniej oraz próbę wypłaty większej kwoty niż podane saldo*/
    @Test
    public void test06(){
        IAccount accountSample = new AccountSample();
        Assert.assertTrue(accountSample.AccountStatus() == 0.0);
        Assert.assertTrue(accountSample.DepositFunds(150.11) == 150.11);
        Assert.assertTrue(accountSample.WithdrawFunds(534.47) == 150.11);
    }
}
