package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void test01(){
        IAccount accTest = new Account();
        Assert.assertTrue(accTest.AccountStatus() == 0);

        double zero = 0.0;
        Assert.assertTrue(accTest.AccountStatus() == zero);

        double saldo = accTest.AccountStatus();
        Assert.assertTrue(accTest.AccountStatus() == saldo);

        Double saldo2 = accTest.AccountStatus();
        Assert.assertTrue(saldo2.equals(zero));
    }

//wplacanie
    @Test
    public void test02(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        accTest.DepositFunds(20);
        Assert.assertTrue( accTest.AccountStatus() == 20);

    }

    @Test
    public void test03(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        accTest.DepositFunds(0);
        Assert.assertTrue( accTest.AccountStatus() == 0);
    }

    @Test
    public void test04(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        accTest.DepositFunds(-20);
        Assert.assertTrue( accTest.AccountStatus() == 0);
        accTest.DepositFunds(-20.232);
        Assert.assertTrue( accTest.AccountStatus() == 0);
    }

    @Test
    public void test05(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        Double kwota = 222.21;
        accTest.DepositFunds(kwota);
        Assert.assertTrue( accTest.AccountStatus() == 222.21);
        Assert.assertTrue( kwota.equals(accTest.AccountStatus()));

    }


    @Test
    public void test06(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        int kwota = 2221;
        accTest.DepositFunds(kwota);
        Assert.assertTrue( accTest.AccountStatus() == 2221);
    }


    //wyplacanie
    @Test
    public void test07(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);

        accTest.WithdrawFunds(20);
        Assert.assertTrue( accTest.AccountStatus() == 0);
    }


    @Test
    public void test08(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        Double kwota = 222.21;
        accTest.DepositFunds(kwota);
        Double saldoPrzed = accTest.AccountStatus();
        accTest.WithdrawFunds(20);
        Double saldoPo = accTest.AccountStatus();
        Assert.assertTrue( saldoPo == 202.21);
        Assert.assertTrue( saldoPrzed.equals(saldoPo+20));
    }


    @Test
    public void test09(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        Double kwota = 320.000;
        accTest.DepositFunds(kwota);
        Double saldoPrzed = accTest.AccountStatus();

        Double wyplata = 20.23;
        accTest.WithdrawFunds(wyplata);
        Double saldoPo = accTest.AccountStatus();
        Assert.assertTrue( saldoPo == saldoPrzed-wyplata);
        Assert.assertTrue( saldoPrzed.equals(saldoPo+wyplata));
    }


    @Test
    public void test10(){
        IAccount accTest = new Account();
        Assert.assertTrue( accTest.AccountStatus() == 0);
        Double kwota = 320.000;
        accTest.DepositFunds(kwota);
        Double saldo = accTest.AccountStatus();

        Double wyplata = 2220.23;
        accTest.WithdrawFunds(wyplata);
        Assert.assertTrue( saldo == accTest.AccountStatus());
        Assert.assertTrue( saldo.equals(accTest.AccountStatus()));

    }

}
