//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.uj.atm;

import com.uj.atm.Main.Account;
import com.uj.atm.Main.Atm;
import com.uj.atm.Main.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    public MainTest() {
    }

    @Test
    public void testDepositFunds() {
        Account sampleAccount = new Account();
        Assert.assertEquals(20.0D, sampleAccount.DepositFunds(20.0D), 0.0D);
        Assert.assertEquals(sampleAccount.AccountStatus(), sampleAccount.DepositFunds(-20.0D), 0.0D);
    }

    @Test
    public void testWithdrawFunds() {
        Account sampleAccount = new Account();
        Assert.assertEquals(0.0D, sampleAccount.WithdrawFunds(-10.0D), 0.0D);
        Assert.assertTrue(sampleAccount.AccountStatus() == 0.0D);
        Assert.assertEquals(0.0D, sampleAccount.WithdrawFunds(10.0D), 0.0D);
        sampleAccount.DepositFunds(50.0D);
        Assert.assertEquals(40.0D, sampleAccount.WithdrawFunds(10.0D), 0.0D);
    }

    @Test
    public void testAccountStatus() {
        Account sampleAccount = new Account();
        sampleAccount.DepositFunds(10.0D);
        Assert.assertEquals(10.0D, sampleAccount.AccountStatus(), 0.0D);
    }

    @Test
    public void testChangePinByCard() {
        CreditCard sampleCreditCard = new CreditCard("7777");
        Assert.assertTrue(sampleCreditCard.ChangePin("7777", "1111", "1111"));
        Assert.assertFalse(sampleCreditCard.ChangePin("7777", "1233", "1233"));
        Assert.assertFalse(sampleCreditCard.ChangePin("1111", "1233", "1234"));
    }

    @Test
    public void testIsPinValidByCard() {
        CreditCard sampleCreditCard = new CreditCard("1234");
        Assert.assertFalse(sampleCreditCard.IsPinValid("1111"));
        Assert.assertTrue(sampleCreditCard.IsPinValid("1234"));
    }

    @Test
    public void testAddAccountByCard() {
        Account sampleAccount = new Account();
        CreditCard sampleCreditCard = new CreditCard("1234");
        sampleCreditCard.AddAccount(sampleAccount);
        Assert.assertEquals(sampleCreditCard.AccountLinked, sampleAccount);
    }

    @Test
    public void testDepositFundsByCard() {
        Account sampleAccount = new Account();
        CreditCard sampleCreditCard = new CreditCard("1234");
        sampleCreditCard.AddAccount(sampleAccount);
        sampleCreditCard.DepositFunds(19.99D);
        Assert.assertEquals(sampleAccount.AccountStatus() == 19.99D, sampleCreditCard.DepositFunds(19.99D));
    }

    @Test
    public void testWidthdrawFundsByCard() {
        Account sampleAccount = new Account();
        CreditCard sampleCreditCard = new CreditCard("1234");
        sampleCreditCard.AddAccount(sampleAccount);
        sampleCreditCard.DepositFunds(20.0D);
        Assert.assertTrue(sampleAccount.AccountStatus() == 20.0D);
        sampleCreditCard.WithdrawFunds(10.0D);
        Assert.assertTrue(sampleAccount.AccountStatus() == 10.0D);
    }

    @Test
    public void testCheckPinAndLoginByAtm() {
        Atm sampleAtm = new Atm();
        CreditCard sampleCard = new CreditCard("1234");
        Assert.assertTrue(sampleAtm.CheckPinAndLogIn(sampleCard, "1234"));
        Assert.assertFalse(sampleAtm.CheckPinAndLogIn(sampleCard, "4321"));
    }

    @Test
    public void testAccountStatusByAtm() {
        Atm sampleAtm = new Atm();
        CreditCard sampleCard = new CreditCard("1234");
        Account sampleAccount = new Account();
        sampleCard.AddAccount(sampleAccount);
        sampleCard.DepositFunds(20.0D);
        Assert.assertEquals(20.0D, sampleAtm.AccountStatus(sampleAccount), 0.0D);
    }

    @Test
    public void testChangePinCardByAtm() {
        Atm sampleAtm = new Atm();
        CreditCard sampleCard = new CreditCard("1234");
        Account sampleAccount = new Account();
        sampleCard.AddAccount(sampleAccount);
        Assert.assertTrue(sampleAtm.ChangePinCard(sampleCard, "1234", "7890", "7890"));
    }

    @Test
    public void testDepositFundsByAtm() {
        Atm sampleAtm = new Atm();
        CreditCard sampleCard = new CreditCard("1234");
        Account sampleAccount = new Account();
        sampleCard.AddAccount(sampleAccount);
        Assert.assertTrue(sampleAtm.DepositFunds(sampleCard, 25.0D));
    }

    @Test
    public void testWithdrawFundsByAtm() {
        Atm sampleAtm = new Atm();
        CreditCard sampleCard = new CreditCard("1234");
        Account sampleAccount = new Account();
        sampleCard.AddAccount(sampleAccount);
        Assert.assertFalse(sampleAtm.WithdrawFunds(sampleCard, 100.0D));
        sampleAtm.DepositFunds(sampleCard, 20.0D);
        Assert.assertTrue(sampleAtm.WithdrawFunds(sampleCard, 15.0D));
        Assert.assertEquals(5.0D, sampleAccount.accountBalance, 0.0D);
    }

    @Test
    public void testTransferByAtm() {
        Atm sampleAtm = new Atm();
        CreditCard sampleCard = new CreditCard("1234");
        Account sampleAccount = new Account();
        Account anotherAccount = new Account();
        sampleCard.AddAccount(sampleAccount);
        sampleCard.DepositFunds(20.0D);
        Assert.assertTrue(sampleAtm.Transfer(sampleCard, anotherAccount, 10.0D));
        Assert.assertEquals(10.0D, anotherAccount.AccountStatus(), 0.0D);
    }
}
