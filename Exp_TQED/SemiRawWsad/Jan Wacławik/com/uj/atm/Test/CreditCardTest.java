package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void test03() {
        ICreditCard zmiana = new CreditCard();
        boolean pin = zmiana.ChangePin("0000", "1234", "1234");
        Assert.assertTrue(zmiana.ChangePin("1234", "5555", "5555"));
    }

    @Test
    public void test04() {
        ICreditCard sprawdz = new CreditCard();
        Assert.assertTrue(sprawdz.IsPinValid("0000"));
    }

    @Test
    public void test05() {
        ICreditCard dodaj = new CreditCard();
        Assert.assertFalse(dodaj.DepositFunds(200));
    }

    @Test
    public void test06() {
        ICreditCard dodaj = new CreditCard();
        IAccount konto = new Account();
        dodaj.AddAccount(konto);
        Assert.assertTrue(dodaj.DepositFunds(300));
    }

    @Test
    public void test07() {
        ICreditCard dodaj = new CreditCard();
        IAccount konto = new Account();
        dodaj.AddAccount(konto);
        Assert.assertTrue(dodaj.WithdrawFunds(100));
    }
}
