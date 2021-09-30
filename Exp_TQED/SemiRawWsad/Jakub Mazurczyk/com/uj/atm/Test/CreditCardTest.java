package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;


public class CreditCardTest {
    @Test
    public void test02(){
        String PIN = "1239";
        Account konto = new Account();
        CreditCard karta= new CreditCard();



        Assert.assertEquals(karta.IsPinValid(PIN),false);
        Assert.assertEquals(karta.IsPinValid("0000"),true);

        Assert.assertEquals(karta.ChangePin("0000",PIN,"2137"),false);
        Assert.assertEquals(karta.ChangePin("9131",PIN,PIN),false);
        Assert.assertEquals(karta.ChangePin("0000",PIN,PIN),true);

        Assert.assertEquals(karta.AddAccount(konto),true);
        Assert.assertEquals(karta.AddAccount(konto),false);

        Assert.assertEquals(karta.DepositFunds(89),true);

        Assert.assertEquals(karta.WithdrawFunds(100.0),false);
        Assert.assertEquals(karta.WithdrawFunds(30.0),true);

    }
}

