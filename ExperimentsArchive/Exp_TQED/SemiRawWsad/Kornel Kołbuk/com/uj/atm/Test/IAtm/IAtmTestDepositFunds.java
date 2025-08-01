package com.uj.atm.Test.IAtm;

import com.uj.atm.common.IAccount;
import com.uj.atm.common.IAtm;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class IAtmTestDepositFunds {
    @Test
    public void test_deposit_funds_via_card() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(510.45);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        IAccount account2 = new IAccount();
        ICreditCard card2 = new ICreditCard();
        card2.AddAccount(account2);

        boolean status = iAtm.DepositFunds(card2, 300.75);
        Assert.assertTrue(status);
        card.AddAccount(account2);

        boolean status2 = iAtm.DepositFunds(card, 100.01);
        Assert.assertTrue(status2);

        Assert.assertEquals(account.AccountStatus(), 610.46, 0);
        Assert.assertEquals(account2.AccountStatus(), 300.75, 0);
    }

    @Test
    public void test_deposit_funds_via_many_cards() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(555.05);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        ICreditCard card2 = new ICreditCard();
        card2.AddAccount(account);

        IAccount account2 = new IAccount();
        ICreditCard card3 = new ICreditCard();
        card3.AddAccount(account2);

        // check if the same account is linked to card & card2
        boolean status = iAtm.DepositFunds(card, 100.01);
        Assert.assertTrue(status);

        boolean status2 = iAtm.DepositFunds(card2, 100.02);
        Assert.assertTrue(status2);

        Assert.assertEquals(account.AccountStatus(), 755.08, 0);
        Assert.assertEquals(account2.AccountStatus(), 0.00, 0);
    }
    @Test
    public void test_deposit_funds_via_card_which_is_not_connected_to_account() {
        IAtm iAtm = new IAtm();

        ICreditCard card = new ICreditCard();

        boolean status = iAtm.DepositFunds(card, 300.75);
        Assert.assertFalse(status);

    }
}

