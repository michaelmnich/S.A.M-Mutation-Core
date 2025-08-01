package com.uj.atm.Test;

import com.uj.atm.common.Account;


import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePin() {


        CreditCard test1 = new CreditCard();
        assertTrue(test1!=null);
        assertTrue(test1.IsPinValid("0000"));
        assertTrue(test1.ChangePin("0000","2222","2222"));
        assertFalse(test1.ChangePin("1111","2222","2222")); // zły oldpin
        assertFalse(test1.ChangePin("11111","2222","2222")); // zły oldpin za dużo cyfr
        assertFalse(test1.ChangePin("11s1","2222","2222")); // zły oldpin
        assertFalse(test1.ChangePin("111c","2222","2222")); // zły oldpin
        assertFalse(test1.ChangePin("1c11","2222","2222")); // zły oldpin
        assertFalse(test1.ChangePin("c111","2222","2222")); // zły oldpin
        assertFalse(test1.ChangePin("1111","22222","22222")); // zły newPin i NewPinConfirm
        assertFalse(test1.ChangePin("1111","22c2","22c2"));// zły newPin i NewPinConfirm
        assertFalse(test1.ChangePin("2222","2222","2222")); // taki sam oldPin i newPin
        assertTrue(test1.IsPinValid("2222"));

    }

    @Test
    public void isPinValid() {


        CreditCard test1 = new CreditCard();
        assertTrue(test1.IsPinValid("0000"));
        assertTrue(test1.ChangePin("0000","6969","6969"));
        assertTrue(test1.IsPinValid("6969"));


    }

    @Test
    public void addAccount() {
        IAccount Obiekt = new Account();
        CreditCard test1 = new CreditCard();
        assertFalse(test1.WithdrawFunds(20.3));
        test1.AddAccount(Obiekt);
        assertTrue(test1.WithdrawFunds(30.3));
        assertTrue(Obiekt.AccountStatus()==0);

    }

    @Test
    public void depositFunds() {
        IAccount Obiekt = new Account();
        CreditCard test1 = new CreditCard();
        Obiekt.DepositFunds(6969);
        assertTrue(Obiekt.AccountStatus()==6969);
        Obiekt.DepositFunds(-6969);
        assertTrue(Obiekt.AccountStatus()==6969);
        Obiekt.DepositFunds(1.1);
        assertTrue(Obiekt.AccountStatus()==6970.1);
        Obiekt.DepositFunds(-1.1);
        assertTrue(Obiekt.AccountStatus()==6970.1);

    }

    @Test
    public void withdrawFunds() {
        IAccount Obiekt = new Account();
        CreditCard test1 = new CreditCard();
        Obiekt.WithdrawFunds(-69);
        assertTrue(Obiekt.AccountStatus()==0);
        Obiekt.DepositFunds(6969);
        assertTrue(Obiekt.AccountStatus()==6969);
        Obiekt.WithdrawFunds(-7000.1);
        assertTrue(Obiekt.AccountStatus()==6969);
        Obiekt.WithdrawFunds(7000.1);
        assertTrue(Obiekt.AccountStatus()==6969);
        Obiekt.WithdrawFunds(69);
        assertTrue(Obiekt.AccountStatus()==6900);
    }
}