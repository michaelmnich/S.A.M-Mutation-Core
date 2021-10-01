package com.uj.atm.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

  ICreditCard creditCard;
  String originalPin;

  @Before
  public void setUp() throws Exception {
    this.creditCard = new CreditCard();
    this.originalPin = "0000";
  }

  @Test
  public void changePinShouldReturnTrueWhenUsingCorrectValue() {
    String pin1 = "0001";
    String pin2 = "7901";
    String pin3 = "3041";
    String pin4 = "1111";
    assertTrue("Change pin to (correct): " + pin1,
        this.creditCard.ChangePin(this.originalPin, pin1, pin1));
    assertTrue("Change pin to (correct): " + pin2, this.creditCard.ChangePin(pin1, pin2, pin2));
    assertTrue("Change pin to (correct): " + pin3, this.creditCard.ChangePin(pin2, pin3, pin3));
    assertTrue("Change pin to (correct): " + pin4, this.creditCard.ChangePin(pin3, pin4, pin4));
  }

  @Test
  public void changePinShouldReturnFalseWhenUsingIncorrectPin() {
    String[] array = {"FDG3", "XXXXX", "12345", "12e4", "123", "12", "1", " ", "1234 ", " 1234",
        "1 234", "123F", "F123", "L463"};
    for (String el : array) {
      assertFalse("Change pin to (wrong): " + el,
          this.creditCard.ChangePin(this.originalPin, el, el));

    }
  }

  @Test
  public void changePinShouldReturnFalseWhenNewPinAndNewPinConfirmAreNotEqual() {
    String newPin = "1111";
    String newPinConfirm = "2222";
    assertFalse("ChangePin with differ newPin and newPinConfirm",
        this.creditCard.ChangePin(this.originalPin, newPin, newPinConfirm));
  }

  @Test
  public void isPinValidShouldReturnTrueIfPinIsValid() {
    assertTrue("isPinValid should return true if pin is valid",
        this.creditCard.IsPinValid(this.originalPin));
  }

  @Test
  public void isPinValidShouldReturnFalseIfPinIsInvalid() {
    String[] invalidPins = {"", " ", "  ", "    ", "1234", "4444", "1 3 ", "1",
        "4235211234213153122351235123513451114"};
    for (String el : invalidPins) {
      assertFalse("isPinValid should return false if pin is invalid",
          this.creditCard.IsPinValid(el));
    }
  }

  @Test
  public void depositFundsShouldReturnFalseWithoutAccount() {
    assertFalse("depositFounds added funds without account", this.creditCard.DepositFunds(1));
  }

  @Test
  public void depositFundsShouldReturnTrueWithAccount() {
    this.creditCard.AddAccount(new Account());
    assertTrue("depositFunds not added with account assigned", this.creditCard.DepositFunds(1));
  }

  @Test
  public void withdrawFundsShouldReturnFalseWithoutAccount() {
    assertFalse("withdrawFunds should return false without account",
        this.creditCard.WithdrawFunds(0));
  }

  @Test
  public void withdrawFundsShouldReturnTrueWithAccountAndFunds() {
    this.creditCard.AddAccount(new Account());
    this.creditCard.DepositFunds(100);
    assertTrue("withdrawFunds should return true with account and funds on",
        this.creditCard.WithdrawFunds(100));
  }

  @Test
  public void ShouldNotChangeAmountOfFoundsAfterTryingToAddNewAccountToCard() {
    IAccount account1 = new Account();
    assertEquals("Account funds has not changed", 1, account1.DepositFunds(1), 0);
    IAccount account2 = new Account();
    assertEquals("Account funds has not changed", 2, account2.DepositFunds(2), 0);
    this.creditCard.AddAccount(account1);
    assertTrue("Credit card funds are not accessible after adding account",
        this.creditCard.WithdrawFunds(1));
    assertFalse("Credit card have founds after changing account", this.creditCard.WithdrawFunds(2));


  }
}