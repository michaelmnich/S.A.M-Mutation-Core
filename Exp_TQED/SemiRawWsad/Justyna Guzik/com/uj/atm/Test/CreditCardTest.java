package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CreditCardTest {

    @Test
    public void test01(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("2222", "3333","3333"));
    }

    @Test
    public void test02(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.ChangePin("112", "323","323"));
    }

    @Test
    public void test03(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.ChangePin("3", "3113","3113"));
    }

    @Test
    public void test04(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.ChangePin("3333", "3333","3333"));
    }

    @Test
    public void test05(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.ChangePin("3333", "2222","3333"));
    }

    @Test
    public void test06(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid("0000"));
    }

    @Test
    public void test07(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.IsPinValid("000"));
    }

    @Test
    public void test08(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.IsPinValid(""));
    }

    @Test
    public void test09(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.IsPinValid("9999"));
    }

    @Test
    public void test10(){
        ICreditCard creditCard  = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            creditCard.AddAccount(account);
        });
    }

    @Test
    public void test11(){
        ICreditCard creditCard  = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(400));
    }

    @Test
    public void test12(){
        ICreditCard creditCard  = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(400));
    }

    @Test
    public void test13(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.DepositFunds(400));
    }

    @Test
    public void test14(){
        ICreditCard creditCard  = new CreditCard();
        Assert.assertFalse(creditCard.WithdrawFunds(400));
    }

}
