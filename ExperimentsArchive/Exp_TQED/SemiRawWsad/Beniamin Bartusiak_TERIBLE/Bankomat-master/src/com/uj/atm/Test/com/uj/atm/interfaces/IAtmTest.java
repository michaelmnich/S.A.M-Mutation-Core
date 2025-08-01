package com.uj.atm.interfaces;

import com.uj.atm.common.ATMoperation;
import com.uj.atm.common.AccountBalance;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IAtmTest {

    @Test
    public void checkPinAndLogIn() {
        IAtm atm = new ATMoperation();
        CreditCard card = new CreditCard();
        Assert.assertTrue(atm.CheckPinAndLogIn(card,"1234"));
    }


    @Test
    public void accountStatus() {
        IAccount account = new AccountBalance();
        IAtm atm = new ATMoperation();
        account.DepositFunds(22);
        Assert.assertTrue(atm.AccountStatus(account)==22);
    }

    @Test
    public void changePinCard() {
        IAtm atm = new ATMoperation();
        CreditCard card = new CreditCard();
        Assert.assertTrue(atm.ChangePinCard(card,"1234","1111","1111")==true);
    }

    @Test
    public void depositFunds() {
        IAtm atm = new ATMoperation();
        CreditCard card = new CreditCard();
        IAccount account = new AccountBalance();
        card.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(card,22)==true);
    }

    @Test
    public void withdrawFunds() {
        IAtm atm = new ATMoperation();
        CreditCard card = new CreditCard();
        IAccount account = new AccountBalance();
        card.AddAccount(account);
        Assert.assertTrue(atm.WithdrawFunds(card,22)==true);
    }

    @Test
    public void transfer() {
        IAtm atm = new ATMoperation();
        CreditCard card = new CreditCard();
        IAccount account = new AccountBalance();
        card.AddAccount(account);
        card.DepositFunds(22);
        Assert.assertTrue(atm.Transfer(card,account,22) == true);
        Assert.assertTrue(atm.AccountStatus(account)==22);
    }
}