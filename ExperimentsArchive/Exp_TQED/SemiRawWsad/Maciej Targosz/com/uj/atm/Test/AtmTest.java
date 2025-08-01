package com.uj.atm.Test;

import com.uj.atm.common.CreditCard;
import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

    @Test
    public void CheckPinAndLogInTest(){
        CreditCard karta = new CreditCard();
        Atm atm = new Atm();

        Assert.assertTrue(atm.CheckPinAndLogIn(karta, "0000"));
        Assert.assertTrue(atm.CheckPinAndLogIn(karta, "0000"));
        Assert.assertTrue(atm.CheckPinAndLogIn(karta, "0000"));
        Assert.assertTrue(atm.CheckPinAndLogIn(karta, "0000"));
    }

    @Test
    public void CheckWrongPinAndLogInTest(){
        CreditCard karta = new CreditCard();
        Atm atm = new Atm();

        Assert.assertFalse(atm.CheckPinAndLogIn(karta, "6666"));
        Assert.assertFalse(atm.CheckPinAndLogIn(karta, "6666"));
        Assert.assertFalse(atm.CheckPinAndLogIn(karta, "6666"));
        Assert.assertFalse(atm.CheckPinAndLogIn(karta, "6666"));
    }

    @Test
    public void AccountStatusTest(){
        Account konto = new Account();
        Atm atm = new Atm();

        Assert.assertTrue(atm.AccountStatus(konto)==0);
        konto.DepositFunds(1000);
        Assert.assertFalse(atm.AccountStatus(konto)==0);
    }

    @Test
    public void ChangePinCardTest(){
        CreditCard karta = new CreditCard();
        Atm atm = new Atm();

        Assert.assertTrue(atm.ChangePinCard(karta, "0000", "1111", "1111"));
        Assert.assertFalse(atm.ChangePinCard(karta, "0000", "1111", "6666"));
        Assert.assertFalse(atm.ChangePinCard(karta, "0000", "1111", "11111"));
        Assert.assertFalse(atm.ChangePinCard(karta, "0000", "cccc", "cccc"));

    }

    @Test
    public void DepositFundsTest(){
        CreditCard karta = new CreditCard();
        Atm atm = new Atm();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(atm.WithdrawFunds(karta, -1));
        Assert.assertTrue(konto.AccountStatus()==0);
    }


    @Test
    public void WithdrawFundsTest(){
        CreditCard karta = new CreditCard();
        Atm atm = new Atm();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(atm.DepositFunds(karta, -1));
        Assert.assertTrue(atm.DepositFunds(karta, -1));
        Assert.assertTrue(konto.AccountStatus()==0);
    }

    @Test
    public void TransferTest(){
        CreditCard karta1 = new CreditCard();
        CreditCard karta2 = new CreditCard();
        Atm atm = new Atm();
        Account konto1 = new Account();
        Account konto2 = new Account();

        karta1.AddAccount(konto1);
        karta2.AddAccount(konto1);


        Assert.assertTrue(atm.Transfer(karta1, konto2, -1));
        Assert.assertTrue(konto1.AccountStatus()==0);


        Assert.assertTrue(atm.DepositFunds(karta1, 2137));
        Assert.assertTrue(atm.Transfer(karta1, konto2, -1));
        Assert.assertTrue(konto1.AccountStatus()==2137);
        Assert.assertFalse(konto2.AccountStatus()==2137);

    }
}
