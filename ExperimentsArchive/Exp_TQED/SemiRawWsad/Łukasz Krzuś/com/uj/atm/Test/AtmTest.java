package com.uj.atm.Test;

import com.uj.atm.bankomat.Account;
import com.uj.atm.bankomat.Atm;
import com.uj.atm.bankomat.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

  @Test
  public void testCheckPinAndLogIn() {
    IAtm atm = new Atm();
    ICreditCard creditCard = new CreditCard();
    String pin = "1234";
    String pinWrongLength = "12";
    String pinNotANumber = "abcd";
    String pinWrong = "4321";
    Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, pin));
    Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, pinWrongLength));
    Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, pinNotANumber));
    Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, pinWrong));
  }

  @Test
  public void testAccountStatus() {
    IAccount account = new Account();
    account.DepositFunds(50);
    Assert.assertTrue(account.AccountStatus() == 50);
  }

  @Test
  public void testChangePinCard() {
    IAtm atm = new Atm();
    ICreditCard creditCard = new CreditCard();
    String oldPinCorrect = "1234";
    String oldPinIncorrect = "1111";
    String newPin = "4321";
    String newPinConfirmCorrect = "4321";
    String newPinConfirmIncorrect = "1111";

    Assert.assertTrue(atm.ChangePinCard(creditCard, oldPinCorrect, newPin, newPinConfirmCorrect));
    Assert.assertFalse(
        atm.ChangePinCard(creditCard, oldPinCorrect, newPin, newPinConfirmIncorrect));
    Assert.assertFalse(
        atm.ChangePinCard(creditCard, oldPinIncorrect, newPin, newPinConfirmCorrect));
  }

  @Test
  public void testDepositFunds() {
    IAtm atm = new Atm();
    ICreditCard creditCard = new CreditCard();
    String pin = "1234";
    Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, pin));
  }

  @Test
  public void testWithdrawFunds() {
    IAtm atm = new Atm();
    ICreditCard creditCard = new CreditCard();
    IAccount account = new Account();
    Assert.assertFalse(creditCard.DepositFunds(50));
    creditCard.AddAccount(account);
    Assert.assertTrue(atm.DepositFunds(creditCard, 50));
    Assert.assertTrue(account.AccountStatus() == 50);
  }

  @Test
  public void testTransfer() {
    IAtm atm = new Atm();
    ICreditCard creditCard = new CreditCard();
    IAccount account = new Account();
    Assert.assertFalse(creditCard.DepositFunds(50));
    creditCard.AddAccount(account);
    creditCard.DepositFunds(50);
    Assert.assertTrue(atm.WithdrawFunds(creditCard, 50));
    Assert.assertTrue(account.AccountStatus() == 0);
  }
}
