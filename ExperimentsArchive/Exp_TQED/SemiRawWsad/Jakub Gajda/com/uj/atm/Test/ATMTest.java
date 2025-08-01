package com.uj.atm.Test;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import com.uj.atm.common.Account;
import com.uj.atm.common.ATM;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {

    @Test
    public void checkPinAndLogIn() {
        IAtm maszyna = new ATM();
        ICreditCard karta1 = new CreditCard();
        assertTrue(maszyna.CheckPinAndLogIn(karta1,"0000"));
        assertFalse(maszyna.CheckPinAndLogIn(karta1,"aaaa"));
        assertFalse(maszyna.CheckPinAndLogIn(karta1,""));
        assertFalse(maszyna.CheckPinAndLogIn(karta1,"1949"));
        assertFalse(maszyna.CheckPinAndLogIn(karta1,"12345"));
        assertFalse(maszyna.CheckPinAndLogIn(karta1,"123"));
    }

    @Test
    public void accountStatus() {
        IAtm maszyna2 = new ATM();
        IAccount konto2 = new Account();
        assertTrue(maszyna2.AccountStatus(konto2)==0);
    }

    @Test
    public void changePinCard() {
        IAtm maszyna3 = new ATM();
        ICreditCard karta3 = new CreditCard();
        assertTrue(maszyna3.ChangePinCard(karta3,"0000","1949","1949"));
        assertTrue(maszyna3.CheckPinAndLogIn(karta3,"1949"));
    }

    @Test
    public void depositFunds() {
        IAtm maszyna4 = new ATM();
        Account konto4 = new Account();
        CreditCard karta4 = new CreditCard();
        karta4.AddAccount(konto4);
        assertTrue(maszyna4.DepositFunds(karta4,1949.51));
        assertTrue(maszyna4.AccountStatus(konto4)==1949.51);
        assertFalse(maszyna4.AccountStatus(konto4)==1949.49);


    }

    @Test
    public void withdrawFunds() {
        IAtm maszyna5 = new ATM();
        ICreditCard karta5 = new CreditCard();
        Account konto5 = new Account();
        karta5.AddAccount(konto5);
        karta5.DepositFunds(1949);
        assertTrue(maszyna5.WithdrawFunds(karta5,100));
        assertTrue(maszyna5.AccountStatus(konto5)==1849);
        assertTrue(maszyna5.WithdrawFunds(karta5,50));
        assertTrue(maszyna5.AccountStatus(konto5)==1799);
        assertTrue(maszyna5.WithdrawFunds(karta5,50));
        assertFalse(maszyna5.AccountStatus(konto5)==1799);
//        assertFalse(maszyna5.WithdrawFunds(karta5,0));
        assertTrue(maszyna5.AccountStatus(konto5)==1749);
    }

    @Test
    public void transfer() {
        IAtm maszyna6 = new ATM();
        CreditCard karta6 = new CreditCard();
        Account konto61 = new Account();
        Account konto62 = new Account();
        karta6.AddAccount(konto61);

        konto61.DepositFunds(1000);
        assertTrue(konto61.AccountStatus()==1000); //saldo konto 61

        konto62.DepositFunds(1949.51);
        assertTrue(konto62.AccountStatus()==1949.51); //saldo konto 61

        /*przekaz pieniędzy */

        maszyna6.Transfer(karta6,konto62,50);
        assertTrue(konto62.AccountStatus()==1999.51);
        assertFalse(konto62.AccountStatus()==1999.50);

    }
}