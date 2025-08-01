package com.uj.atm;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

    }

    public static class Account implements IAccount {
        double accountBalance = 0.0;
        String PIN = "0000";

        @Override
        public double AccountStatus() {
            return accountBalance;
        }

        @Override
        public double DepositFunds(double amount) {
            if(amount > 0) {
                accountBalance += amount;
            }
            return accountBalance;
        }

        @Override
        public double WithdrawFunds(double amount) {
            if(amount > 0) {
                if (accountBalance < amount)
                    return accountBalance;
                else
                    accountBalance -= amount;
                    return accountBalance;
            }
            else
                return accountBalance;
        }
    }
    public static class CreditCard implements ICreditCard {
        String PIN;
        Account AccountLinked;

        CreditCard(String accountPin){
            this.PIN = accountPin;
        }

        @Override
        public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
            if(oldPin.equals(this.PIN))
                if (newPin.equals(newPinConfirm)){
                    this.PIN = newPin;
                    return true;
                }
                else
                    return false;
            else
                return false;
        }

        @Override
        public boolean IsPinValid(String pin) {
            if(this.PIN.equals(pin))
                return true;
            else
                return false;
        }

        @Override
        public void AddAccount(IAccount account) {
            if(this.AccountLinked == null){
                this.AccountLinked = (Account) account;
            }
        }

        @Override
        public boolean DepositFunds(double amount) {
            if(this.AccountLinked == null){
                return false;
            }
            else{
                this.AccountLinked.accountBalance += amount;
                return true;
            }

        }

        @Override
        public boolean WithdrawFunds(double amount) {
            if(this.AccountLinked.accountBalance < amount){
                return false;
            }
            else{
                this.AccountLinked.accountBalance -= amount;
                return true;
            }
        }
    }
    public static class Atm implements IAtm{

        @Override
        public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
            if(creditCard.IsPinValid(pin) && pin.length() == 4){
                return true;
            }
            else{
                return false;
            }

        }

        @Override
        public double AccountStatus(IAccount account) {
            return account.AccountStatus();
        }

        @Override
        public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
            if(card.IsPinValid(oldPin)) {
                card.ChangePin(oldPin, newPin, newPinConfirm);
                return true;
            }
            else
                return false;
        }

        @Override
        public boolean DepositFunds(ICreditCard card, double amount) {
            if(card.DepositFunds(amount))
                return true;
            else
                return false;
        }

        @Override
        public boolean WithdrawFunds(ICreditCard card, double amount) {
            if(card.WithdrawFunds(amount))
                return true;
            else
                return false;
        }

        @Override
        public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
            if(card.WithdrawFunds(amount)){
                accountRecipient.DepositFunds(amount);
                return true;
            }
            else
                return false;
        }
    }
}




