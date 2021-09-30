package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void cctest(){
        IAccount acc = new Account(200);
        ICreditCard cc = new CreditCard();
        Assert.assertTrue(cc.IsPinValid("0000"));
        cc.ChangePin("0000","1234","1234");
        Assert.assertTrue(cc.IsPinValid("1234"));
        cc.AddAccount(acc);
        Assert.assertTrue(cc.WithdrawFunds(150));
        cc.DepositFunds(150);
        Assert.assertTrue(acc.AccountStatus()==200);

    }

    @Test
    public void cctest2(){
        ICreditCard cc = new CreditCard();
        Assert.assertTrue(cc.IsPinValid("1234"));
        cc.ChangePin("1234","0000","0000");
        Assert.assertTrue(cc.IsPinValid("1234"));
    }
}
