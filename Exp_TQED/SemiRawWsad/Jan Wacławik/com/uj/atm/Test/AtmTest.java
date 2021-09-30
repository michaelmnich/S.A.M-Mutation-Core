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
    public void test08() {
        IAtm logowanie = new Atm();
        IAccount konto = new Account();
        ICreditCard karta = new CreditCard();
        karta.AddAccount(konto);
        Assert.assertTrue(logowanie.CheckPinAndLogIn(karta, "0000"));
    }

    @Test
    public void test09() {
        IAtm status = new Atm();
        IAccount konto = new Account();
        konto.AccountStatus();
        Assert.assertTrue(konto.AccountStatus() == 125);
        double x = status.AccountStatus(konto);
        double y = 125;
        double epsilon = 0.000001d;
        Assert.assertEquals(x, y, epsilon);
    }

    @Test
    public void test10() {
        IAtm bankomat = new Atm();
        ICreditCard karta = new CreditCard();
        Assert.assertTrue(bankomat.ChangePinCard(karta, "0000", "1234", "1234"));
    }

    @Test
    public void test11() {
        IAtm bankomat = new Atm();
        IAccount konto = new Account();
        ICreditCard karta = new CreditCard();
        karta.AddAccount(konto);
        Assert.assertTrue(bankomat.DepositFunds(karta, 300));
    }

    @Test
    public void test12() {
        IAtm bankomat = new Atm();
        IAccount konto = new Account();
        ICreditCard karta = new CreditCard();
        karta.AddAccount(konto);
        Assert.assertTrue(bankomat.WithdrawFunds(karta, 100));
    }

    @Test
    public void test13() {
        IAtm bankomat = new Atm();
        IAccount konto = new Account();
        ICreditCard karta = new CreditCard();
        karta.AddAccount(konto);
        IAccount konto2 = new Account();
        Assert.assertTrue(bankomat.Transfer(karta, konto2, 50));
    }
}
