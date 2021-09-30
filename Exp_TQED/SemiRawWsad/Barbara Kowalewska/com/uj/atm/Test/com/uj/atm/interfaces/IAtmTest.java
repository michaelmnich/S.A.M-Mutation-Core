package com.uj.atm.interfaces;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class IAtmTest {

    Atm myAtm = new Atm();
    CreditCard myCard = new CreditCard();
    Account myAccount = new Account();
    double amount = 420;

    @Test
    public void checkPinAndLogIn() {
        assertTrue(myAtm.CheckPinAndLogIn(myCard, "0000"));
    }

    @Test
    public void checkPinAndLogFalse() {
        assertFalse(myAtm.CheckPinAndLogIn(myCard, "1234"));
    }

    @Test
    public void accountStatusTrue() {
        myAccount.DepositFunds(amount);
        assertEquals(amount, myAtm.AccountStatus(myAccount), 0.01);
    }

    @Test
    public void accountStatusFalse() {
        myAccount.DepositFunds(amount);
        assertNotEquals(amount + 1, myAtm.AccountStatus(myAccount), 0.01);
    }

    @Test
    public void changePinCardTrue1() {
        assertTrue(myAtm.ChangePinCard(myCard, "0000", "0101", "0101"));
    }

    @Test
    public void changePinCardTrue2() {
        myAtm.ChangePinCard(myCard, "0000", "0101", "0101");
        assertTrue(myAtm.CheckPinAndLogIn(myCard, "0101"));
    }

    @Test
    public void changePinCardFalse1() {
        assertFalse(myAtm.ChangePinCard(myCard, "0020", "0101", "0101"));
    }

    @Test
    public void changePinCardFalse2() {
        assertFalse(myAtm.ChangePinCard(myCard, "0000", "0001", "0101"));
    }

    @Test
    public void changePinCardFalse3() {
        assertFalse(myAtm.ChangePinCard(myCard, "0000", "test", "test"));
    }

    @Test
    public void depositFundsTrue1() {
        myCard.AddAccount(myAccount);
        assertTrue(myAtm.DepositFunds(myCard, amount));
    }

    @Test
    public void depositFundsTrue2() {
        myCard.AddAccount(myAccount);
        myAtm.DepositFunds(myCard, amount);
        assertEquals(amount, myAtm.AccountStatus(myAccount), 0.01);
    }

    @Test
    public void depositFundsFalse() {
        assertFalse(myAtm.DepositFunds(myCard, amount));
    }

    @Test
    public void withdrawFundsTrue() {
        myCard.AddAccount(myAccount);
        myAtm.DepositFunds(myCard, 2 * amount);
        assertTrue(myAtm.WithdrawFunds(myCard, amount));
    }

    @Test
    public void withdrawFundsTrue2() {
        myCard.AddAccount(myAccount);
        myAtm.DepositFunds(myCard, 2 * amount);
        myAtm.WithdrawFunds(myCard, amount);
        assertEquals(amount, myAtm.AccountStatus(myAccount), 0.01);
    }

    @Test
    public void withdrawFundsFalse1() {
        myCard.AddAccount(myAccount);
        assertFalse(myAtm.WithdrawFunds(myCard, amount));
    }

    @Test
    public void withdrawFundsFalse2() {
        myAtm.DepositFunds(myCard, 2 * amount);
        assertFalse(myAtm.WithdrawFunds(myCard, amount));
    }

    @Test
    public void transferTrue1() {
        Account accountR = new Account();
        myCard.AddAccount(myAccount);
        myCard.DepositFunds(2 * amount);
        assertTrue(myAtm.Transfer(myCard, accountR, amount));
    }

    @Test
    public void transferTrue2() {
        Account accountR = new Account();
        myCard.AddAccount(myAccount);
        myCard.DepositFunds(2 * amount);
        myAtm.Transfer(myCard, accountR, amount);
        assertEquals(amount, myAtm.AccountStatus(myAccount), 0.01);
    }

    @Test
    public void transferFalse1() {
        Account accountR = new Account();
        myCard.AddAccount(myAccount);
        assertFalse(myAtm.Transfer(myCard, accountR, amount));
    }

    @Test
    public void transferFalse2() {
        Account accountR = new Account();
        myCard.AddAccount(myAccount);
        myCard.DepositFunds(2 * amount);
        myAtm.Transfer(myCard, accountR, amount);
        assertNotEquals(amount + 10, myAtm.AccountStatus(myAccount), 0.01);
    }

    @Test
    public void transferFalse3() {
        Account accountR = new Account();
        myCard.DepositFunds(2 * amount);
        myAtm.Transfer(myCard, accountR, amount);
        assertFalse(myAtm.Transfer(myCard, accountR, amount));
    }
}