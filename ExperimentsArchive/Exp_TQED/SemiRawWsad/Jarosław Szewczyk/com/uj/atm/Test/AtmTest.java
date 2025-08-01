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
    public void TestCheckPinAndLogIn_CorrectDefaultPin() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        boolean result = atm.CheckPinAndLogIn(creditCard, "0000");

        Assert.assertTrue(result);
    }

    @Test
    public void TestCheckPinAndLogIn_IncorrectPin() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        boolean result = atm.CheckPinAndLogIn(creditCard, "1000");

        Assert.assertFalse(result);
    }

    @Test
    public void TestCheckPinAndLogIn_EmptyStringAsPin() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        boolean result = atm.CheckPinAndLogIn(creditCard, "");

        Assert.assertFalse(result);
    }



    @Test
    public void TestAccountStatus() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        Assert.assertEquals(atm.AccountStatus(account), account.AccountStatus(), 0.0);
        double accountBalanceAfterDeposit = account.DepositFunds(100);
        Assert.assertTrue(atm.AccountStatus(account) == account.AccountStatus() && accountBalanceAfterDeposit >= 100);


    }

    @Test
    public void TestChangePinCard_CorrectData() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();
        boolean checkDefaultPin = atm.CheckPinAndLogIn(creditCard, "0000");

        Assert.assertTrue("Default pin incorrect", checkDefaultPin);
        boolean resultOfChangePin = atm.ChangePinCard(creditCard, "0000", "1111", "1111");

        Assert.assertTrue(resultOfChangePin);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "1111"));
    }

    @Test
    public void TestChangePinCard_IncorrectOldPin() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();
        boolean checkDefaultPin = atm.CheckPinAndLogIn(creditCard, "0000");

        Assert.assertTrue("Default pin incorrect", checkDefaultPin);
        boolean resultOfChangePin = atm.ChangePinCard(creditCard, "1000", "1111", "1111");

        Assert.assertFalse(resultOfChangePin);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000"));
    }

    @Test
    public void TestChangePinCard_IncorrectNewPin() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();
        boolean checkDefaultPin = atm.CheckPinAndLogIn(creditCard, "0000");

        Assert.assertTrue("Default pin incorrect", checkDefaultPin);
        boolean resultOfChangePin = atm.ChangePinCard(creditCard, "0000", "00111", "1111");

        Assert.assertFalse(resultOfChangePin);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000"));
    }

    @Test
    public void TestChangePinCard_IncorrectConfirmPin() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();
        boolean checkDefaultPin = atm.CheckPinAndLogIn(creditCard, "0000");

        Assert.assertTrue("Default pin incorrect", checkDefaultPin);
        boolean resultOfChangePin = atm.ChangePinCard(creditCard, "0000", "1111", "11111e");

        Assert.assertFalse(resultOfChangePin);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000"));
    }

    @Test
    public void TestDepositFunds_CorrectData() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        double depositAmount = 99.9;

        double oldAccountBalance = account.AccountStatus();
        Assert.assertTrue(atm.DepositFunds(creditCard, depositAmount));
        Assert.assertEquals((account.AccountStatus() - depositAmount), oldAccountBalance, 0.0);
    }

    @Test
    public void TestDepositFunds_NegativeDeposit() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        double depositAmount = -99.9;

        double oldAccountBalance = account.AccountStatus();
        Assert.assertFalse(atm.DepositFunds(creditCard, depositAmount));
        Assert.assertEquals(account.AccountStatus(), oldAccountBalance, 0.0);
    }

    @Test
    public void TestWithdrawFunds_CorrectData() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        double withdrawAmount = 99.9;
        Assert.assertTrue(atm.DepositFunds(creditCard, withdrawAmount));
        double oldAccountBalance = account.AccountStatus();

        Assert.assertTrue(atm.WithdrawFunds(creditCard, withdrawAmount));
        Assert.assertEquals((account.AccountStatus() + withdrawAmount), oldAccountBalance, 0.0);
    }

    @Test
    public void TestWithdrawFunds_OverAvailableBalance() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAtm atm = new Atm();

        double oldAccountBalance = account.AccountStatus();
        double withdrawAmount = oldAccountBalance + 99.9;


        Assert.assertFalse(atm.WithdrawFunds(creditCard, withdrawAmount));
        Assert.assertEquals(account.AccountStatus(), oldAccountBalance, 0.0);
    }

    @Test
    public void TestTransfer_CorrectData() {
        IAccount accountCard = new Account();
        IAccount accountRecipient = new Account();
        ICreditCard creditCard = new CreditCard();

        double amount = 50;
        accountCard.DepositFunds(amount);
        creditCard.AddAccount(accountCard);

        double cardAccountBalanceBeforeTransfer = accountCard.AccountStatus();
        double accountRecipientBalanceBeforeTransfer = accountRecipient.AccountStatus();
        IAtm atm = new Atm();
        boolean result = atm.Transfer(creditCard, accountRecipient, amount);

        Assert.assertTrue(result);
        Assert.assertEquals((cardAccountBalanceBeforeTransfer - amount), accountCard.AccountStatus(), 0.0);
        Assert.assertEquals((accountRecipientBalanceBeforeTransfer + amount), accountRecipient.AccountStatus(), 0.0);

    }

    @Test
    public void TestTransfer_ZeroAmount() {
        IAccount accountCard = new Account();
        IAccount accountRecipient = new Account();
        ICreditCard creditCard = new CreditCard();

        double amount = 50;
        accountCard.DepositFunds(amount);
        creditCard.AddAccount(accountCard);

        IAtm atm = new Atm();
        boolean result = atm.Transfer(creditCard, accountRecipient, 0.0);

        Assert.assertFalse(result);
    }

    @Test
    public void TestTransfer_NegativeAmount() {
        IAccount accountCard = new Account();
        IAccount accountRecipient = new Account();
        ICreditCard creditCard = new CreditCard();

        double amount = 50;
        accountCard.DepositFunds(amount);
        creditCard.AddAccount(accountCard);

        IAtm atm = new Atm();
        boolean result = atm.Transfer(creditCard, accountRecipient, -amount);

        Assert.assertFalse(result);
    }

    @Test
    public void TestTransfer_AmountAboveAvailableBalance() {
        IAccount accountCard = new Account();
        IAccount accountRecipient = new Account();
        ICreditCard creditCard = new CreditCard();

        double amount = 50;
        accountCard.DepositFunds(amount);
        creditCard.AddAccount(accountCard);

        IAtm atm = new Atm();
        boolean result = atm.Transfer(creditCard, accountRecipient, amount * 2);

        Assert.assertFalse(result);
    }

}
