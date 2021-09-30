package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

    @Test
    public void AccountStatus() {
        Atm atm = new Atm();
        Account acc = new Account();

        Assert.assertEquals(atm.AccountStatus(acc), acc.AccountStatus(), 0.0001);
    }

    @Test
    public void testCheckIncorrectLogin() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();

        Assert.assertFalse(atm.CheckPinAndLogIn(card, "1111"));
        Assert.assertTrue(atm.CheckPinAndLogIn(card, "0000"));
    }

    @Test
    public void testCheckCorrectLoginAfterPinChange() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();
        Account account = new Account();
        card.AddAccount(account);

        Assert.assertTrue(atm.CheckPinAndLogIn(card, "0000"));

        card.ChangePin("0000", "1111", "1111");
        Assert.assertTrue(atm.CheckPinAndLogIn(card, "1111"));
        Assert.assertFalse(atm.CheckPinAndLogIn(card, "0000"));
    }

    @Test
    public void testPinChange() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();
        Account account = new Account();
        card.AddAccount(account);

        Assert.assertTrue(atm.ChangePinCard(card, "0000", "1111", "1111"));
        Assert.assertFalse(atm.ChangePinCard(card, "4321", "1111", "1111"));
    }

    @Test
    public void testCorrectDepositFunds() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();
        Account account = new Account();
        card.AddAccount(account);

        Assert.assertTrue(atm.DepositFunds(card, 200));
    }

    @Test
    public void testWidthdrawFunds() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();
        Account account = new Account();
        card.AddAccount(account);

        Assert.assertFalse(atm.WithdrawFunds(card, 200));
        atm.DepositFunds(card,300);
        Assert.assertTrue(atm.WithdrawFunds(card, 200));
    }

    @Test
    public void testTransferFunds() {
        Atm atm = new Atm();
        Account acc = new Account();
        CreditCard card = new CreditCard();
        card.AddAccount(acc);

        Account recipientAccount = new Account();

        Assert.assertFalse(atm.Transfer(card, recipientAccount, 200));
        card.DepositFunds(190);
        Assert.assertFalse(atm.Transfer(card, recipientAccount, 200));
        card.DepositFunds(200);
        Assert.assertTrue(atm.Transfer(card, recipientAccount, 200));
        card.DepositFunds(210);
        Assert.assertTrue(atm.Transfer(card, recipientAccount, 200));
    }
}
