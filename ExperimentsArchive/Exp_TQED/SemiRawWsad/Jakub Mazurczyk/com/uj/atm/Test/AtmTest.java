package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;


public class AtmTest {
    @Test
    public void test02(){
        String PIN = "1239";
        Account konto = new Account();
        Account konto2 = new Account();
        CreditCard karta= new CreditCard();
        karta.AddAccount(konto);
        Atm atm= new Atm();

        Assert.assertEquals(atm.CheckPinAndLogIn(karta,PIN),false);
        Assert.assertEquals(atm.CheckPinAndLogIn(karta,"0000"),true);

        Assert.assertEquals(atm.ChangePinCard(karta,"0000",PIN,"2137"),false);
        Assert.assertEquals(atm.ChangePinCard(karta,"9131",PIN,PIN),false);
        Assert.assertEquals(atm.ChangePinCard(karta,"0000",PIN,PIN),true);

        Assert.assertEquals(atm.DepositFunds(karta,89),true);

        Assert.assertEquals(atm.AccountStatus(konto),89.0,0);

        Assert.assertEquals(atm.WithdrawFunds(karta,100.0),false);
        Assert.assertEquals(atm.WithdrawFunds(karta,30.0),true);

        Assert.assertEquals(atm.Transfer(karta,konto2,21370),false);
        Assert.assertEquals(atm.Transfer(karta,konto2,1),true);
        Assert.assertEquals(atm.AccountStatus(konto2),1,0);






    }
}

