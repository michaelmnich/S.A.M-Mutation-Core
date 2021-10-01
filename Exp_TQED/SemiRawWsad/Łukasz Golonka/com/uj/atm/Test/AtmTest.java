package com.uj.atm.Test;


import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {
    @Test
    public  void test_GetAccountStatus(){
        Atm sampleATM = new Atm();
        Account sampleAccount = new Account();
        Assert.assertTrue(sampleATM.AccountStatus(sampleAccount) == 0);
        sampleAccount.DepositFunds(333);
        Assert.assertTrue(sampleATM.AccountStatus(sampleAccount) == sampleAccount.AccountStatus());
    }

    @Test
    public void test_logginginWithAPin(){
        CreditCard sampleCreditCard = new CreditCard();
        Atm sampleAtm = new Atm();
        Assert.assertTrue(sampleAtm.CheckPinAndLogIn(sampleCreditCard, "0000"));
        Assert.assertTrue(sampleAtm.CheckPinAndLogIn(sampleCreditCard, "0001"));

    }

    @Test
    public  void test_transfer(){
        Account sourceAccount = new Account();
        Account targetAccount = new Account();
        CreditCard creditCardForTransfer = new CreditCard();
        Atm sampleAtm = new Atm();
        Assert.assertFalse(sampleAtm.Transfer(creditCardForTransfer, targetAccount, 3));
        creditCardForTransfer.AddAccount(sourceAccount);
        Assert.assertFalse(sampleAtm.Transfer(creditCardForTransfer, targetAccount, 3));
        Assert.assertTrue(sampleAtm.DepositFunds(creditCardForTransfer, 2.33));
        Assert.assertFalse(sampleAtm.Transfer(creditCardForTransfer, targetAccount, 3));
        sourceAccount.DepositFunds(3333);
        double oldTargetBalance = targetAccount.AccountStatus();
        Assert.assertTrue(sampleAtm.Transfer(creditCardForTransfer, targetAccount, 3));
        Assert.assertFalse(oldTargetBalance == targetAccount.AccountStatus());
        Assert.assertTrue(targetAccount.AccountStatus() == 3);
        Assert.assertFalse(sampleAtm.Transfer(creditCardForTransfer, targetAccount, -34));
        Assert.assertTrue(sampleAtm.AccountStatus(sourceAccount) == 3332.33);
    }

}