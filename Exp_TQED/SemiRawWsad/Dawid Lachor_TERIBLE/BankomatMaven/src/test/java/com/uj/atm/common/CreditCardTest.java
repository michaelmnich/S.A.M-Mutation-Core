package com.uj.atm.common;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void shouldChangePin4444ReturnTrue(){
        CreditCard creditCard = new CreditCard();

        boolean changePin = creditCard.ChangePin("0000", "4444", "4444");

        Assert.assertTrue(changePin);
    }

    @Test
    public void shouldCheckLengthNewReturnFalse(){
        CreditCard creditCard = new CreditCard();

        boolean changePin = creditCard.ChangePin("0000", "44444", "44444");

        Assert.assertFalse(changePin);
    }

    @Test
    public void shouldCheckConfirmPinReturnFalse(){
        CreditCard creditCard = new CreditCard();

        boolean changePin = creditCard.ChangePin("0000", "4444", "5555");

        Assert.assertFalse(changePin);
    }

    @Test
    public void shouldCheckPinIsNumberReturnFalse(){
        CreditCard creditCard = new CreditCard();

        boolean changePin = creditCard.ChangePin("0000", "Alas", "Alas");

        Assert.assertFalse(changePin);
    }

    @Test
    public void shouldCheckPinIsCorrectReturnTrue(){
        CreditCard creditCard = new CreditCard();

        boolean changePin = creditCard.IsPinValid("0000");

        Assert.assertTrue(changePin);
    }

    @Test
    public void shouldCheckPinIsNotCorrectReturnFalse(){
        CreditCard creditCard = new CreditCard();

        boolean changePin = creditCard.IsPinValid("1111");

        Assert.assertFalse(changePin);
    }

    @Test
    public void shouldAddAccountToCardReturnVoid(){
        CreditCard creditCard = new CreditCard();

        creditCard.AddAccount(new Account());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddNullAccountToCardReturnException(){
        CreditCard creditCard = new CreditCard();

        creditCard.AddAccount(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddNewAccountToCardWhoHasAccountReturnException(){
        CreditCard creditCard = new CreditCard();
        creditCard.AddAccount(new Account());

        creditCard.AddAccount(new Account());
    }

    @Test
    public void shouldAddMoney50ToBankAccountReturnTrue(){
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        creditCard.AddAccount(account);

        boolean depositFunds = creditCard.DepositFunds(50);

        Assert.assertTrue(depositFunds);
        Assert.assertEquals(account.AccountStatus(),50, 0.1);
    }

    @Test
    public void shouldAddMoney50_10ToBankAccountReturnTrue(){
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        creditCard.AddAccount(account);

        boolean depositFunds = creditCard.DepositFunds(50.1);

        Assert.assertTrue(depositFunds);
        Assert.assertEquals(account.AccountStatus(),50.1, 0.001);
    }

    @Test
    public void shouldDoNotAddMoneyWhenAmount0ReturnFalse(){
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        creditCard.AddAccount(account);

        boolean depositFunds = creditCard.DepositFunds(0);

        Assert.assertFalse(depositFunds);
    }

    @Test
    public void shouldDoNotWithdrawRealizeWhenAmountIsMoreThenBankBalanceReturnFalse(){
        CreditCard creditCard = new CreditCard();
        creditCard.AddAccount(new Account());

        boolean depositFunds = creditCard.WithdrawFunds(5);

        Assert.assertFalse(depositFunds);
    }

    @Test
    public void shouldDoNotWithdrawRealizeWhenAmountIsLessThen0ReturnFalse(){
        CreditCard creditCard = new CreditCard();
        creditCard.AddAccount(new Account());

        boolean depositFunds = creditCard.WithdrawFunds(-5);

        Assert.assertFalse(depositFunds);
    }
}
