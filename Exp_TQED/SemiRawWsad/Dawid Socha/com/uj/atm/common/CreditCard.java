package com.uj.atm.common;

import java.util.Scanner;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard implements ICreditCard {
    private String currentPin;
    private IAccount account;
    private int tries = 3;
    public CreditCard(String currentPin) {
        if (currentPin.length() == 4) {
            this.currentPin = currentPin;
        }
    }

    public IAccount getAccount() {
        return account;
    }

    public void setAccount(IAccount account) {
        this.account = account;
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (newPin.length() == 4) {
            while (tries-- > 0) {
                if (currentPin.equals(oldPin)) {
                    if (newPinConfirm.equals(newPin)) {
                        currentPin = newPin;
                        tries = 3;
                        return true;
                    } 
                    else {
                        return false;
                    }
                } 
                else {
                    System.out.println("Błędny kod PIN. Spróbuj ponownie");
                }
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (pin.length() == 4 && pin.equals(currentPin)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.account == null) {
            this.account = account;
        }
        else {
            System.out.println("Do karty nie można przypisać więcej niż jednego konta");
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.account != null && amount >0) {
            this.account.DepositFunds(amount);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.account != null && this.account.AccountStatus() >= amount) {
            this.account.WithdrawFunds(amount);
            return true;
        }
        else {
            System.out.println("Nie można wypłacić środków");
            return false;
        }
    }
}