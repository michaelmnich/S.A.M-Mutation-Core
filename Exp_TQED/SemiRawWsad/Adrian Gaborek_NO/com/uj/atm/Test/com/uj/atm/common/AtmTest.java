package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    IAtm atm;
    ICreditCard card;
    IAccount account;

    @Before
    public void Initialize() {
          atm = new Atm();
          card = new CreditCard();
          account = new Account();
    }

    @Test
    public void LoginPassesForRightCredentialsForCard() {
        Assert.assertTrue(atm.CheckPinAndLogIn(card, "0000"));
    }

    @Test
    public void LoginDoesNotPassForNoCard() {
        Assert.assertFalse(atm.CheckPinAndLogIn(null, "0000"));
    }

    @Test
    public void LoginDoesNotPassForWrongCredentials() {
        Assert.assertFalse(atm.CheckPinAndLogIn(card, null));
        Assert.assertFalse(atm.CheckPinAndLogIn(card, "0001"));
        Assert.assertFalse(atm.CheckPinAndLogIn(card, "+000"));
        Assert.assertFalse(atm.CheckPinAndLogIn(card, ""));
    }

    @Test
    public void CheckingBalanceAccountWorksIfLoggedAndAccountMatch () {
        card.AddAccount(account);
        card.DepositFunds(200);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void IfAccountIsNotConnectedToCardDoNotReturnBalance() {
        card.DepositFunds(200);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertEquals(Double.NaN, atm.AccountStatus(account), 0);
        Assert.assertEquals(Double.NaN, atm.AccountStatus(null), 0);
    }

    @Test
    public void IfNotLoggedInDoNotReturnBalance() {
        card.AddAccount(account);
        card.DepositFunds(200);
        Assert.assertEquals(Double.NaN, atm.AccountStatus(account), 0);
    }

    @Test
    public void DepositWorksIfLoggedInAndCardMatchAndGoodValue() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertTrue(atm.DepositFunds(card, 200));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void DepositDoesntWorkIfLoggedInAndCardDontMatch() {
        ICreditCard card2 = new CreditCard();
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.DepositFunds(card2, 200));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
    }

    @Test
    public void DepositDoesntWorkIfNotLoggedIn() {
        card.AddAccount(account);
        Assert.assertFalse(atm.DepositFunds(card, 200));
        Assert.assertEquals(0, account.AccountStatus(), 0);
    }

    @Test
    public void DepositDoesntWorkForNoCard() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.DepositFunds(null, 200));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
    }

    @Test
    public void DepositDoesntWorkForBadValues() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.DepositFunds(card, -3));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.DepositFunds(card, Double.POSITIVE_INFINITY));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.DepositFunds(card, Double.POSITIVE_INFINITY));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.DepositFunds(card, Double.NaN));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
    }

    @Test
    public void DepositMoreThanMaxDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.DepositFunds(card, Double.MAX_VALUE + 1));
        Assert.assertTrue(atm.AccountStatus(account) > Double.MAX_VALUE);
    }

    @Test
    public void DepositLessThanMinDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.DepositFunds(card, Double.MIN_VALUE / 10));
        Assert.assertTrue(atm.AccountStatus(account) > 0);
    }

    @Test
    public void DepositOfMaxDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertTrue(atm.DepositFunds(card, Double.MAX_VALUE));
        Assert.assertEquals(Double.MAX_VALUE, atm.AccountStatus(account), 0);
    }

    @Test
    public void DepositOfMinDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertTrue(atm.DepositFunds(card, Double.MIN_VALUE));
        Assert.assertEquals(Double.MIN_VALUE, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawWorksIfLoggedInAndCardMatchAndGoodValue() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card, 200);
        Assert.assertTrue(atm.WithdrawFunds(card, 200));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawDoesntWorkIfLoggedInAndCardDontMatch() {
        ICreditCard card2 = new CreditCard();
        card.AddAccount(account);
        card.DepositFunds(200);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.WithdrawFunds(card2, 200));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawDoesntWorkIfNotLoggedIn() {
        card.AddAccount(account);
        card.DepositFunds(200);
        Assert.assertFalse(atm.WithdrawFunds(card, 200));
        Assert.assertEquals(200, account.AccountStatus(), 0);
    }

    @Test
    public void WithdrawDoesntWorkForNoCard() {
        card.AddAccount(account);
        card.DepositFunds(200);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.WithdrawFunds(null, 200));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawDoesntWorkForBadValues() {
        card.AddAccount(account);
        card.DepositFunds(200);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.WithdrawFunds(card, -3));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.WithdrawFunds(card, Double.POSITIVE_INFINITY));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.WithdrawFunds(card, Double.POSITIVE_INFINITY));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.WithdrawFunds(card, Double.NaN));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawMoreThanMaxDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card, Double.MAX_VALUE + 100);
        Assert.assertTrue(atm.WithdrawFunds(card, Double.MAX_VALUE + 10));
        Assert.assertEquals(90, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawLessThanMinDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card, 200);
        Assert.assertTrue(atm.WithdrawFunds(card, Double.MIN_VALUE / 10));
        Assert.assertTrue(atm.AccountStatus(account) < 200);
    }

    @Test
    public void WithdrawOfMaxDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card, Double.MAX_VALUE);
        Assert.assertTrue(atm.WithdrawFunds(card, Double.MAX_VALUE));
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawOfMinDoubleWorks() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card, 200 + Double.MIN_VALUE);
        Assert.assertTrue(atm.WithdrawFunds(card, Double.MIN_VALUE));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void WithdrawDoesntWorkIfThereIsNotEnoughMoney() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card, 200);
        Assert.assertFalse(atm.WithdrawFunds(card, 210));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void ChangingPinWorksLoggedInAndCardMatch() {
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertTrue(atm.ChangePinCard(card, "0000", "1234", "1234"));
        Assert.assertTrue(atm.CheckPinAndLogIn(card, "1234"));
    }

    @Test
    public void ChangingPinDoesntWorkIfNotLoggedIn() {
        card.AddAccount(account);
        Assert.assertFalse(atm.ChangePinCard(card, "0000", "1234", "1234"));
        Assert.assertFalse(atm.CheckPinAndLogIn(card, "1234"));
    }

    @Test
    public void ChangingPinDoesntWorkIfLoggedInForDifferentCard() {
        ICreditCard card2 = new CreditCard();
        card.AddAccount(account);
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        Assert.assertFalse(atm.ChangePinCard(card2, "0000", "1234", "1234"));
        Assert.assertFalse(atm.CheckPinAndLogIn(card2, "1234"));
    }

    @Test
    public void TransferWorksLoggedInCardMatchEnoughMoney() {
        IAccount reciever  = new Account();
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card,200);
        Assert.assertTrue(atm.Transfer(card, reciever, 200));
        Assert.assertEquals(200, reciever.AccountStatus(), 0);
        Assert.assertEquals(0, atm.AccountStatus(account), 0);
    }

    @Test
    public void TransferDoesntWorkLoggedInCardMatchEnoughMoneyNoReciever() {
        IAccount reciever  = new Account();
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card,200);
        Assert.assertFalse(atm.Transfer(card, null, 200));
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void TransferDoesntWorkLoggedInCardMatchEnoughMoneyInfinities() {
        IAccount reciever  = new Account();
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card,200);
        Assert.assertFalse(atm.Transfer(card, reciever, Double.POSITIVE_INFINITY));
        Assert.assertEquals(0, reciever.AccountStatus(), 0);
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.Transfer(card, reciever, Double.NEGATIVE_INFINITY));
        Assert.assertEquals(0, reciever.AccountStatus(), 0);
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void TransferDoesntWorkLoggedInCardMatchEnoughMoneyBadValues() {
        IAccount reciever  = new Account();
        card.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        atm.DepositFunds(card,200);
        Assert.assertFalse(atm.Transfer(card, reciever, Double.NaN));
        Assert.assertEquals(0, reciever.AccountStatus(), 0);
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.Transfer(card, reciever, -100));
        Assert.assertEquals(0, reciever.AccountStatus(), 0);
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
        Assert.assertFalse(atm.Transfer(card, reciever, 0));
        Assert.assertEquals(0, reciever.AccountStatus(), 0);
        Assert.assertEquals(200, atm.AccountStatus(account), 0);
    }

    @Test
    public void TransferDoesntWorkNotLoggedIn() {
        IAccount reciever  = new Account();
        card.AddAccount(account);
        card.DepositFunds(200);
        Assert.assertFalse(atm.Transfer(card, reciever, 200));
        Assert.assertEquals(0, reciever.AccountStatus(), 0);
        Assert.assertEquals(200, account.AccountStatus(), 0);
    }

    @Test
    public void TransferDoesntWorkLoggedInDifferentCard() {
        IAccount reciever  = new Account();
        ICreditCard card2 = new CreditCard();
        card.AddAccount(account);
        card2.AddAccount(account);
        atm.CheckPinAndLogIn(card, "0000");
        card.DepositFunds(200);
        Assert.assertFalse(atm.Transfer(card2, reciever, 200));
        Assert.assertEquals(0, reciever.AccountStatus(), 0);
        Assert.assertEquals(200, account.AccountStatus(), 0);
    }
}