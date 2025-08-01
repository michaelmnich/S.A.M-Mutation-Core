package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
    final List<CreditCard> objects_credit_card = new ArrayList<>();
    public List<CreditCard> getObjects_credit_card() {
        return objects_credit_card;
    }

    public  void setObjects_credit_card(CreditCard new_card) {
        this.objects_credit_card.add(new_card);
    }
    private double balance;

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public Account() {
        this.balance = 0;
    }

    @Override
    public double AccountStatus() {
        return this.getBalance();
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount>0){
            setBalance(amount);
        }
        return this.getBalance();
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (amount>0 && this.getBalance()>=amount){
            setBalance(-amount);
        }
        return this.getBalance();
    }

    public double getBalance() {
        return balance;
    }
}
