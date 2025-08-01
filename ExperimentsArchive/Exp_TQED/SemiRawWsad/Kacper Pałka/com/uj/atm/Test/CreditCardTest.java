package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void ChangePinTest01() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000","4321","4321"));
    }

    @Test
    public void ChangePinTest02() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.ChangePin("0000","4322","4321"));
    }

    @Test
    public void IsPinValidTest01() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid("0000"));
    }

    @Test
    public void IsPinValidTest02() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.IsPinValid("1232"));
    }

    @Test
    public void DepositFundsTest01() {
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(50));
    }

    @Test
    public void DepositFundsTest02() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.DepositFunds(50));
    }

    @Test
    public void WithdrawFundsTest02() {
        ICreditCard creditCard = new CreditCard();
        IAccount account = new Account(200);
        creditCard.AddAccount(account);
        Assert.assertFalse(creditCard.WithdrawFunds(210));
    }

    @Test
    public void WithdrawFundsTest03() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertFalse(creditCard.WithdrawFunds(50));
    }
}
