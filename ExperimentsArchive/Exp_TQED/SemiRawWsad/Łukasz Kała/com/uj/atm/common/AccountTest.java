package com.uj.atm.common;

import static org.junit.Assert.*;

import com.uj.atm.interfaces.IAccount;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
  private IAccount account;
  private double originalAccountValue;

  @Before
  public void setUp() throws Exception {
    this.account = new Account();
    this.originalAccountValue = this.account.AccountStatus();
  }

  @Test
  public void shouldNotChangeFoundsAmountWhenWithdrawFoundsFromEmptyAccount() {

    final double withdrawReturnValue = this.account.WithdrawFunds(100);
    assertEquals("Account value has changed(Return value WithdrawFunds)",this.originalAccountValue,withdrawReturnValue,0);
    final double finalAccountValue = this.account.AccountStatus();
    assertEquals("Account value has changed(Return value AccountStatus)",this.originalAccountValue,finalAccountValue,0);
  }

  @Test
  public void accountShouldBeEmptyAfterDepositAndWithdrawTheSameAmountOfFunds() {
    final double value = 200;
    final double depositedValue = this.account.DepositFunds(value);
    assertEquals("Account value is wrong(Return value depositFunds)", value, depositedValue,0);
    final double accountValueAfterWithdraw = this.account.WithdrawFunds(value);
    assertEquals("Account value is wrong(Return value withdrawFunds)",this.originalAccountValue,accountValueAfterWithdraw,0);
    final double finalAccountValue = this.account.AccountStatus();
    assertEquals("Account value is wrong(Return value accountStatus)", this.originalAccountValue, finalAccountValue,0);
  }

  @Test
  public void accountShouldHave100FundsAfterDeposit250AndWithdraw150Funds() {
    final double valueToDeposit = 250;
    final double valueToWithdraw = 150;
    final double expectedFinalValue = 100;
    final double accountValueAfterDeposit = this.account.DepositFunds(valueToDeposit);
    assertEquals("Account value is wrong(Return value depositFunds)",valueToDeposit,accountValueAfterDeposit,0);
    final double accountValueAfterWithdraw = this.account.WithdrawFunds(valueToWithdraw);
    assertEquals("Account value is wrong(Return value withdrawFunds)",expectedFinalValue,accountValueAfterWithdraw,0);
    final double finalAccountValue = this.account.AccountStatus();
    assertEquals("Account value is wrong(Return value accountStatus)",expectedFinalValue,finalAccountValue,0);
  }
}