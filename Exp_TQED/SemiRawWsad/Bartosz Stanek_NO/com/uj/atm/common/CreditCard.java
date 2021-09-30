package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.util.Scanner;

public class CreditCard implements ICreditCard {
    String Pin;
    IAccount acc;

    public CreditCard(String pin) {
        Pin = pin;
        acc=null;
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        this.Pin = oldPin;
        System.out.println("Please enter new Pin number (use only numbers)");
        Scanner skan = new Scanner(System.in);
        newPin= skan.nextLine();
        System.out.println("Please enter new Pin number again(use only numbers)");
        Scanner skan1 = new Scanner(System.in);
        newPinConfirm= skan1.nextLine();
        if (newPin == newPinConfirm) {
            this.Pin = newPin;
            System.out.println("Pin changed successfully");
            return true;
        } else {
            return false;
               }
    }
    @Override
    public boolean IsPinValid(String pin) {
        if(pin.length()==4 && pin.matches("[0-9]+")){
            System.out.println("Pin's length is valid");
            return true;
        }
        else{
            System.out.println("Pin's length is wrong (must be 4)");
            return false;
        }

    }

    @Override
    public void AddAccount(IAccount account) {
        this.acc=account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(this.acc!=null){
            acc.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(this.acc!=null){
            acc.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
