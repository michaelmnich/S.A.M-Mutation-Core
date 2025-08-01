package com.uj.atm.Test.ICard;

import com.uj.atm.common.IAccount;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class ICardTestDepositFunds {
    @Test
    public void test_deposit_funds_via_card() {
        IAccount account = new IAccount();
        account.DepositFunds(510.45);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        IAccount account2 = new IAccount();
        account2.DepositFunds(300.75);
        card.AddAccount(account2);

        card.DepositFunds(100);
        Assert.assertEquals(account.AccountStatus(), 610.45, 0);
        Assert.assertEquals(account2.AccountStatus(), 300.75, 0);
    }

    @Test
    public void test_deposit_funds_via_many_cards() {
        IAccount account = new IAccount();
        account.DepositFunds(540.03);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        ICreditCard card2 = new ICreditCard();
        card2.AddAccount(account);

        IAccount account2 = new IAccount();
        ICreditCard card3 = new ICreditCard();
        card3.AddAccount(account2);

        // check if the same account is linked to card & card2
        card.DepositFunds(100);
        card2.DepositFunds(50.97);
        Assert.assertEquals(account.AccountStatus(), 691.00, 0);
        Assert.assertEquals(account2.AccountStatus(), 0.00, 0);
    }
}

