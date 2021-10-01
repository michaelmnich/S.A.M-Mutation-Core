package com.uj.atm.common;

import static org.junit.Assert.*;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Before;
import org.junit.Test;

public class AtmTest {
IAtm atm;
  @Before
  public void setUp() throws Exception {
    atm = new Atm();
  }

  @Test
  public void CheckPinAndLogInShouldReturnFalseWhenPinIsWrong() {
    String wrongPin = "1112";
    assertFalse("True with wrong pin",this.atm.CheckPinAndLogIn(new CreditCard(),wrongPin));
  }

  @Test
  public void CheckPinAndLogInShouldReturnTrueWhenPinIsValid() {
    String validPin = "0000";
    assertTrue("False with valid pin",this.atm.CheckPinAndLogIn(new CreditCard(),validPin));
  }

  @Test
  public void ShouldNotAllowChangePinUsingWrongOldPin() {
    ICreditCard creditCard = new CreditCard();
    String wrongPing = "1234";
    String newPin = "1111";
    assertFalse("True with wrong pin", this.atm.ChangePinCard(creditCard, wrongPing, newPin,newPin));
    assertFalse("Pin changed", this.atm.CheckPinAndLogIn(creditCard, wrongPing));
  }

  @Test
  public void shouldAllowChangePinUsingValidOldPin() {
    ICreditCard creditCard = new CreditCard();
    String validPin = "0000";
    String newPin = "1987";
    assertTrue("False with valid pin", this.atm.ChangePinCard(creditCard, validPin, newPin, newPin));
    assertTrue("Pin has not changed or just wrong", this.atm.CheckPinAndLogIn(creditCard,newPin));
  }

  @Test
  public void shouldReturn100FundsAfterDeposit800AndWithdraw700Funds() {
    ICreditCard creditCard = new CreditCard();
    IAccount account = new Account();
    creditCard.AddAccount(account);
    assertTrue("False after deposit", this.atm.DepositFunds(creditCard, 800));
    assertEquals("Account balance is not 800 after deposit", 800, this.atm.AccountStatus(account),0);
    assertTrue("False after withdraw 700 funds", this.atm.WithdrawFunds(creditCard,700));
    assertEquals("Account balance is not 100 after withdraw 700 from 800",100, account.AccountStatus(),0);
  }

  @Test
  public void shouldBeOnRecipientAccount100FundsAndOnPayerAccount50FundsAfterTransfer100FundsToRecipientAccount() {
    IAccount payerAccount = new Account();
    ICreditCard payerCreditCard = new CreditCard();
    assertEquals("Funds has not been added to account",100,payerAccount.DepositFunds(100),0);
    payerCreditCard.AddAccount(payerAccount);
    IAccount recipientAccount = new Account();
    assertTrue("Funds has not been transferred",this.atm.Transfer(payerCreditCard,recipientAccount,100));
  }

  @Test
  public void shouldNotAllowToTransferFundsWhenThereAreNotEnoughFundsOnRecipientAccount() {
    IAccount payerAccount = new Account();
    ICreditCard payerCreditCard = new CreditCard();
    assertEquals("Funds has not been added to account",100,payerAccount.DepositFunds(100),0);
    payerCreditCard.AddAccount(payerAccount);
    IAccount recipientAccount = new Account();
    assertFalse("Funds has been transferred",this.atm.Transfer(payerCreditCard,recipientAccount,1200));
  }
}