package com.uj.atm.Bank;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount
{
    public double balance;
    public Account() { }

    public Account(double balance)
    {
        this.balance = balance;
    }

    @Override
    public double AccountStatus() {
        return this.balance;
    }

    @Override
    public double DepositFunds(double amount) {
        try{
            if (amount <= 0.0) throw new Exception("Nie można wpłacić podanej kwoty.");
            else {
                this.balance += amount;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return this.balance;
    }

    @Override
    public double WithdrawFunds(double amount) {
        try{
            if (amount <= 0.0 || this.balance < amount) throw new Exception("Nie można wypłacić podanej kwoty.");
            else {
                this.balance -= amount;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return this.balance;
    }
}
