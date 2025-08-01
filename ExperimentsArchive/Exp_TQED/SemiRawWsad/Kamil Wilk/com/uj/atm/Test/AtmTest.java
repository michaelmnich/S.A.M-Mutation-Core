package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class AtmTest {

    @Test
    public void CheckPinAndLogInTest1() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertFalse(atm.CheckPinAndLogIn(card, "1111"));
    }

    @Test
    public void CheckPinAndLogInTest2() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertTrue(atm.CheckPinAndLogIn(card, "0000"));
    }

    @Test
    public void AccountStatusTest1() {
        IAtm atm = new Atm();
        IAccount account= new Account();
        Assert.assertTrue(atm.AccountStatus(account) == 0);
        Double d1 = atm.AccountStatus(account);
        Double d2 = 0d;
        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void ChangePinCardTest1() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertFalse(atm.ChangePinCard(card,"0000", "1111", "1112"));
    }

    @Test
    public void ChangePinCardTest2() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertFalse(atm.ChangePinCard(card,"0101", "1111", "1111"));
    }


    @Test
    public void ChangePinCardTest3() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertTrue(atmTest.ChangePinCard(cardTest,"0000", "1111", "1111"));
    }


    @Test
    public void DepositFundsTest1() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertFalse(atm.DepositFunds(card, 10));
    }

    @Test
    public void DepositFundsTest2() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        IAccount account = new Account();
        card.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(card, 10));
    }

    @Test
    public void WithdrawFundsTest1() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertFalse(atm.WithdrawFunds(card, 10));
    }

    @Test
    public void WithdrawFundsTest2() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        IAccount account = new Account();
        card.AddAccount(account);
        Assert.assertFalse(atm.WithdrawFunds(card, 10));
    }

    @Test
    public void WithdrawFundsTest3() {
        ICreditCard card = new CreditCard();
        IAtm atm = new Atm();
        IAccount account = new Account();
        card.AddAccount(account);
        card.DepositFunds(20);
        Assert.assertTrue(atm.WithdrawFunds(card, 10));
    }

    @Test
    public void TransferTest1() {
        IAtm atm = new Atm();
        ICreditCard card = new CreditCard();
        IAccount account1 = new Account();
        IAccount account2 = new Account();
        card.AddAccount(account1);
        Assert.assertFalse(atm.Transfer(card, account2, 10));
    }

    @Test
    public void TransferTest2() {
        IAtm atm = new Atm();
        ICreditCard card = new CreditCard();
        IAccount account1 = new Account();
        IAccount account2 = new Account();
        card.AddAccount(account1);
        card.DepositFunds(20);
        Assert.assertTrue(atm.Transfer(card, account2, 10));
        Assert.assertTrue(account2.AccountStatus() == 10);
        Double d1 = account2.AccountStatus();
        Double d2 = 10d;
        Assert.assertTrue(d1.equals(d2));
    }
}