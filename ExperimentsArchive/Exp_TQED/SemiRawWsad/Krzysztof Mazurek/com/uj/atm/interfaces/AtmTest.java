package com.uj.atm.interfaces;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogIn() {
        ICreditCard karta = new CreditCard();
        IAtm Pin = new Atm();
        String pin = "1234";
        Assert.assertTrue(karta.IsPinValid(pin)==Pin.CheckPinAndLogIn(karta,pin));
    }

    @Test
    public void accountStatus() {
        IAccount konto1 = new Account();
        Assert.assertTrue(konto1.AccountStatus()>10);
    }

    @Test
    public void changePinCard() {
        IAtm pin = new Atm();
        ICreditCard karta = new CreditCard();
        Assert.assertTrue(pin.ChangePinCard(karta, "0000","1234","1234")==true);
    }

    @Test
    public void depositFunds() {
        ICreditCard karta = new CreditCard();
        IAtm transfer = new Atm();
        IAccount konto = new Account();
        double wplata = konto.AccountStatus();
        wplata = wplata + 50;
        transfer.DepositFunds(karta,50);
        Assert.assertTrue(wplata==konto.AccountStatus());
    }

    @Test
    public void withdrawFunds() {
        ICreditCard karta = new CreditCard();
        IAtm transfer = new Atm();
        IAccount konto = new Account();
        double wyplata = konto.AccountStatus();
        wyplata = wyplata - 50;
        transfer.WithdrawFunds(karta,50);
        Assert.assertTrue(wyplata==konto.AccountStatus());
    }

    @Test
    public void transfer() {
        ICreditCard karta = new CreditCard();
        IAtm transfer = new Atm();
        IAccount konto2 = new Account();
        Assert.assertTrue(transfer.Transfer(karta,konto2,50)==true);

    }
}