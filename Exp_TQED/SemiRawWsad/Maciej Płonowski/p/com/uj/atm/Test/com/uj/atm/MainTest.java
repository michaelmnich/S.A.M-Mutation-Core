package com.uj.atm;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testDepositFunds() {
        Main.Account sampleAccount = new Main.Account();
        assertEquals(20.0,sampleAccount.DepositFunds(20.0), 0);
        assertEquals(sampleAccount.AccountStatus(), sampleAccount.DepositFunds(-20.0), 0);

    }
    @Test
    public void testWithdrawFunds() {
        Main.Account sampleAccount = new Main.Account();
        assertEquals(0.0, sampleAccount.WithdrawFunds(-10.0), 0);
        assertTrue(sampleAccount.AccountStatus() == 0.0);
        assertEquals(0.0,sampleAccount.WithdrawFunds(10.0),0);
        sampleAccount.DepositFunds(50.0);
        assertEquals(40.0,sampleAccount.WithdrawFunds(10.0),0);

    }
    @Test
    public void testAccountStatus() {
        Main.Account sampleAccount = new Main.Account();
        sampleAccount.DepositFunds(10.0);
        assertEquals(10.0,sampleAccount.AccountStatus(),0);
    }

    @Test
    public void testChangePinByCard() {
        Main.CreditCard sampleCreditCard = new Main.CreditCard("7777");
        //Czy zmieniono PIN
        assertTrue(sampleCreditCard.ChangePin("7777","1111","1111"));
        //Czy PIN zostanie zmieniony gdy poda się stary / zły pin
        assertFalse(sampleCreditCard.ChangePin("7777","1233","1233"));
        //Czy PIN zostanie zmieniony gdy nowe PINy się różnią od siebie
        assertFalse(sampleCreditCard.ChangePin("1111","1233","1234"));


    }
    @Test
    public void testIsPinValidByCard() {
        Main.CreditCard sampleCreditCard = new Main.CreditCard("1234");
        assertFalse(sampleCreditCard.IsPinValid("1111"));
        assertTrue(sampleCreditCard.IsPinValid("1234"));
    }
    @Test
    public void testAddAccountByCard() {
        Main.Account sampleAccount = new Main.Account();
        Main.CreditCard sampleCreditCard = new Main.CreditCard("1234");
        sampleCreditCard.AddAccount(sampleAccount);
        assertEquals(sampleCreditCard.AccountLinked, sampleAccount);
    }
    @Test
    public void testDepositFundsByCard() {
        Main.Account sampleAccount = new Main.Account();
        Main.CreditCard sampleCreditCard = new Main.CreditCard("1234");
        sampleCreditCard.AddAccount(sampleAccount);

        sampleCreditCard.DepositFunds(19.99);
        assertEquals(sampleAccount.AccountStatus() == 19.99 ,sampleCreditCard.DepositFunds(19.99));
    }

    @Test
    public void testWidthdrawFundsByCard() {
        Main.Account sampleAccount = new Main.Account();
        Main.CreditCard sampleCreditCard = new Main.CreditCard("1234");
        sampleCreditCard.AddAccount(sampleAccount);

        sampleCreditCard.DepositFunds(20.0);
        assertTrue(sampleAccount.AccountStatus() == 20);

        sampleCreditCard.WithdrawFunds(10.0);
        assertTrue(sampleAccount.AccountStatus() == 10);
    }

    @Test
    public void testCheckPinAndLoginByAtm() {
        Main.Atm sampleAtm = new Main.Atm();
        Main.CreditCard sampleCard = new Main.CreditCard("1234");
        assertTrue(sampleAtm.CheckPinAndLogIn(sampleCard, "1234"));
        assertFalse(sampleAtm.CheckPinAndLogIn(sampleCard, "4321"));
    }

    @Test
    public void testAccountStatusByAtm() {
        Main.Atm sampleAtm = new Main.Atm();
        Main.CreditCard sampleCard = new Main.CreditCard("1234");
        Main.Account sampleAccount = new Main.Account();
        sampleCard.AddAccount(sampleAccount);

        sampleCard.DepositFunds(20.0);
        assertEquals(20.0, sampleAtm.AccountStatus(sampleAccount), 0);
    }
    @Test
    public void testChangePinCardByAtm() {
        Main.Atm sampleAtm = new Main.Atm();
        Main.CreditCard sampleCard = new Main.CreditCard("1234");
        Main.Account sampleAccount = new Main.Account();
        sampleCard.AddAccount(sampleAccount);

        assertTrue(sampleAtm.ChangePinCard(sampleCard, "1234","7890","7890"));

    }

    @Test
    public void testDepositFundsByAtm() {
        Main.Atm sampleAtm = new Main.Atm();
        Main.CreditCard sampleCard = new Main.CreditCard("1234");
        Main.Account sampleAccount = new Main.Account();
        sampleCard.AddAccount(sampleAccount);

        assertTrue(sampleAtm.DepositFunds(sampleCard, 25.0));

    }

    @Test
    public void testWithdrawFundsByAtm() {
        Main.Atm sampleAtm = new Main.Atm();
        Main.CreditCard sampleCard = new Main.CreditCard("1234");
        Main.Account sampleAccount = new Main.Account();
        sampleCard.AddAccount(sampleAccount);

        assertFalse(sampleAtm.WithdrawFunds(sampleCard, 100.0));
        sampleAtm.DepositFunds(sampleCard, 20.0);
        assertTrue(sampleAtm.WithdrawFunds(sampleCard, 15.0));
        assertEquals(5.00, sampleAccount.accountBalance, 0);
    }

    @Test
    public void testTransferByAtm() {
        Main.Atm sampleAtm = new Main.Atm();
        Main.CreditCard sampleCard = new Main.CreditCard("1234");

        Main.Account sampleAccount = new Main.Account();
        Main.Account anotherAccount = new Main.Account();

        sampleCard.AddAccount(sampleAccount);
        sampleCard.DepositFunds(20.0);
        assertTrue(sampleAtm.Transfer(sampleCard, anotherAccount, 10.0));
        assertEquals(10,anotherAccount.AccountStatus(), 0);

    }
}