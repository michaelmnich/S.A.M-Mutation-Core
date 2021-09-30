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
        ICreditCard creditCard = new CreditCard("1422");
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "1422"));
        Assert.assertEquals(0, atm.AccountStatus(account), 0.0);
        atm.ChangePinCard(creditCard, "1422", "1111", "1111");
        atm.CheckPinAndLogIn(creditCard, "1111");
        atm.DepositFunds(creditCard, 100);
        Assert.assertEquals(100, atm.AccountStatus(account), 0.0);
        atm.WithdrawFunds(creditCard, 100);
        Assert.assertEquals(0, atm.AccountStatus(account), 0.0);
    }

    @Test
    public void test02(){
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard("1422");
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "5612"));
        Assert.assertEquals(0, atm.AccountStatus(account), 0.0);
        atm.ChangePinCard(creditCard, "1422", "1111", "1121");
        atm.CheckPinAndLogIn(creditCard, "1111");
        atm.DepositFunds(creditCard, 100);
        Assert.assertEquals(100, atm.AccountStatus(account), 0.0);
        atm.WithdrawFunds(creditCard, 90);
        Assert.assertEquals(0, atm.AccountStatus(account), 0.0);
    }

    @Test
    public void test03(){
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000"));
    }

    @Test
    public void test04(){
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account();
        IAccount account2 = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 100));
        Assert.assertTrue(atm.Transfer(creditCard, account2, 23.50));
        Assert.assertEquals(23.50, account2.AccountStatus(), 0.0);
        Assert.assertEquals(76.50, atm.AccountStatus(account), 0.0);
    }

}
