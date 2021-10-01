package com.uj.atm.bankomat;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {

  public double accountStatus;

  @Override
  public double AccountStatus() {
    return accountStatus;
  }

  @Override
  public double DepositFunds(double amount) {
    accountStatus = accountStatus + amount;
    return accountStatus;
  }

  @Override
  public double WithdrawFunds(double amount) {
    accountStatus = accountStatus - amount;
    return accountStatus;
  }
}
