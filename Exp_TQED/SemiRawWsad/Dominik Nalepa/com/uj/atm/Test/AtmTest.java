package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {


    //check pin and login
    @Test
    public void test01(){

        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        String PIN = "0000";
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,PIN));
    }

    @Test
    public void test02(){

        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,"000"));
        String PIN = "000";
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,PIN));

        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,"00000"));
        PIN = "00000";
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,PIN));

        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,"ążźć"));
        PIN = "ążźć";
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,PIN));
    }

    //acc status
    @Test
    public void test03(){

        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        String PIN = "0000";
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        if(atm.CheckPinAndLogIn(cardTest,"0000") && atm.CheckPinAndLogIn(cardTest,PIN) ){
            Assert.assertTrue(atm.AccountStatus(accTest) == 0);
        }
    }

    //change pin
    @Test
    public void test04(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Assert.assertTrue(atm.ChangePinCard(cardTest,"0000","1111","1111"));

        String PIN = "1111";
        String newPIN = "2222";
        String newPINConfirm = "2222";
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,PIN));
        Assert.assertTrue(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));
    }

    //poprawne stare haslo
    @Test
    public void test05(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","11111","11111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","111","111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","aaaa","aaaa"));

        String PIN = "0000";
        String newPIN = "aaaa";
        String newPINConfirm = "aaaa";
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,PIN));
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "111";
        newPINConfirm = "111";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "11111";
        newPINConfirm = "11111";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "-111";
        newPINConfirm = "-111";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "-1111";
        newPINConfirm = "-1111";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));
    }


    //niepoprawne stare haslo
    @Test
    public void test06(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,"000"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"00000","1111","1111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"asad","1111","1111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"-000","1111","1111"));

        String PIN = "-000";
        String newPIN = "1111";
        String newPINConfirm = "1111";
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,PIN));
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        PIN = "-0000";
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,PIN));
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        PIN = "11000";
        Assert.assertFalse(atm.CheckPinAndLogIn(cardTest,PIN));
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));
    }


    //niepoprawne nowe haslo
    @Test
    public void test07(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","11111","1111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","111","1111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","aaaa","1111"));

        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","11111","11111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","111","111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","aaaa","aaaa"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","-0000","-0000"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","-000","-000"));

        String PIN = "0000";
        String newPIN = "111";
        String newPINConfirm = "1111";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "11111";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "asad";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "-000";
        newPINConfirm = "0000";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));
    }


    //niepoprawny confirm
    @Test
    public void test08(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","1111","111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","1111","11111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","1111","asad"));

        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","1111","11111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","1111","111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","1111","-111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","1111","-1111"));
        Assert.assertFalse(atm.ChangePinCard(cardTest,"0000","0000","-000"));

        String PIN = "0000";
        String newPIN = "1111";
        String newPINConfirm = "111";
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,PIN));
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPINConfirm = "11111";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPINConfirm = "asad";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));

        newPIN = "0000";
        newPINConfirm = "-000";
        Assert.assertFalse(atm.ChangePinCard(cardTest,PIN,newPIN,newPINConfirm));
    }

//wplata

    @Test
    public void test09(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();

        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 12.12;
        Assert.assertTrue(atm.DepositFunds(cardTest,12.12));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));
    }

    @Test
    public void test10(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();

        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 0.0;
        Assert.assertFalse(atm.DepositFunds(cardTest,0));
        Assert.assertFalse(atm.DepositFunds(cardTest,kwota));
    }


    @Test
    public void test11(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();

        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = -2.0;
        Assert.assertFalse(atm.DepositFunds(cardTest,-2.21));
        Assert.assertFalse(atm.DepositFunds(cardTest,kwota));
    }


    //proba wplaty bez przypisania konta do karty
    @Test
    public void test12(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();


        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 2.22;
        Assert.assertFalse(atm.DepositFunds(cardTest,2.22));
        Assert.assertFalse(atm.DepositFunds(cardTest,kwota));
        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.DepositFunds(cardTest,2.22));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));
    }

    //wyplata

    @Test
    public void test13(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();

        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 12.12;
        Assert.assertTrue(atm.DepositFunds(cardTest,12.12));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));

        Assert.assertTrue(atm.WithdrawFunds(cardTest,12.12));
        Assert.assertTrue(atm.WithdrawFunds(cardTest,kwota));
    }


    @Test
    public void test14(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();

        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 12.12;
        Assert.assertTrue(atm.DepositFunds(cardTest,12.12));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));

        kwota = 0.0;
        Assert.assertFalse(atm.WithdrawFunds(cardTest,0));
        Assert.assertFalse(atm.WithdrawFunds(cardTest,kwota));
    }

    @Test
    public void test15(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();

        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 12.12;
        Assert.assertTrue(atm.DepositFunds(cardTest,12.12));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));

        kwota = -2.20;
        Assert.assertFalse(atm.WithdrawFunds(cardTest,-2.21));
        Assert.assertFalse(atm.WithdrawFunds(cardTest,kwota));
    }


//wyplata gdy nie ma funduszy
    @Test
    public void test16(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        cardTest.AddAccount(accTest);

        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 12.12;
        Assert.assertFalse(atm.WithdrawFunds(cardTest,2.21));
        Assert.assertFalse(atm.WithdrawFunds(cardTest,kwota));
    }

    @Test
    public void test17(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        cardTest.AddAccount(accTest);

        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = -12.12;
        Assert.assertFalse(atm.WithdrawFunds(cardTest,-2.21));
        Assert.assertFalse(atm.WithdrawFunds(cardTest,kwota));
    }

    @Test
    public void test18(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        cardTest.AddAccount(accTest);

        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 0.0;
        Assert.assertFalse(atm.WithdrawFunds(cardTest,0.0));
        Assert.assertFalse(atm.WithdrawFunds(cardTest,kwota));
    }


    //wyplata gdy nie ma przypisanego konta
    @Test
    public void test19(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();

        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));
        Double kwota = 12.12;
        Assert.assertFalse(atm.WithdrawFunds(cardTest,2.21));
        Assert.assertFalse(atm.WithdrawFunds(cardTest,kwota));
    }

    //poprawny transfer
    @Test
    public void test20(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        IAccount accountRecipient = new Account();
        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        Double kwota = 12.12;
        Assert.assertTrue(atm.DepositFunds(cardTest,12.12));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));

        Assert.assertTrue(atm.Transfer(cardTest,accountRecipient,12.12));
        Assert.assertTrue(atm.Transfer(cardTest,accountRecipient,kwota));
    }

    //przelew na 0
    @Test
    public void test21(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        IAccount accountRecipient = new Account();
        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        Double kwota = 20.0;
        Assert.assertTrue(atm.DepositFunds(cardTest,20.0));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));

        kwota = 0.0;
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,0.0));
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,kwota));
    }


    //proba przelewu gdy nie ma przypisanego konta do karty
    @Test
    public void test22(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        IAccount accountRecipient = new Account();
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        Double kwota = 12.12;
        Assert.assertFalse(atm.DepositFunds(cardTest,12.12));
        Assert.assertFalse(atm.DepositFunds(cardTest,kwota));

       Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,12.12));
       Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,kwota));
    }


    //przelew na minusie
    @Test
    public void test23(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        IAccount accountRecipient = new Account();
        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        Double kwota = 20.0;
        Assert.assertTrue(atm.DepositFunds(cardTest,20.0));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));

        kwota = -20.0;
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,-20.0));
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,kwota));
    }

    //proba przelania wiecej niz wplacone
    @Test
    public void test24(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        IAccount accountRecipient = new Account();
        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        Double kwota = 20.0;
        Assert.assertTrue(atm.DepositFunds(cardTest,20.0));
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));

        kwota = 50.0;
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,50.0));
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,kwota));
    }

    //sprawdzenie czy po transferze na koncie odbiorcy sa przelande pieniadze
    @Test
    public void test25(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        IAccount accountRecipient = new Account();
        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        Double kwota = 11.11;
        Assert.assertTrue(atm.DepositFunds(cardTest,kwota));
        Assert.assertTrue(atm.Transfer(cardTest,accountRecipient,kwota));

        Assert.assertTrue(kwota.equals(accountRecipient.AccountStatus()));
    }

    //sprawdzenie czy jesli sie transfer nie uda to nie zmienilo stanu konta odbiorcy
    @Test
    public void test26(){
        ICreditCard cardTest = new CreditCard();
        IAtm atm = new Atm();
        IAccount accTest = new Account();
        IAccount accountRecipient = new Account();
        cardTest.AddAccount(accTest);
        Assert.assertTrue(atm.CheckPinAndLogIn(cardTest,"0000"));

        Double kwota = -10.0;
        Assert.assertFalse(atm.DepositFunds(cardTest,kwota));
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,kwota));
        Assert.assertTrue(accountRecipient.AccountStatus() == 0);

        kwota = 0.0;
        Assert.assertFalse(atm.DepositFunds(cardTest,kwota));
        Assert.assertFalse(atm.Transfer(cardTest,accountRecipient,kwota));
        Assert.assertTrue(accountRecipient.AccountStatus() == 0);
    }


}
