package com.uj.atm;

import com.uj.atm.interfaces.IAccount;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IAccount konto1 = new Account(200);
        System.out.println(konto1.AccountStatus());
    }
}
