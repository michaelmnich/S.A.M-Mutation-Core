package com.uj.atm.bankomat;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

  public IAccount creditCardAccount;
  public String currentPin = "1234";

  @Override
  public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
    if (currentPin.equals(oldPin) && newPin.equals(newPinConfirm)) {
      currentPin = newPin;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean IsPinValid(String pin) {
    return currentPin.equals(pin);
  }

  @Override
  public void AddAccount(IAccount account) {
    creditCardAccount = account;
  }

  @Override
  public boolean DepositFunds(double amount) {
    if (creditCardAccount == null) {
      return false;
    } else {
      creditCardAccount.DepositFunds(amount);
      return true;
    }
  }

  @Override
  public boolean WithdrawFunds(double amount) {
    if (creditCardAccount == null) {
      return false;
    } else {
      creditCardAccount.WithdrawFunds(amount);
      return true;
    }
  }
}
