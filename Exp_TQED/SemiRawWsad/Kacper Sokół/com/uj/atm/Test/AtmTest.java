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
    public void atmtest(){
        ICreditCard cc = new CreditCard();
        IAccount acc = new Account(500);
        IAccount acc2 = new Account(100);
        IAtm a = new Atm();
        cc.AddAccount(acc);
        a.CheckPinAndLogIn(cc, "0000");
        Assert.assertEquals(500, a.AccountStatus(acc), 0.0);
        Assert.assertTrue(a.ChangePinCard(cc, "0000", "1234", "1234"));
        a.DepositFunds(cc, 200);
        Assert.assertEquals(700, a.AccountStatus(acc), 0.0);
        a.WithdrawFunds(cc, 500);
        Assert.assertEquals(200, a.AccountStatus(acc), 0.0);
        a.Transfer(cc, acc2, 150);
        Assert.assertEquals(250, acc2.AccountStatus(), 0.0);


    }
}
