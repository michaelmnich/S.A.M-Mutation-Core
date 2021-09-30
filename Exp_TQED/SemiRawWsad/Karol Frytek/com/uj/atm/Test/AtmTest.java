package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogIn() {
        IAtm test = new Atm();
        ICreditCard test1 = new CreditCard();
        assertTrue(test.CheckPinAndLogIn(test1,"0000"));
        assertFalse(test.CheckPinAndLogIn(test1,"00000"));
        assertFalse(test.CheckPinAndLogIn(test1,"000"));
        assertFalse(test.CheckPinAndLogIn(test1,""));
        assertFalse(test.CheckPinAndLogIn(test1,"0100"));
        assertFalse(test.CheckPinAndLogIn(test1,"00d0"));
        assertFalse(test.CheckPinAndLogIn(test1,"0f00"));
        assertFalse(test.CheckPinAndLogIn(test1,"f000"));
        assertFalse(test.CheckPinAndLogIn(test1,"000f"));
    }

    @Test
    public void accountStatus() {
        //double
        IAccount test = new Account();
        IAtm test1 = new Atm();
        assertTrue(test1.AccountStatus(test)==0);

    }

    @Test
    public void changePinCard() {
        IAtm test1 = new Atm();
        ICreditCard test = new CreditCard();
        assertTrue(test1.ChangePinCard(test,"0000","6969","6969"));
        assertTrue(test1.CheckPinAndLogIn(test,"6969"));

    }

    @Test
    public void depositFunds() {
        Account test2 = new Account();
        IAtm test1 = new Atm();
        CreditCard test = new CreditCard();
        test.AddAccount(test2);
        assertTrue(test1.DepositFunds(test,69.69));
        assertTrue(test1.AccountStatus(test2)==69.69);

    }

    @Test
    public void withdrawFunds() {
        IAtm test1 = new Atm();
        ICreditCard test = new CreditCard();
        Account test2 = new Account();
        test.AddAccount(test2);
        test.DepositFunds(100);
        assertTrue(test1.WithdrawFunds(test,50));
        assertTrue(test1.AccountStatus(test2)==50);
        assertTrue(test1.WithdrawFunds(test,60));
        assertTrue(test1.AccountStatus(test2)==50);


    }

    @Test
    public void transfer() {

        CreditCard test = new CreditCard();
        Atm test1 = new Atm();
        Account test2 = new Account();
        Account test3 = new Account();
        test.AddAccount(test2);

        test2.DepositFunds(50);
        assertTrue(test2.AccountStatus()==50);
        test3.DepositFunds(70);

        test1.Transfer(test,test3,30);
        assertTrue(test3.AccountStatus()==100);
        test1.Transfer(test,test3,-30);
        assertTrue(test3.AccountStatus()==100);

    }
}