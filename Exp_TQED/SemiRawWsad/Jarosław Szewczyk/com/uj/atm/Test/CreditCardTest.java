package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void TestChangePin_DefaultPinToNewPin() {
        ICreditCard creditCard = new CreditCard();
        boolean result = creditCard.ChangePin("0000", "2222", "2222");
        Assert.assertTrue(result);
    }

    @Test
    public void TestChangePin_InvalidOldPin() {
        ICreditCard creditCard = new CreditCard();
        boolean result = creditCard.ChangePin("aaaa", "2222", "2222");
        Assert.assertFalse(result);
    }

    @Test
    public void TestChangePin_InvalidNewPin() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.ChangePin("0000", "a", "2222");
        Assert.assertFalse(result);
    }

    @Test
    public void TestChangePin_InvalidNewPinConfirm() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.ChangePin("0000", "2222", "aa34");
        Assert.assertFalse(result);
    }

    @Test
    public void TestChangePin_InvalidLengthNewPin() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.ChangePin("0000", "222222", "2222");
        Assert.assertFalse(result);
    }

    @Test
    public void TestChangePin_InvalidLengthNewPinConfirm() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.ChangePin("0000", "2222", "222222");
        Assert.assertFalse(result);
    }

    @Test
    public void TestChangePin_OldPinSameAsNewPin() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.ChangePin("0000", "0000", "0000");
        Assert.assertFalse(result);
    }

    @Test
    public void TestValidatePin_DefaultPin() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.IsPinValid("0000");
        Assert.assertTrue(result);
    }

    @Test
    public void TestValidatePin_IncorrectPin() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.IsPinValid("0010");
        Assert.assertFalse(result);
    }

    @Test
    public void TestValidatePin_IncorrectPinLength() {
        ICreditCard creditCard = new CreditCard();

        boolean result = creditCard.IsPinValid("00100");
        Assert.assertFalse(result);

        result = creditCard.IsPinValid("001");
        Assert.assertFalse(result);
    }

    @Test
    public void TestDepositNegativeValue() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        double amount = -1;
        boolean result = creditCard.DepositFunds(amount);
        Assert.assertFalse("Deposit negative amount should be blocked", result);
    }

    @Test
    public void TestDepositPositiveValue() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        double amount = 1.0;
        boolean result = creditCard.DepositFunds(amount);
        Assert.assertTrue(result);
    }

    @Test
    public void TestDepositOverMaxTypeValue() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);

        boolean result = creditCard.DepositFunds(Double.MAX_VALUE);
        boolean resultOfOverflow = creditCard.DepositFunds(10.0); // This should invoke overflow on the Double type, in result deposit funds is not possible

        Assert.assertTrue("The account balance has exceeded the maximum value of the type",
                (result && !resultOfOverflow));
    }

    @Test
    public void TestWithdrawFunds() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);

        double withdrawAmount = 100;
        creditCard.DepositFunds(withdrawAmount);
        double accountStatusBeforeWithdraw = account.AccountStatus();

        Assert.assertTrue("Cannot validate withdraw method without set account balance", accountStatusBeforeWithdraw >= withdrawAmount);

        boolean result = creditCard.WithdrawFunds(withdrawAmount);
        Assert.assertTrue(result);
        Assert.assertEquals((accountStatusBeforeWithdraw - withdrawAmount), account.AccountStatus(), 0.0);
    }

    @Test
    public void TestWithdrawFundsOverAccountBalance() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);

        double accountStatusBeforeWithdraw = account.AccountStatus();
        double withdrawAmount = accountStatusBeforeWithdraw + 1.0;

        boolean result = creditCard.WithdrawFunds(withdrawAmount);
        Assert.assertFalse(result);
        Assert.assertEquals(accountStatusBeforeWithdraw, account.AccountStatus(), 0.0);
    }

    @Test
    public void TestWithdrawNegativeAmount() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);

        double accountStatusBeforeWithdraw = account.AccountStatus();
        double amount = -10.0;
        boolean result = creditCard.WithdrawFunds(amount);

        Assert.assertFalse(result);
        Assert.assertEquals(accountStatusBeforeWithdraw, account.AccountStatus(), 0.0);
    }


}
