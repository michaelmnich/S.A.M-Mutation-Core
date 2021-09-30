package com.uj.atm.Test.IAtm;

import com.uj.atm.common.IAccount;
import com.uj.atm.common.IAtm;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class IAtmTestWithdrawFunds {
    @Test
    public void test_withdraw_funds_via_card() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(200.02);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        boolean status = iAtm.WithdrawFunds(card,100);
        Assert.assertTrue(status);

        Assert.assertEquals(account.AccountStatus(), 100.02, 0);
        Assert.assertEquals(iAtm.AccountStatus(account), 100.02, 0);
    }

    @Test
    public void test_withdraw_funds_via_many_cards() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(200.02);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        ICreditCard card2 = new ICreditCard();
        card2.AddAccount(account);

        boolean status = iAtm.WithdrawFunds(card,100);
        Assert.assertTrue(status);

        boolean status2 = iAtm.WithdrawFunds(card2,0.02);
        Assert.assertTrue(status2);

        Assert.assertEquals(account.AccountStatus(), 100, 0);
        Assert.assertEquals(iAtm.AccountStatus(account), 100.00, 0);
    }

    @Test
    public void test_withdraw_funds_via_card_which_is_not_connected_with_account() {
        IAtm iAtm = new IAtm();

        ICreditCard card = new ICreditCard();

        boolean status = iAtm.WithdrawFunds(card,100);
        Assert.assertFalse(status);
    }

    @Test
    public void test_withdraw_too_many_funds_via_card() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(200.02);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        boolean status = iAtm.WithdrawFunds(card,200.025);
        Assert.assertFalse(status);

        Assert.assertEquals(account.AccountStatus(), 200.02, 0);
        Assert.assertEquals(iAtm.AccountStatus(account), 200.02, 0);
    }
}

