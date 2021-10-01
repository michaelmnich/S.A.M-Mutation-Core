package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAtm;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogIn01() {
        IAtm atm = new Atm();
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),"0000"));
    }
    @Test
    public void checkPinAndLogIn02() {
        IAtm atm = new Atm();
        Assert.assertFalse(atm.CheckPinAndLogIn(new CreditCard(),"1111"));
    }
    @Test
    public void checkPinAndLogIn03() {
        IAtm atm = new Atm();
        Assert.assertFalse(atm.CheckPinAndLogIn(new CreditCard(),""));
    }

    @Test
    public void accountStatus01() {
        IAtm atm = new Atm();
        Assert.assertTrue(atm.AccountStatus(new Account())== 0.0 );
    }
    @Test
    public void accountStatus02() {
        IAtm atm = new Atm();
        Assert.assertTrue(atm.AccountStatus(new Account(200))== 200.0 );
    }

    @Test
    public void changePinCard() {
        IAtm atm = new Atm();
        Assert.assertTrue(atm.ChangePinCard(new CreditCard(), "0000", "1234","1234"));
    }

    @Test
    public void depositFunds01() {
        IAtm atm = new Atm();
        Assert.assertTrue(atm.DepositFunds(new CreditCard(new Account()),20)); }
    @Test
    public void depositFunds02() {
        IAtm atm = new Atm();
        Assert.assertFalse(atm.DepositFunds(new CreditCard(),20)); }
    @Test
    public void withdrawFunds01() {
        IAtm atm = new Atm();
        Assert.assertFalse(atm.WithdrawFunds(new CreditCard(),20)); }
    @Test
    public void withdrawFunds02() {
        IAtm atm = new Atm();
        Assert.assertTrue(atm.WithdrawFunds(new CreditCard(new Account(50)),20)); }

    @Test
    public void transfer01() {
        IAtm atm = new Atm();
        Assert.assertFalse(atm.Transfer(new CreditCard(new Account()),new Account(),200));
    }
    @Test
    public void transfer02() {
        IAtm atm = new Atm();
        Assert.assertTrue(atm.Transfer(new CreditCard(new Account(2222)),new Account(),200));
    }
}