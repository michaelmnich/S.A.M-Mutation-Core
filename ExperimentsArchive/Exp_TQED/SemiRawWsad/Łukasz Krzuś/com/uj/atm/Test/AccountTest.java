package com.uj.atm.Test;

import com.uj.atm.bankomat.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

  @Test
  public void testAccountStatus() {
    IAccount account = new Account();
    Assert.assertTrue(account.AccountStatus() == 0);
    account.DepositFunds(50);
    Assert.assertTrue(account.AccountStatus() == 50);
  }

  @Test
  public void testDepositFounds() {
    IAccount account = new Account();
    account.DepositFunds(50);
    account.DepositFunds(100);
    Assert.assertTrue(account.AccountStatus() == 150);
  }

  @Test
  public void testWithdrawFounds() {
    IAccount account = new Account();
    account.DepositFunds(150);
    account.WithdrawFunds(100);
    Assert.assertTrue(account.AccountStatus() == 50);
  }
}
