package com.uj.atm.common;

import org.junit.Assert;
import org.junit.Test;

public class ArmTest {

    @Test
    public void shouldLoginAtAccountReturnTrue(){
        Atm atm = new Atm();

        boolean checkPinAndLogIn = atm.CheckPinAndLogIn(new CreditCard(), "0000");

        Assert.assertTrue(checkPinAndLogIn);
    }

    @Test
    public void shouldDoNotLoginAtAccountWrongPinReturnTrue(){
        Atm atm = new Atm();

        boolean checkPinAndLogIn = atm.CheckPinAndLogIn(new CreditCard(), "1111");

        Assert.assertFalse(checkPinAndLogIn);
    }

    @Test
    public void shouldDoNotLoginAtAccountNullCreditCardReturnTrue(){
        Atm atm = new Atm();

        boolean checkPinAndLogIn = atm.CheckPinAndLogIn(null, "1111");

        Assert.assertFalse(checkPinAndLogIn);
    }

    @Test
    public void shouldShowBankBalanceReturn50(){
        Atm atm = new Atm();
        Account account = new Account();
        account.DepositFunds(50);

        double bankBalance = atm.AccountStatus(account);

        Assert.assertEquals(bankBalance, 50, 0.01);
    }

    @Test
    public void shouldShowBankBalanceReturn0(){
        Atm atm = new Atm();
        Account account = new Account();

        double bankBalance = atm.AccountStatus(account);

        Assert.assertEquals(bankBalance, 0, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAccountIsNullReturnException(){
        Atm atm = new Atm();

        atm.AccountStatus(null);
    }

    @Test
    public void shouldChangePinCardReturnTrue(){
        Atm atm = new Atm();

        boolean changePinCard = atm.ChangePinCard(new CreditCard(), "0000", "1111", "1111");

        Assert.assertTrue(changePinCard);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCardIsNullReturnException(){
        Atm atm = new Atm();

        atm.ChangePinCard(null,"0000","1111","1111");
    }

    @Test
    public void shouldAddMoney50ToAccountReturnTrueAnd50(){
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        creditCard.AddAccount(account);
        boolean depositFunds = atm.DepositFunds(creditCard, 50);

        Assert.assertTrue(depositFunds);
        Assert.assertEquals(account.AccountStatus(),50,0.01);
    }

    @Test
    public void shouldAddMoneyNegative50ToAccountReturnFalse(){
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        creditCard.AddAccount(account);

        boolean depositFunds = atm.DepositFunds(creditCard, -50);

        Assert.assertFalse(depositFunds);
        Assert.assertEquals(account.AccountStatus(), 0, 0.01);
    }

    @Test
    public void shouldWithdrawFundsFromAccountReturnTrue(){
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        account.DepositFunds(50);
        creditCard.AddAccount(account);

        boolean depositFunds = atm.WithdrawFunds(creditCard, 20);

        Assert.assertTrue(depositFunds);
        Assert.assertEquals(account.AccountStatus(), 30, 0.01);
    }

    @Test
    public void shouldDoNotWithdrawFundsFromAccountBecauseBankBalanceIs0ReturnFalse(){
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        creditCard.AddAccount(account);

        boolean depositFunds = atm.WithdrawFunds(creditCard, 20);

        Assert.assertFalse(depositFunds);
        Assert.assertEquals(account.AccountStatus(), 0, 0.01);
    }

    @Test
    public void shouldDoNotWithdrawFundsFromAccountBecauseCardNullReturnFalse(){
        Atm atm = new Atm();

        boolean depositFunds = atm.WithdrawFunds(null, 20);

        Assert.assertFalse(depositFunds);
    }

    @Test
    public void shouldSendMoneyToAnotherAccountReturnTrue(){
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        account.DepositFunds(200);
        Account accountRecipient = new Account();
        creditCard.AddAccount(account);

        boolean transfer = atm.Transfer(creditCard, accountRecipient, 50);

        Assert.assertTrue(transfer);
        Assert.assertEquals(account.AccountStatus(),150,0.001);
        Assert.assertEquals(accountRecipient.AccountStatus(), 50, 0.001);
    }

    @Test
    public void shouldNotSendMoneyToAnotherBecauseNoMoneyToAccountReturnFalse(){
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        account.DepositFunds(20);
        Account accountRecipient = new Account();
        creditCard.AddAccount(account);

        boolean transfer = atm.Transfer(creditCard, accountRecipient, 50);

        Assert.assertFalse(transfer);
        Assert.assertEquals(account.AccountStatus(),20,0.001);
        Assert.assertEquals(accountRecipient.AccountStatus(), 0, 0.001);
    }

    @Test
    public void shouldNotSendMoneyToAnotherBecauseCardNullReturnFalse(){
        Atm atm = new Atm();
        Account accountRecipient = new Account();

        boolean transfer = atm.Transfer(null, accountRecipient, 50);

        Assert.assertFalse(transfer);
        Assert.assertEquals(accountRecipient.AccountStatus(), 0, 0.001);
    }

    @Test
    public void shouldNotSendMoneyToAnotherBecauseAccountNullToAccountReturnFalse(){
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account = new Account();
        account.DepositFunds(20);
        creditCard.AddAccount(account);

        boolean transfer = atm.Transfer(creditCard, null, 50);

        Assert.assertFalse(transfer);
        Assert.assertEquals(account.AccountStatus(),20,0.001);
    }
}
