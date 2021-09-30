package com.uj.atm.Test.ICard;

import com.uj.atm.common.IAccount;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class ICardTestConnectAccountToCard {
    @Test
    public void test_connect_account_to_card() {
        IAccount account = new IAccount();
        account.DepositFunds(500.45);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        IAccount account2 = new IAccount();
        account2.DepositFunds(300.75);
        card.AddAccount(account2);

        card.WithdrawFunds(100);
        Assert.assertEquals(account.AccountStatus(), 400.45, 0);
    }
    @Test
    public void test_connect_account_to_many_cards() {
        IAccount account = new IAccount();
        account.DepositFunds(550.00);
        new IAccount();

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        ICreditCard card2 = new ICreditCard();
        card2.AddAccount(account);

        // check if the same account is linked to card & card2
        card.WithdrawFunds(100);
        card2.WithdrawFunds(50);
        Assert.assertEquals(account.AccountStatus(), 400, 0);
    }
}

