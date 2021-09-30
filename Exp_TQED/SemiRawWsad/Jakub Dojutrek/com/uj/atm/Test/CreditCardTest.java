package com.uj.atm.Test;

import com.uj.atm.common.AccountSample;
import com.uj.atm.common.CreditCardSample;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    CreditCardSample cardSample;
    AccountSample acc1, acc2;

    @Before
    public void setUp(){
        this.cardSample = new CreditCardSample();
        this.acc1 = new AccountSample();
        this.acc2 = new AccountSample();
    }

    @Test
    public void pinValidation4DigitsTest(){
        assertTrue(cardSample.IsPinValid("3212"));
    }

    @Test
    public void pinValidation4DigitsWrongTest(){
        assertFalse(cardSample.IsPinValid("3a12"));
    }

    @Test
    public void pinValidation6DigitsTest(){
        assertTrue(cardSample.IsPinValid("321233"));
    }

    @Test
    public void change4PinTest(){
        assertTrue(cardSample.ChangePin("3333","2777", "2777"));
    }

    @Test
    public void change4PinWrongTest(){
        assertFalse(cardSample.ChangePin("3333","2777", "2779"));
    }

    @Test
    public void change6PinTest(){
        assertTrue(cardSample.ChangePin("333366","277746", "277746"));
    }

    @Test
    public void change6PinWrongTest(){
        assertFalse(cardSample.ChangePin("333366","277746", "277946"));
    }

    @Test
    public void samePin4Test(){
        assertFalse(cardSample.ChangePin("0000", "0000", "0000"));
    }

    @Test
    public void samePin6Test(){
        assertFalse(cardSample.ChangePin("000000", "000000", "000000"));
    }

    @Test
    public void depoFoundTest(){
        cardSample.AddAccount(acc1);
        assertTrue(cardSample.DepositFunds(30.0));
    }

    @Test
    public void depoFoundWithoutLinkAccTest(){
        assertFalse(cardSample.DepositFunds(30.0));
    }

    @Test
    public void tryAddMoreAccountsTest(){
        cardSample.AddAccount(acc1);
        cardSample.AddAccount(acc2);
        cardSample.DepositFunds(100.0);
        assertNotEquals(100.0, acc2.AccountStatus(), 0);
    }

    @Test
    public void withdrawFoundsTest(){
        cardSample.AddAccount(acc1);
        cardSample.DepositFunds(30.0);
        assertTrue(cardSample.WithdrawFunds(15.0));
    }

    @Test
    public void WithdrawFundsBigValueTest(){
        cardSample.AddAccount(acc1);
        cardSample.DepositFunds(30.0);
        assertFalse(cardSample.WithdrawFunds(55.0));
    }
}
