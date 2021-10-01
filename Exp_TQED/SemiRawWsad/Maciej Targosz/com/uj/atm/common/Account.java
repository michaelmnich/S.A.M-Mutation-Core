package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    private double piniendze = 0;

    @Override
    public double AccountStatus(){
        return this.piniendze;
    }

    @Override
    public double DepositFunds(double amount){
        if(amount>0){
            double v = this.piniendze + amount;
            this.piniendze = v;
            return v;
        }
        else{
            return this.piniendze;
        }
    }

    @Override
    public double WithdrawFunds(double amount){
        if(amount>0 && amount<=this.AccountStatus()){
            double v = this.piniendze - amount;
            this.piniendze = v;
            return v;
        }
        else{
            return this.piniendze;
        }
    }
}
