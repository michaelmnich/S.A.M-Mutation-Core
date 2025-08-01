package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.util.Scanner;

public class CreditCard implements ICreditCard {
    double saldo;

    public AccountBalance getAccount() {
        return account;
    }

    AccountBalance account;

    //double scanPin;
    //Scanner scan = new Scanner(System.in);
    //String scanPin = scan.nextLine();
    String scanPin = "1234";
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(oldPin==scanPin) {
            if (newPin == newPinConfirm) {
                oldPin = newPin;
                if (oldPin == newPin) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Metoda sprawdza, czy PIN danej karty jest poprawny
     * @param pin Kod PIN zapisany jako łańcuch znakowy (String)
     * @return Jeżeli kod PIN jest poprawny zwraca true, w przeciwnym wypadku zwraca false.
     */
    @Override
    public boolean IsPinValid(String pin) {

        if(pin == scanPin){
            return true;
        }
        return false;
    }
    /**
     * Metoda stowarzysza z daną kartą określone konto. Każda karta może być stowarzyszona z co najwyżej jednym kontem.
     * @param account Obiekt konta które będzie dodane do karty.
     */
    @Override
    public void AddAccount(IAccount account) {
        if(this.account == null){
            this.account = (AccountBalance) account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {

        if(amount > 0) {
            this.account.saldo += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (amount<0){
            return false;
        }
        if(this.account.saldo >= amount) {
            this.account.saldo -= amount;
            return true;
        }
        return false;
    }
}
