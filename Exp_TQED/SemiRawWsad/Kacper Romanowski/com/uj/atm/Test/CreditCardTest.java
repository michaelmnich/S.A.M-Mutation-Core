package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void test01(){
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard("1422");
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.IsPinValid("1422"));
        creditCard.ChangePin("1422", "1211", "1211");
        Assert.assertTrue(creditCard.IsPinValid("1211"));
        creditCard.DepositFunds(100);
        Assert.assertEquals(100, account.AccountStatus(), 0.0);
        creditCard.WithdrawFunds(100);
        Assert.assertEquals(0, account.AccountStatus(), 0.0);
    }

    @Test
    public void test02(){
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard("1422");
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.IsPinValid("5612"));
    }

    @Test
    public void test03(){
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard("1422");
        Assert.assertTrue(creditCard.ChangePin("1422", "1211", "1221"));
    }

    @Test
    public void test04(){
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.IsPinValid("0000"));
    }

}
