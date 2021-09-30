package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void TestChangePin(){
        CreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.ChangePin("0000", "1234", "1222"));
        Assert.assertFalse(creditCard.ChangePin("1111", "1234", "1234"));
        Assert.assertTrue(creditCard.ChangePin("0000", "1234", "1234"));
    }


    @Test
    public void TestIsPinValid(){
        CreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.IsPinValid("1234"));
        Assert.assertTrue(creditCard.IsPinValid("0000"));
    }

    @Test
    public void TestAddAccount(){
        CreditCard creditCard = new CreditCard();
        Account acc_test = new Account();
        creditCard.AddAccount(acc_test);
    }

    @Test
    public void TestDepositFunds(){
        CreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.DepositFunds(0));
        Account acc_test = new Account();
        acc_test.setBalance(100);
        creditCard.AddAccount(acc_test);
        Assert.assertTrue(creditCard.DepositFunds(100));
        Assert.assertTrue(acc_test.getBalance()==200);
    }

    @Test
    public void TestWithdrawFunds(){
        CreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.WithdrawFunds(0));
        Account acc_test = new Account();
        acc_test.setBalance(100);
        creditCard.AddAccount(acc_test);
        Assert.assertTrue(creditCard.WithdrawFunds(-1));
        Assert.assertTrue(acc_test.getBalance()==100);

        Assert.assertTrue(creditCard.WithdrawFunds(100));
        Assert.assertTrue(acc_test.getBalance()==0);
    }



}
