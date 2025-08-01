package com.uj.atm.Test;


import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {
    @Test
    public  void test_PinValidation(){
        CreditCard sampleCreditCard = new CreditCard();
        Assert.assertFalse(sampleCreditCard.IsPinValid("333"));
        Assert.assertFalse(sampleCreditCard.IsPinValid("33333"));
        Assert.assertFalse(sampleCreditCard.IsPinValid(""));
        Assert.assertFalse(sampleCreditCard.IsPinValid("cccc"));
        Assert.assertFalse(sampleCreditCard.IsPinValid("ssddff"));
        Assert.assertFalse(sampleCreditCard.IsPinValid("-122"));
        Assert.assertTrue(sampleCreditCard.IsPinValid("0000"));
        Assert.assertTrue(sampleCreditCard.IsPinValid("0001"));
        Assert.assertTrue(sampleCreditCard.IsPinValid("1234"));
        Assert.assertTrue(sampleCreditCard.IsPinValid("3333"));
    }


    @Test
    public  void  test_ChangePin(){
        CreditCard sampleCreditCard = new CreditCard();
        Assert.assertFalse(sampleCreditCard.ChangePin("3333", "1111", "1111")); // To test that  pin defaults to "0000"
        Assert.assertFalse(sampleCreditCard.ChangePin("3333", "1112", "1111"));
        Assert.assertFalse(sampleCreditCard.ChangePin("3333", "333", "333"));
        Assert.assertFalse(sampleCreditCard.ChangePin("0000", "333", "333"));
        Assert.assertTrue(sampleCreditCard.ChangePin("0000", "3333", "3333"));
        Assert.assertFalse(sampleCreditCard.ChangePin("0000", "3333", "3333"));
        Assert.assertTrue(sampleCreditCard.ChangePin("3333", "0000", "0000"));
    }

    @Test
    public  void  test_AccountAssociating(){
        /// To avoid adding getter for an associated account
        // this test associates account with a known amount of money,
        // makes sure that withdrawal of a bigger amount fails,
        // and then  repeats this cycle attempting to associate a different account (with right amount of money).
        // Since account association is supposed to be permanent
        // it is expected this would fail.
        CreditCard sampleCreditCard = new CreditCard();
        Account sampleAccountSmallBalance = new Account();
        sampleAccountSmallBalance.DepositFunds(3);
        sampleCreditCard.AddAccount(sampleAccountSmallBalance);
        Assert.assertFalse(sampleCreditCard.WithdrawFunds(4));
        Account sampleAccountBiggerDeposid = new Account();
        sampleAccountBiggerDeposid.DepositFunds(100);
        sampleCreditCard.AddAccount(sampleAccountBiggerDeposid);
        Assert.assertFalse(sampleCreditCard.WithdrawFunds(20));
    }
    @Test
    public  void  test_Withdrawal(){
        CreditCard sampleCreditCard = new CreditCard();
        Assert.assertFalse(sampleCreditCard.WithdrawFunds(30));
        Account sampleAccount = new Account();
        sampleAccount.DepositFunds(300);
        sampleCreditCard.AddAccount(sampleAccount);
        Assert.assertTrue(sampleCreditCard.WithdrawFunds(299));
        Assert.assertFalse(sampleCreditCard.WithdrawFunds(299));
    }

    @Test
    public  void test_Depositing(){
        CreditCard sampleCreditCard = new CreditCard();
        Assert.assertFalse(sampleCreditCard.DepositFunds(33));
        Account sampleAccount = new Account();
        sampleCreditCard.AddAccount(sampleAccount);
        Assert.assertTrue(sampleCreditCard.DepositFunds(333));
    }

}


