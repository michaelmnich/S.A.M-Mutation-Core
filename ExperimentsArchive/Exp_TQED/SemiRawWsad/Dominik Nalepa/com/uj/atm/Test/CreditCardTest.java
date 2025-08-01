package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    //zmiana pinu

    //prawdilowa
    @Test
    public void test01() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.ChangePin("0000","1111","1111"));
    }

    //poprawny oldpin
    @Test
    public void test02() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("0000","111","111"));
        Assert.assertFalse(cardTest.ChangePin("0000","1111","111"));
        Assert.assertFalse(cardTest.ChangePin("0000","111","1111"));
        Assert.assertFalse(cardTest.ChangePin("0000","-111","-111"));
        Assert.assertFalse(cardTest.ChangePin("0000","-1111","-1111"));
    }

    //niepoprawny oldpin
    @Test
    public void test03() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("1111","1111","1111"));
        Assert.assertFalse(cardTest.ChangePin("1111213131","1111","1111"));
        Assert.assertFalse(cardTest.ChangePin("adasdad","1111","1111"));
        Assert.assertFalse(cardTest.ChangePin("adas","1111","1111"));
    }


    //niepoprawny newpin
    @Test
    public void test04() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("0000","11111","1111"));
        Assert.assertFalse(cardTest.ChangePin("0000","111","1111"));
        Assert.assertFalse(cardTest.ChangePin("0000","aaaa","1111"));
        Assert.assertFalse(cardTest.ChangePin("0000","aaaaa","1111"));

        Assert.assertFalse(cardTest.ChangePin("0000","11111","11111"));
        Assert.assertFalse(cardTest.ChangePin("0000","111","111"));
        Assert.assertFalse(cardTest.ChangePin("0000","aaaaa","aaa"));
        Assert.assertFalse(cardTest.ChangePin("0000","aaaa","aaaa"));
        Assert.assertFalse(cardTest.ChangePin("0000","aaaaa","aaaaa"));
    }


    //niepoprawny newpinconfirm
    @Test
    public void test05() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.ChangePin("0000","1111","11111"));
        Assert.assertFalse(cardTest.ChangePin("0000","1111","111"));
        Assert.assertFalse(cardTest.ChangePin("0000","1111","ada"));
        Assert.assertFalse(cardTest.ChangePin("0000","1111","adaa"));
        Assert.assertFalse(cardTest.ChangePin("0000","1111","aaaaa"));

    }

    //ispinvalid
    @Test
    public void test06() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        String PIN = "0000";
        Assert.assertTrue(cardTest.IsPinValid(PIN));
    }

    @Test
    public void test07() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertFalse(cardTest.IsPinValid("000"));
        Assert.assertFalse(cardTest.IsPinValid("1111"));
        Assert.assertFalse(cardTest.IsPinValid("00000"));
        String PIN = "000";
        Assert.assertFalse(cardTest.IsPinValid(PIN));
        PIN = "1111";
        Assert.assertFalse(cardTest.IsPinValid(PIN));
        PIN = "00000";
        Assert.assertFalse(cardTest.IsPinValid(PIN));
    }

    //add account i wplata oraz wyplata

    @Test
    public void test08() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        //wplata bez przypisania konta
        Assert.assertFalse(cardTest.DepositFunds(20));
        //wplata po przypisaniu konta
        cardTest.AddAccount(accTest);
        Assert.assertTrue(cardTest.DepositFunds(20));

    }



    @Test
    public void test09() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        //wyplata bez przypisania konta
        Assert.assertFalse(cardTest.WithdrawFunds(20));
        //wyplata po przypisaniu konta i wplaceniu
        cardTest.AddAccount(accTest);
        Assert.assertTrue(cardTest.DepositFunds(20));
        Assert.assertTrue(cardTest.WithdrawFunds(20));
    }

    @Test
    public void test10() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        //wyplata bez przypisania konta
        Assert.assertFalse(cardTest.WithdrawFunds(20));
        //wyplata po przypisaniu konta ale bez srodkow
        cardTest.AddAccount(accTest);
        Assert.assertFalse(cardTest.WithdrawFunds(20));
        double kwota = 20.23;
        Assert.assertFalse(cardTest.WithdrawFunds(kwota));
    }



    @Test
    public void test11() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        cardTest.AddAccount(accTest);
        //wplata do konta1
        Assert.assertTrue(cardTest.DepositFunds(200));
        Assert.assertTrue(cardTest.WithdrawFunds(20));
        //proba przypisania konta2 (jesli by sie nadpisalo nie bedzie mozliwa wyplata)
        IAccount accTest2 = new Account();
        cardTest.AddAccount(accTest2);
        Assert.assertTrue(cardTest.WithdrawFunds(20));
    }



    @Test
    public void test12() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        Double kwota = 20.22;
        //wplata bez przypisania konta
        Assert.assertFalse(cardTest.DepositFunds(kwota));
        //wplata po przypisaniu konta
        cardTest.AddAccount(accTest);
        Assert.assertTrue(cardTest.DepositFunds(kwota));

    }



    @Test
    public void test13() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        Double kwota = -21.21;
        //wplata bez przypisania konta
        Assert.assertFalse(cardTest.DepositFunds(kwota));
        Assert.assertFalse(cardTest.DepositFunds(-21.21));
        //wplata po przypisaniu konta
        cardTest.AddAccount(accTest);
        Assert.assertFalse(cardTest.DepositFunds(kwota));
        Assert.assertFalse(cardTest.DepositFunds(-21.21));
    }

    @Test
    public void test14() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        Double kwota = 0.0;
        //wplata bez przypisania konta
        Assert.assertFalse(cardTest.DepositFunds(kwota));
        Assert.assertFalse(cardTest.DepositFunds(0));
        Assert.assertFalse(cardTest.DepositFunds(0.0));
        //wplata po przypisaniu konta
        cardTest.AddAccount(accTest);
        Assert.assertFalse(cardTest.DepositFunds(kwota));
        Assert.assertFalse(cardTest.DepositFunds(0));
        Assert.assertFalse(cardTest.DepositFunds(0.0));

    }



    @Test
    public void test15() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        Double kwota = 20.22;
        //wyplata bez przypisania konta
        Assert.assertFalse(cardTest.WithdrawFunds(kwota));
        Assert.assertFalse(cardTest.WithdrawFunds(20.22));
        //wyplata po przypisaniu konta i wplaceniu
        cardTest.AddAccount(accTest);
        Assert.assertTrue(cardTest.DepositFunds(kwota));
        Assert.assertTrue(cardTest.DepositFunds(20.22));
        Assert.assertTrue(cardTest.WithdrawFunds(kwota));
        Assert.assertTrue(cardTest.WithdrawFunds(20.22));
    }

    @Test
    public void test16() {
        ICreditCard cardTest = new CreditCard();
        Assert.assertTrue(cardTest.IsPinValid("0000"));
        IAccount accTest = new Account();
        Double kwota = -20.22;
        //wyplata bez przypisania konta
        Assert.assertFalse(cardTest.WithdrawFunds(kwota));
        Assert.assertFalse(cardTest.WithdrawFunds(-20.22));
        //wyplata po przypisaniu konta i wplaceniu
        cardTest.AddAccount(accTest);
        Assert.assertFalse(cardTest.DepositFunds(kwota));
        Assert.assertFalse(cardTest.DepositFunds(-20.22));
        Assert.assertFalse(cardTest.WithdrawFunds(kwota));
        Assert.assertFalse(cardTest.WithdrawFunds(-20.22));
    }


}