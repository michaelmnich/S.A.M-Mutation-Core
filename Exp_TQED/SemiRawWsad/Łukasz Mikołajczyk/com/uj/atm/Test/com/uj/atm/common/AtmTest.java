package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogIn() {
        ICreditCard creditCard = new CreditCard("2345");
        IAtm atm = new Atm();

        Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, "1234"));
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "2345"));
    }

    @Test
    public void accountStatus() {
        IAccount account = new Account(100);
        IAtm atm = new Atm();

        Assert.assertTrue( atm.AccountStatus(account) == 100);
        Assert.assertFalse( atm.AccountStatus(account) == 1000);
    }

    @Test
    public void changePinCard() {
        ICreditCard creditCard = new CreditCard("2345");
        IAtm atm = new Atm();

        Assert.assertTrue(atm.ChangePinCard(creditCard, "2345", "2345", "2345"));
        Assert.assertTrue(atm.ChangePinCard(creditCard, "2345", "6572", "6572"));
        Assert.assertFalse(atm.ChangePinCard(creditCard, "6572", "2345", "3212"));
        Assert.assertFalse(atm.ChangePinCard(creditCard, "6572", "65725", "32125"));

        Assert.assertFalse(atm.ChangePinCard(creditCard, "6572", "657xx", "321xx") );
    }

    @Test
    public void depositFunds() {
        ICreditCard creditCard = new CreditCard("2345");
        IAtm atm = new Atm();

        Assert.assertFalse( atm.DepositFunds(creditCard, 5000) );
        Assert.assertFalse( atm.DepositFunds(creditCard, -5000) );

        IAccount account = new Account(1000);
        creditCard.AddAccount(account);

        Assert.assertFalse( atm.DepositFunds(creditCard, -5000) );
        Assert.assertTrue( atm.DepositFunds(creditCard, 500) );
    }

    @Test
    public void withdrawFunds() {
        ICreditCard creditCard = new CreditCard("2345");
        IAtm atm = new Atm();

        Assert.assertFalse( atm.DepositFunds(creditCard, 5000) );
        Assert.assertFalse( atm.DepositFunds(creditCard, -5000) );

        IAccount account = new Account(1000);
        creditCard.AddAccount(account);

        Assert.assertFalse( atm.DepositFunds(creditCard, -5000) );
        Assert.assertTrue( atm.DepositFunds(creditCard, 500) );

    }

    @Test
    public void transfer() {
        ICreditCard creditCard = new CreditCard("2345");
        IAtm atm = new Atm();
        IAccount account = new Account(1000);
        IAccount account2 = new Account(1000);

        Assert.assertFalse(atm.Transfer(creditCard, account, 2000));
        Assert.assertFalse(atm.Transfer(creditCard, account, 500));

        Assert.assertFalse(atm.Transfer(creditCard, account2, 2000));
        Assert.assertFalse(atm.Transfer(creditCard, account2, 500));

        creditCard.AddAccount(account);

        Assert.assertTrue(atm.Transfer(creditCard, account2, 500));
    }
}