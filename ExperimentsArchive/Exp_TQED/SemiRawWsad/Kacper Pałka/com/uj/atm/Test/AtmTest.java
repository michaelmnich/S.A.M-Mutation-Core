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
    public void CheckPinAndLogInTest01() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000"));
    }

    @Test
    public void CheckPinAndLogInTest02() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, "1235"));
    }

    @Test
    public void AccountStatusTest01() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        Assert.assertTrue(atm.AccountStatus(account)==0);
        double l1 = atm.AccountStatus(account);
        double l2 = 0;
        double epsilon = 0.000001d;
        Assert.assertEquals(l1, l2, epsilon);
    }

    @Test
    public void ChangePinCardTest01() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "4321", "4321"));
    }

    @Test
    public void ChangePinCardTest02() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(atm.ChangePinCard(creditCard, "0000", "4321", "4322"));
    }

    @Test
    public void DepositFundsTest01() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 50));
    }

    @Test
    public void DepositFundsTest02() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(atm.DepositFunds(creditCard, 50));
    }

    @Test
    public void WithdrawFundsTest01() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account(200);
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 50));
    }

    @Test
    public void WithdrawFundsTest02() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account(200);
        creditCard.AddAccount(account);
        Assert.assertFalse(atm.WithdrawFunds(creditCard, 210));
    }

    @Test
    public void WithdrawFundsTest03() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(atm.WithdrawFunds(creditCard, 50));
    }

    @Test
    public void TransferTest01() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account(200);
        creditCard.AddAccount(account);
        IAccount accountRecipient = new Account(200);
        Assert.assertTrue(atm.Transfer(creditCard, accountRecipient, 50));
    }

    @Test
    public void TransferTest02() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account(200);
        creditCard.AddAccount(account);
        IAccount accountRecipient = new Account(200);
        Assert.assertFalse(atm.Transfer(creditCard, accountRecipient, 210));
    }

    @Test
    public void TransferTest03() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        IAccount accountRecipient = new Account(200);
        Assert.assertFalse(atm.Transfer(creditCard, accountRecipient, 50));
    }
}
