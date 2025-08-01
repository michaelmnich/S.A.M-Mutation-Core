package com.uj.atm;

import com.uj.atm.common.Account;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account obj = new Account(500,1);
        double w=obj.AccountStatus();
        System.out.println(w);
        double j = obj.DepositFunds(50);
        System.out.println(j);
        double l = obj.WithdrawFunds(560);
        System.out.println(l);
    }
}
