package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class AccountSample implements IAccount {


    double balance = 0.0;


    @Override
    public double AccountStatus() {
        System.out.println("Status konta : "
                + balance);
        return balance;

    }

    @Override
    public double DepositFunds(double amount) {
        System.out.println("****Wpłata na konto****");
        if(amount < 0.0){
            System.out.println("Nie można wpłacić kwoty mniejszej od 0");
        }
        else{
            System.out.println("Kwota wpłaty : "
                    + amount);
            balance = balance + amount;
        }
        System.out.println("Status konta po wpłacie : "
                + balance);

        return balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        System.out.println("****Wypłata z konta****");
        if(amount < 0.0){
            System.out.println("Nie można wypłacić kwoty mniejszej od 0");
        }
        else{
            System.out.println("Kwota wypłaty : "
                    + amount);
            if (balance >= amount) {
                balance = balance - amount;
            }
            else {
                System.out.println("Na Twoim koncie nie ma wystarczająco środków!");
            }
        }
        System.out.println("Status konta po wypłacie : "
                + balance);

        return balance;
    }
}
