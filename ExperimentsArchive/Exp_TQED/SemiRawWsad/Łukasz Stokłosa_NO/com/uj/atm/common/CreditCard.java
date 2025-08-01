package com.uj.atm.common;

import java.util.Scanner;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard implements ICreditCard {
    private int n=3;

    private String currentPin;

    public CreditCard(String currentPin) {
        if (currentPin.matches("[0-9]+") && currentPin.length() == 4) {
            this.currentPin=currentPin;

        }
    }


    public IAccount getAccount() {
        return account;
    }


    public void setAccount(IAccount account) {
        this.account = account;
    }

    private IAccount account;


    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {

        if (newPin.matches("[0-9]+") && newPin.length() == 4) {

            //int n = 3;
            while (n-- > 0) {
                if (currentPin.equals(oldPin)) {
                    if (newPinConfirm.equals(newPin)) {
                        currentPin = newPin;

                        n=3;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    System.out.println("Nie poprawny PIN. Proszę spróbować ponownie");
                }

            }

            //3 nie udane próby

        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        if (pin.matches("[0-9]+") && pin.length() == 4 && pin.equals(currentPin)) {

                return true;

        }else


            return false;
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.account == null) {
            this.account = account;
        } else System.out.println("Juz jest przypsiane konto");


    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.account != null && amount >0) {
            this.account.DepositFunds(amount);
            return true;

        } else
            return false;


    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.account != null && this.account.AccountStatus() >= amount) {
            this.account.WithdrawFunds(amount);
            return true;

        } else {
            System.out.println("Nie można przelać środków na konto");
            return false;
        }

    }
}
