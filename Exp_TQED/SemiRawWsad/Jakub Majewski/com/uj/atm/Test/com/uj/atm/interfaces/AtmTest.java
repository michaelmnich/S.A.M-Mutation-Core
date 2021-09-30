package com.uj.atm.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {
    /**
     * Test sprawdzający czy na zasadzie prób i błędów można znaleźć pin
     *
     */
    @Test
    public void checkPinAndLogIn() {
        IAtm bank = new Atm();
        ICreditCard karta = new CreditCard();
        karta.ChangePin("0000","4321","4321");
        String l = "0000";
        int a = 0;
        while (bank.CheckPinAndLogIn(karta,l)==false){
            if (a==0){
                l = "0000";
                a=a+1;
            }
            else if (a <10 ){
                l = "000"+String.valueOf(a);
                a=a+1;
            }
            else if (a < 100){
                l = "00"+String.valueOf(a);
                a=a+1;
            }
            else if (a <1000){
                l = "0"+String.valueOf(a);
                a=a+1;
            }
            else if (a <10000){
                l=String.valueOf(a);
                a=a+1;
            }
            else if (a == 10000){
                break;
            }
        }
        Assert.assertFalse(bank.CheckPinAndLogIn(karta,l));

    }

    /**
     * Sprawdzenie czy sprawdzenie stanu konta dokonuję się poprawnie
    */

    @Test
    public void accountStatus() {

        IAccount konto = new Account();
        IAtm bank = new Atm();
        Assert.assertTrue(bank.AccountStatus(konto)==konto.AccountStatus());
    }

    /**
     * Test sprawdzający czy nowy pin może zawierać 5 liczb
     */
    @Test
    public void changePinCard() {
        ICreditCard karta = new CreditCard();
        IAtm bank = new Atm();
        Assert.assertFalse(bank.ChangePinCard(karta,"0000","32141","32141"));;
    }

    /**
     * Test sprawdzający czy można wpłacić ujemną kwotę
     */
    @Test
    public void depositFunds() {
        IAtm bank = new Atm();
        ICreditCard karta = new CreditCard();
        IAccount konto = new Account();
        karta.AddAccount(konto);
        Assert.assertFalse(bank.DepositFunds(karta, -100));
    }

    /**
     * Test sprawdzający czy można wypłacić całą kwotę a następnie czy można z drugiej karty stowarzyszonym
     * z tym samym kontem wypłacić kolejną kwotę (Czy stan konta może być ujemny)
     */
    @Test
    public void withdrawFunds() {
        IAtm bank = new Atm();
        ICreditCard karta = new CreditCard();
        ICreditCard karta2 = new CreditCard();
        IAccount konto = new Account();
        karta.AddAccount(konto);
        karta2.AddAccount(konto);
        double L = konto.AccountStatus();
        Assert.assertTrue(bank.WithdrawFunds(karta,L));
        Assert.assertFalse(bank.WithdrawFunds(karta2,50));
    }

    /**
     *  Test sprawdzający czy możemy przelać kwotę większą niż stan konta
     *
     */
    @Test
    public void transfer() {
        IAtm bank = new Atm();
        ICreditCard karta = new CreditCard();
        IAccount konto = new Account();
        IAccount kontoodbiorcy = new Account();
        karta.AddAccount(konto);
        double l=konto.AccountStatus()+50;
        Assert.assertFalse(bank.Transfer(karta,kontoodbiorcy,l));

    }

    /**
     * Test sprawdzający czy po przelaniu pieniędzy z konta1 na nieistniejące konto2, kwota powróci na konto
     */
    @Test
    public void test(){
        IAtm bank = new Atm();
        ICreditCard karta = new CreditCard();
        IAccount konto = new Account();
        IAccount konto2 = new Account();
        konto2 = null;
        karta.AddAccount(konto);
        double L=konto.AccountStatus();
        bank.Transfer(karta,konto2,100);
        Assert.assertTrue(L==konto.AccountStatus());


    }

}