package com.uj.atm;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;


public class Main {

    public static void main(String[] args) {
        IAccount acc1 = new Account(100);
        ICreditCard card1 = new CreditCard("4200");
        IAccount acc2 = new Account(999);
        ICreditCard card2 = new CreditCard("2222");
        card1.AddAccount(acc1);
        card2.AddAccount(acc2);
        card1.AddAccount(acc2);
        IAtm atm1 = new Atm();
        IAccount testAcc = new Account(-100);


//        System.out.println(card2.ChangePin("2222", "asdd", "asdd"));


//        System.out.println(atm1.CheckPinAndLogIn(card1, "9600"));
//        System.out.println(atm1.AccountStatus(acc1));

        System.out.println(((Account) testAcc).balance);

        System.out.println(atm1.ChangePinCard(card1,"4200","5","5"));
//        System.out.println(atm1.DepositFunds(card1,900));
//        System.out.println(atm1.WithdrawFunds(card1,2000));
//        System.out.println(atm1.Transfer(card1, acc2, 100));
//        System.out.println("------------------");
//        System.out.println(acc1.AccountStatus());
//        System.out.println(acc1.DepositFunds(421));
//        System.out.println(acc1.WithdrawFunds(421));
//        System.out.println("------------------");
//        ICreditCard card3 = new CreditCard("4444");
//        System.out.println(card3.IsPinValid("4444"));
//        System.out.println(card3.ChangePin("4444","3333","3333"));
//        System.out.println("------------------");



    }
}
