package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class AccountSample implements IAccount {
    private  double depo = 0.0;
    @Override
    public double AccountStatus() {
        return depo;
    }

    @Override
    public double DepositFunds(double amount) {
        if (amount>0) {
            depo = depo + amount;
        }
        return  depo;
    }

    @Override
    public double WithdrawFunds(double amount) {
        if (depo-amount>0)
            depo = depo - amount;
        else{
            System.out.println("Za mało środków");
            return -1.0;
        }
        return depo;
    }
}
