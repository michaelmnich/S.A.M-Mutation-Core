package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    ICreditCard creditCard;

    @Before
    public void Initialize() {
        creditCard = new CreditCard();
    }

    @Test
    public void PinInvalidForValidInputButWrongPin() {
        Assert.assertFalse(creditCard.IsPinValid("1234"));
    }

    @Test
    public void PinInValidForValidInputAndCorrectPin() {
        Assert.assertTrue(creditCard.IsPinValid("0000"));
    }

    @Test
    public void PinInvalidForInputWithPlus() {

        Assert.assertFalse(creditCard.IsPinValid("+123"));
    }

    @Test
    public void PinInvalidForInputWithMinus() {

        Assert.assertFalse(creditCard.IsPinValid("-123"));
    }

    @Test
    public void PinInvalidForNullInput() {

        Assert.assertFalse(creditCard.IsPinValid(null));
    }

    @Test
    public void PinInvalidForDecimalNumberInput() {

        Assert.assertFalse(creditCard.IsPinValid("1.00"));
    }

    @Test
    public void PinInvalidForNotNumericInput() {

        Assert.assertFalse(creditCard.IsPinValid("asdd"));
    }

    @Test
    public void PinInvalidForTooLongInput() {

        Assert.assertFalse(creditCard.IsPinValid("12345"));
    }

    @Test
    public void PinInvalidForTooShortInput() {

        Assert.assertFalse(creditCard.IsPinValid("123"));
    }

    @Test
    public void PinInvalidForEmoji() {
        Assert.assertFalse(creditCard.IsPinValid("\uD83D\uDE00123"));
    }

    @Test
    public void PinChangeReturnsTrueAndWorksForValidInput() {
        Assert.assertTrue(creditCard.ChangePin("0000", "1234", "1234"));
        Assert.assertTrue(creditCard.ChangePin("1234", "9999", "9999"));
    }

    @Test
    public void PinChangeReturnsFalseWrongOldPin() {
        Assert.assertFalse(creditCard.ChangePin("1111", "1234", "1234"));
    }

    @Test
    public void PinChangeReturnFalseForWrongConfirm() {
        Assert.assertFalse(creditCard.ChangePin("0000", "1234", "1235"));
    }

    @Test
    public void PinChangeReturnFalseAndDoesNotWorkForInvalidInput() {
        Assert.assertFalse(creditCard.ChangePin("1111", "1234", "1234"));
        Assert.assertFalse(creditCard.ChangePin("1234", "9999", "9999"));
    }

    @Test
    public void PinChangeReturnsFalseEverythingWrong() {
        Assert.assertFalse(creditCard.ChangePin("0001", "9999", "9998"));
    }

    @Test
    public void DepositReturnsFalseForNoAccount() {
        Assert.assertFalse(creditCard.DepositFunds(100));
    }

    @Test
    public void WithdrawReturnsFalseForNoAccount() {
        Assert.assertFalse(creditCard.WithdrawFunds(100));
    }

    @Test
    public void WithdrawReturnsFalseForWrongInput() {
        IAccount account = new Account();
        account.DepositFunds(100);
        creditCard.AddAccount(account);
        Assert.assertFalse(creditCard.WithdrawFunds(-100));
        Assert.assertFalse(creditCard.WithdrawFunds(0));
        Assert.assertFalse(creditCard.WithdrawFunds(Double.NaN));
        Assert.assertFalse(creditCard.WithdrawFunds(Double.NEGATIVE_INFINITY));
        Assert.assertFalse(creditCard.WithdrawFunds(Double.POSITIVE_INFINITY));
    }

    @Test
    public void DepositReturnsFalseForWrongInput() {
        IAccount account = new Account();
        account.DepositFunds(100);
        creditCard.AddAccount(account);
        Assert.assertFalse(creditCard.WithdrawFunds(-100));
        Assert.assertFalse(creditCard.WithdrawFunds(0));
        Assert.assertFalse(creditCard.WithdrawFunds(Double.NaN));
        Assert.assertFalse(creditCard.WithdrawFunds(Double.NEGATIVE_INFINITY));
        Assert.assertFalse(creditCard.WithdrawFunds(Double.POSITIVE_INFINITY));
    }

    @Test
    public void WithdrawReturnsFalseForAmountGreaterThanBalance() {
        IAccount account = new Account();
        account.DepositFunds(100);
        creditCard.AddAccount(account);
        Assert.assertFalse(creditCard.WithdrawFunds(101));
    }

    @Test
    public void WithdrawReturnsTrueAndWithdraws () {
        IAccount account = new Account();
        account.DepositFunds(100);
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.WithdrawFunds(100));
        Assert.assertEquals(account.AccountStatus(), 0, 0);
    }

    @Test
    public void DepositReturnsTrueAndDeposits () {
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(100));
        Assert.assertEquals(account.AccountStatus(), 100, 0);
    }

    @Test
    public void DepositOfNumberLargerThanMaxDouble () {
        IAccount account = new Account();
        account.DepositFunds(100);
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(Double.MAX_VALUE));
        Assert.assertTrue(account.AccountStatus() > Double.MAX_VALUE);
    }

    @Test
    public void DepositOfNumberSmallerThanMinDouble () {
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue( creditCard.DepositFunds(Double.MIN_VALUE / 10));
        Assert.assertTrue( account.AccountStatus() > 0);
    }

    @Test
    public void  WithdrawOfNumberLargerThanMaxDouble () {
        IAccount account = new Account();
        creditCard.AddAccount(account);
        account.DepositFunds(Double.MAX_VALUE + 100);
        Assert.assertTrue(creditCard.WithdrawFunds(Double.MAX_VALUE + 10));
        Assert.assertEquals( 90, account.AccountStatus(), 0);

    }

    @Test
    public void WithdrawOfNumberSmallerThanMinDouble () {
        IAccount account = new Account();
        creditCard.AddAccount(account);
        account.DepositFunds(10);
        Assert.assertTrue( creditCard.WithdrawFunds(Double.MIN_VALUE / 10));
        Assert.assertTrue( account.AccountStatus() < 10);
    }

    @Test
    public void ChangingAccountDoesNotWork() {
        IAccount account = new Account();
        account.DepositFunds(100);
        IAccount secondAcount = new Account();
        secondAcount.DepositFunds(1000);
        creditCard.AddAccount(account);
        creditCard.AddAccount(secondAcount);
        creditCard.DepositFunds(100);
        Assert.assertEquals(account.AccountStatus(), 200, 0);
    }
}