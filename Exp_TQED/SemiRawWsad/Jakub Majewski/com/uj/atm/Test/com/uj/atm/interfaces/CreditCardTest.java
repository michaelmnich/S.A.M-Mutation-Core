package com.uj.atm.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    /**
     * Test sprawdzający czy można podać pin zawierajacy literę
     */
    @Test
    public void changePin() {
        ICreditCard test1 = new CreditCard();
        Assert.assertTrue(test1.ChangePin("0000","28H5","28H5"));
    }

    /**
     * Test sprawdzający czy pin zawierający literę będzie poprawny
     */
    @Test
    public void isPinValid() {
        ICreditCard test2 = new CreditCard();
        Assert.assertTrue(test2.IsPinValid("55A5"));
    }

    /**
     * Nie potrafię zrobić testu na typie void, zamiar był taki aby sprawdzić
     * czy możemy dodać dwa razy to samo konto do jednej karty
     */
    @Test
    public void addAccount() {
        ICreditCard test3 = new CreditCard();
        IAccount konto3 = new Account();
        test3.AddAccount(konto3);
        test3.AddAccount(konto3);
    }

    /**
     * Test sprawdzający czy można wpłacić ujemną kwotę
     */
    @Test
    public void depositFunds() {
        ICreditCard test = new CreditCard();
        IAccount konto = new Account();
        test.AddAccount(konto);
        Assert.assertFalse(test.DepositFunds(-100));
    }

    /**
     * Test sprawdzjący czy można wypłacić kwotę większą niż aktualny stan konta
     */
    @Test
    public void withdrawFunds() {
        ICreditCard test5 = new CreditCard();
        IAccount konto5 = new Account();
        test5.AddAccount(konto5);
        double L5= konto5.AccountStatus()+100;
        Assert.assertFalse(test5.WithdrawFunds(L5));

    }
}