package com.uj.atm.Bank;

import org.junit.Assert;
import org.junit.Test;



public class AtmTest {
    Atm atm = new Atm();
    Account[] acc = new Account[5];
    CreditCard newCard = new CreditCard("1111");


    @Test
    public void checkPinAndLogIn() {
        Assert.assertTrue(atm.CheckPinAndLogIn(newCard,"1111"));
    }
    @Test
    public void checkPinAndLogIn2() {
        Assert.assertFalse(atm.CheckPinAndLogIn(newCard,""));
    }

    @Test
    public void accountStatus()
    {
        double tmp = 1000.00;
        acc[0] = new Account(tmp);
        Assert.assertEquals(tmp,atm.AccountStatus(acc[0]),0.0);
    }
    @Test
    public void changePinCard() {
        newCard = new CreditCard("1111");
        atm.ChangePinCard(newCard,"1111","1234","1234");
        Assert.assertEquals(newCard.pin,"1234");
    }
    @Test
    public void changePinCard2() {
        Assert.assertTrue(atm.ChangePinCard(newCard,"1111","1234","1234"));
    }
    @Test
    public void depositFunds() {
        Assert.assertTrue(atm.DepositFunds(newCard,1000.00));
    }
    @Test
    public void depositFunds2() {
        acc[0] = new Account(1000.00);
        newCard = new CreditCard("0000");
        newCard.AddAccount(acc[0]);
        atm.DepositFunds(newCard,500.00);
        Assert.assertEquals(newCard.accountCard.balance,1500.00,0.0);

    }
    @Test
    public void withdrawFunds() {
        newCard.accountCard.balance = 1000.00;
        Assert.assertTrue(atm.WithdrawFunds(newCard,500.00));
    }
    @Test
    public void withdrawFunds2() {
        acc[0] = new Account(1000.00);
        newCard = new CreditCard("0000");
        newCard.AddAccount(acc[0]);
        atm.WithdrawFunds(newCard,500.00);
        Assert.assertEquals(newCard.accountCard.balance,500.00,0.0);

    }

    @Test
    public void transfer() {
        acc[1] = new Account(200.00);
        acc[2] = new Account(200.00);
        newCard.AddAccount(acc[1]);
        Assert.assertTrue(atm.Transfer(newCard,acc[2],100.00));
    }
    @Test
    public void transfer2() {
        acc[1] = new Account(200.00);
        acc[2] = new Account(200.00);
        newCard.AddAccount(acc[1]);
        atm.Transfer(newCard,acc[2],100.00);
        Assert.assertEquals(acc[2].balance,300.00,0.0);
    }
    @Test
    public void transfer3() {
        acc[1] = new Account(200.00);
        acc[2] = new Account(200.00);
        newCard.AddAccount(acc[1]);
        Assert.assertFalse(atm.Transfer(newCard,acc[2],300.00));

    }
    @Test
    public void transfer4() {
        acc[1] = new Account(200.00);
        acc[2] = new Account(200.00);
        newCard.AddAccount(acc[1]);
        atm.Transfer(newCard,acc[2],100.00);
        Assert.assertTrue((acc[1].balance == 100.00) && (acc[2].balance == 300.00));
    }
}