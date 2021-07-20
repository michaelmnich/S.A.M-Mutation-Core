package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

    @Test
    public void TestCheckPinAndLogIn(){
        CreditCard creditCard = new CreditCard();
        Atm atm = new Atm();

        Assert.assertFalse(atm.CheckPinAndLogIn(creditCard, "1111"));
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000"));

    }

    @Test
    public void TestAccountStatus(){
        Account acc_test = new Account();
        Atm atm = new Atm();

        Assert.assertTrue(atm.AccountStatus(acc_test)== 0);
        acc_test.setBalance(100);
        Assert.assertTrue(atm.AccountStatus(acc_test)== 100);

    }

    @Test
    public void TestChangePinCard(){
        CreditCard creditCard = new CreditCard();
        Atm atm = new Atm();

        Assert.assertFalse(atm.ChangePinCard(creditCard, "0000", "1111", "2222"));
        Assert.assertFalse(atm.ChangePinCard(creditCard, "0000", "2222", "1111"));
        Assert.assertFalse(atm.ChangePinCard(creditCard, "1111", "2222", "2222"));
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "2222", "2222"));
    }

    @Test
    public void TestDepositFunds(){
        CreditCard creditCard = new CreditCard();
        Atm atm = new Atm();

        Assert.assertFalse(atm.DepositFunds(creditCard, 0));
        Account acc_test = new Account();
        acc_test.setBalance(100);
        creditCard.AddAccount(acc_test);
        Assert.assertTrue(atm.DepositFunds(creditCard, 100));
        Assert.assertTrue(acc_test.getBalance()==200);
    }

    @Test
    public void TestWithdrawFunds(){
        CreditCard creditCard = new CreditCard();
        Atm atm = new Atm();

        Assert.assertFalse(atm.WithdrawFunds(creditCard, 0));
        Account acc_test = new Account();
        acc_test.setBalance(100);
        creditCard.AddAccount(acc_test);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, -1));
        Assert.assertTrue(acc_test.getBalance()==100);

        Assert.assertTrue(atm.WithdrawFunds(creditCard,100));
        Assert.assertTrue(acc_test.getBalance()==0);
    }

    @Test
    public void TestTransfer(){
        CreditCard creditCard = new CreditCard();
        Account acc_test_1 = new Account();
        Atm atm = new Atm();

        Assert.assertFalse(atm.Transfer(creditCard, acc_test_1, 100));
        Account acc_test = new Account();
        acc_test.setBalance(100);
        creditCard.AddAccount(acc_test);
        Assert.assertTrue(atm.Transfer(creditCard, acc_test_1, -1));
        Assert.assertTrue(acc_test.getBalance()==100);

        Assert.assertTrue(atm.Transfer(creditCard,acc_test_1, 100));
        Assert.assertTrue(acc_test.getBalance()==0);
    }



}
