package com.uj.atm.Test;

import com.uj.atm.bankomat.Account;
import com.uj.atm.bankomat.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

  @Test
  public void testChangePin() {
    ICreditCard creditCard = new CreditCard();
    String oldPinCorrect = "1234";
    String oldPinIncorrect = "1111";
    String newPin = "4321";
    String newPinConfirmCorrect = "4321";
    String newPinConfirmIncorrect = "1111";

    Assert.assertTrue(creditCard.ChangePin(oldPinCorrect, newPin, newPinConfirmCorrect));
    Assert.assertFalse(creditCard.ChangePin(oldPinIncorrect, newPin, newPinConfirmCorrect));
    Assert.assertFalse(creditCard.ChangePin(oldPinCorrect, newPin, newPinConfirmIncorrect));
  }

  @Test
  public void testIsPinValid() {
    ICreditCard creditCard = new CreditCard();
    String pin = "1234";
    Assert.assertTrue(creditCard.IsPinValid(pin));
  }

  @Test
  public void testAddAccount() {
    IAccount account = new Account();
    ICreditCard creditCard = new CreditCard();
    creditCard.AddAccount(account);
    Assert.assertTrue(account != null);
  }

  @Test
  public void testDepositFounds() {
    ICreditCard creditCard = new CreditCard();
    IAccount account = new Account();
    Assert.assertFalse(creditCard.DepositFunds(50));
    creditCard.AddAccount(account);
    Assert.assertTrue(creditCard.DepositFunds(50));
    Assert.assertTrue(account.AccountStatus() == 50);
  }

  @Test
  public void testWithdrawFounds() {
    ICreditCard creditCard = new CreditCard();
    IAccount account = new Account();
    Assert.assertFalse(creditCard.DepositFunds(50));
    creditCard.AddAccount(account);
    creditCard.DepositFunds(50);
    Assert.assertTrue(creditCard.WithdrawFunds(50));
    Assert.assertTrue(account.AccountStatus() == 0);
  }
}
