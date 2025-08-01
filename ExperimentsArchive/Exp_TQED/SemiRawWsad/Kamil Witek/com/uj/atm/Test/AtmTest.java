package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogInTest01() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertFalse(atmTest.CheckPinAndLogIn(cardTest, "1234"));
    }

    @Test
    public void checkPinAndLogInTest02() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertTrue(atmTest.CheckPinAndLogIn(cardTest, "0000"));
    }

    @Test
    public void accountStatusTest01() {
        IAtm atmTest = new Atm();
        IAccount accountTest = new Account();
        Assert.assertTrue(atmTest.AccountStatus(accountTest) == 0);
        Double s1 = atmTest.AccountStatus(accountTest);
        Double s2 = 0d;
        Assert.assertTrue(s1.equals(s2));
    }

    @Test
    public void changePinCardTest01() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertFalse(atmTest.ChangePinCard(cardTest,"0000", "1234", "123"));
    }

    @Test
    public void changePinCardTest02() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertFalse(atmTest.ChangePinCard(cardTest,"0001", "1234", "123"));
    }

    @Test
    public void changePinCardTest03() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertFalse(atmTest.ChangePinCard(cardTest,"0000", "123", "123"));
    }

    @Test
    public void changePinCardTest04() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertFalse(atmTest.ChangePinCard(cardTest,"0000", "123", "1234"));
    }

    @Test
    public void changePinCardTest05() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertTrue(atmTest.ChangePinCard(cardTest,"0000", "1234", "1234"));
    }


    @Test
    public void depositFundsTest01() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertFalse(atmTest.DepositFunds(cardTest, 50));
    }

    @Test
    public void depositFundsTest02() {
        IAccount accountTest = new Account();
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        cardTest.AddAccount(accountTest);
        Assert.assertTrue(atmTest.DepositFunds(cardTest, 50));
    }

    @Test
    public void withdrawFundsTest01() {
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        Assert.assertFalse(atmTest.WithdrawFunds(cardTest, 50));
    }

    @Test
    public void withdrawFundsTest02() {
        IAccount accountTest = new Account();
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        cardTest.AddAccount(accountTest);
        Assert.assertFalse(atmTest.WithdrawFunds(cardTest, 50));
    }

    @Test
    public void withdrawFundsTest03() {
        IAccount accountTest = new Account();
        ICreditCard cardTest = new CreditCard();
        IAtm atmTest = new Atm();
        cardTest.AddAccount(accountTest);
        cardTest.DepositFunds(50);
        Assert.assertTrue(atmTest.WithdrawFunds(cardTest, 50));
    }

    @Test
    public void transferTest01() {
        IAtm atmTest = new Atm();
        ICreditCard cardTest = new CreditCard();
        IAccount accountTest1 = new Account();
        IAccount accountTest2 = new Account();
        cardTest.AddAccount(accountTest1);
        Assert.assertFalse(atmTest.Transfer(cardTest, accountTest2, 50));
    }

    @Test
    public void transferTest02() {
        IAtm atmTest = new Atm();
        ICreditCard cardTest = new CreditCard();
        IAccount accountTest1 = new Account();
        IAccount accountTest2 = new Account();
        cardTest.AddAccount(accountTest1);
        cardTest.DepositFunds(100);
        Assert.assertTrue(atmTest.Transfer(cardTest, accountTest2, 50));
        Assert.assertTrue(accountTest2.AccountStatus() == 50);
        Double s1 = accountTest2.AccountStatus();
        Double s2 = 50d;
        Assert.assertTrue(s1.equals(s2));
    }
}