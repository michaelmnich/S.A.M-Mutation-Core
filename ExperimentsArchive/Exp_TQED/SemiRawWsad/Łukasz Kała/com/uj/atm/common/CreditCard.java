package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

  private String pin = "0000";
  private IAccount account = null;

  @Override
  public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
    if (this.pin.equals(oldPin) && newPin.equals(newPinConfirm) && newPin.length() == 4) {
      try {
        for (char el : newPin.toCharArray()) {
          Integer.parseInt(String.valueOf(el));
        }
      } catch (NumberFormatException numberFormatException) {
        return false;
      }
      this.pin = newPin;
      return true;
    }
    return false;
  }

  @Override
  public boolean IsPinValid(String pin) {

    return this.pin.equals(pin);
  }

  @Override
  public void AddAccount(IAccount account) {
    if (this.account == null) {
      this.account = account;
    }
  }

  @Override
  public boolean DepositFunds(double amount) {
    double accountBalance;

    if (amount < 0) {
      return false;
    }

    if (account != null) {
      accountBalance = account.AccountStatus();
      account.DepositFunds(amount);
      return (accountBalance < account.AccountStatus()) || (
          accountBalance == account.AccountStatus() && amount == 0);
    }

    return false;
  }

  @Override
  public boolean WithdrawFunds(double amount) {
    double accountBalance;

    if (amount < 0) {
      return false;
    }

    if (account != null) {
      accountBalance = account.AccountStatus();
      account.WithdrawFunds(amount);
      return (accountBalance > account.AccountStatus()) || (
          accountBalance == account.AccountStatus() && amount == 0);
    }

    return false;
  }
}
