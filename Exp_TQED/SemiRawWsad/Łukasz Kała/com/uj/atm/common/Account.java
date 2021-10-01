package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
  private Double balance = 0.0;

  @Override
  public double AccountStatus() {
    return balance;
  }

  @Override
  public double DepositFunds(double amount) {
    balance += amount;
    return this.AccountStatus();
  }

  @Override
  public double WithdrawFunds(double amount) {
    if(amount <= balance && amount >= 0){
      balance -= amount;
    }
    return this.AccountStatus();
  }
}
