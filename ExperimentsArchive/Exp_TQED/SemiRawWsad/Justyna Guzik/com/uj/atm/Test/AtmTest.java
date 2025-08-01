package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

    @Test
    public void test01(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000"));
    }

    @Test
    public void test02(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, "000"));
    }

    @Test
    public void test03(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, "000"));
    }

    @Test
    public void test04(){
        IAtm atm = new Atm();
        IAccount account = new Account();
        Assert.assertTrue(atm.AccountStatus(account) == 0);
    }

    @Test
    public void test05(){
        IAtm atm = new Atm();
        IAccount account = new Account();
        Assert.assertFalse(atm.AccountStatus(account) == 400);
    }

    @Test
    public void test06(){
        IAtm atm = new Atm();
        IAccount account = new Account();
        account.DepositFunds(500);
        Assert.assertTrue(atm.AccountStatus(account) == 500);
    }

    @Test
    public void test07(){
        IAtm atm = new Atm();
        IAccount account = new Account();
        account.DepositFunds(500);
        account.WithdrawFunds(300);
        Assert.assertTrue(atm.AccountStatus(account) == 200);
    }

    @Test
    public void test08(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertTrue(atm.ChangePinCard(creditCard, "2222", "3333", "3333"));
    }

    @Test
    public void test09(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(atm.ChangePinCard(creditCard, "222", "3333", "3333"));
    }

    @Test
    public void test10(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(atm.ChangePinCard(creditCard, "2222", "33", "333"));
    }

    @Test
    public void test11(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(atm.DepositFunds(creditCard, 3333));
    }

    @Test
    public void test12(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 60));
    }

    @Test
    public void test13(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(atm.WithdrawFunds(creditCard, 90));
    }

    @Test
    public void test14(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        account.DepositFunds(100);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 90));
    }

    @Test
    public void test15(){
        IAtm atm = new Atm();
        ICreditCard creditCard  = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        account.DepositFunds(100);
        Assert.assertTrue(atm.Transfer(creditCard, account, 90));
    }










}
