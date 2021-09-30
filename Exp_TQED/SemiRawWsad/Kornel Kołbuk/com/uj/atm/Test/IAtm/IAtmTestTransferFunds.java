package com.uj.atm.Test.IAtm;

import com.uj.atm.common.IAccount;
import com.uj.atm.common.IAtm;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class IAtmTestTransferFunds {
    @Test
    public void test_transfer_funds() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(200.02);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        IAccount accountRecipient = new IAccount();
        accountRecipient.DepositFunds(50.00);


        boolean status = iAtm.Transfer(card, accountRecipient, 100);
        Assert.assertTrue(status);

        Assert.assertEquals(account.AccountStatus(), 100.02, 0);
        Assert.assertEquals(iAtm.AccountStatus(account), 100.02, 0);

        Assert.assertEquals(accountRecipient.AccountStatus(), 150.00, 0);
        Assert.assertEquals(iAtm.AccountStatus(accountRecipient), 150.00, 0);
    }

    @Test
    public void test_transfer_too_many_funds() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(200.02);

        ICreditCard card = new ICreditCard();
        card.AddAccount(account);

        IAccount accountRecipient = new IAccount();
        accountRecipient.DepositFunds(50.00);


        boolean status = iAtm.Transfer(card, accountRecipient, 200.025);
        Assert.assertFalse(status);

        Assert.assertEquals(account.AccountStatus(), 200.02, 0);
        Assert.assertEquals(iAtm.AccountStatus(account), 200.02, 0);

        Assert.assertEquals(accountRecipient.AccountStatus(), 50.00, 0);
        Assert.assertEquals(iAtm.AccountStatus(accountRecipient), 50.00, 0);
    }

    @Test
    public void test_transfer_from_not_connected_cart_to_account() {
        IAtm iAtm = new IAtm();
        IAccount account = new IAccount();
        account.DepositFunds(200.02);

        ICreditCard card = new ICreditCard();

        IAccount accountRecipient = new IAccount();
        accountRecipient.DepositFunds(50.00);


        boolean status = iAtm.Transfer(card, accountRecipient, 100);
        Assert.assertFalse(status);

        Assert.assertEquals(account.AccountStatus(), 200.02, 0);
        Assert.assertEquals(iAtm.AccountStatus(account), 200.02, 0);

        Assert.assertEquals(accountRecipient.AccountStatus(), 50.00, 0);
        Assert.assertEquals(iAtm.AccountStatus(accountRecipient), 50.00, 0);
    }

}

