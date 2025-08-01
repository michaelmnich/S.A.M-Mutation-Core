package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AccountTest {

    @Test
    public void test01(){
        IAccount account = new Account();
        Assert.assertTrue(account.AccountStatus() == 0);
    }

    @Test
    public void test02(){
        IAccount account = new Account();
        double balance = account.DepositFunds(400);
        Assert.assertTrue(account.AccountStatus() == balance);
    }


    @Test
    public void test03(){
        IAccount account = new Account();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.DepositFunds(-300);
        });

    }

    @Test
    public void test04(){
        IAccount account = new Account();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.DepositFunds(-0);
        });
    }

    @Test
    public void test05(){
        IAccount account = new Account();
        account.DepositFunds(60);
        double balance = account.WithdrawFunds(50);
        Assert.assertTrue(account.AccountStatus() == balance);
    }

    @Test
    public void test06(){
        IAccount account = new Account();
        account.DepositFunds(500);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.WithdrawFunds(800);
        });
    }

    @Test //help
    public void test07(){
        IAccount account = new Account();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.DepositFunds(0);
        });
    }

}
