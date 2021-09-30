package com.uj.atm.Test.ICard;

import com.uj.atm.common.IAccount;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class ICardTestWithdrawFunds {
    @Test
    public void test_withdraw_funds_via_card() {
        IAccount account = new IAccount();
        account.DepositFunds(550.95);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        IAccount account2 = new IAccount();
        account2.DepositFunds(300.75);
        card.AddAccount(account2);

        card.WithdrawFunds(100);
        Assert.assertEquals(account.AccountStatus(), 450.95, 0);
    }
    @Test
    public void test_withdraw_funds_via_many_cards() {
        IAccount account = new IAccount();
        account.DepositFunds(550.05);
        new IAccount();

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        ICreditCard card2 = new ICreditCard();
        card2.AddAccount(account);

        // check if the same account is linked to card & card2
        card.WithdrawFunds(100);
        card2.WithdrawFunds(50);
        Assert.assertEquals(account.AccountStatus(), 400.05, 0);
    }
}

