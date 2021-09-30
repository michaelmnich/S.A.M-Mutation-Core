package com.uj.atm.Test;

import com.uj.atm.common.ATMSample;
import com.uj.atm.common.AccountSample;
import com.uj.atm.common.CreditCardSample;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest {
    AccountSample acc1, acc2;
    CreditCardSample card1, card2;
    ATMSample atm;


    @Before
    public void setUp(){
        acc1 = new AccountSample();
        acc2 = new AccountSample();
        card1 = new CreditCardSample();
        card2 = new CreditCardSample();
        atm = new ATMSample();

        card1.AddAccount(acc1);
    }


    @Test
    public void checkDefaultPinATMTest(){
        assertTrue(atm.CheckPinAndLogIn(card1, "0000"));
    }

    @Test
    public void checkPinATMTest(){
        assertFalse(atm.CheckPinAndLogIn(card1, "1234"));
    }

    @Test
    public void checkWrongFormatPinATMTest(){
        assertFalse(atm.CheckPinAndLogIn(card1, "00a0"));
    }

    @Test
    public void atmAccStatusTest(){
        card1.DepositFunds(50.0);
        assertEquals(50.0, atm.AccountStatus(acc1),0);
    }

    @Test
    public void atmAccStatusMinusValueTest(){
        card1.DepositFunds(-50.0);
        assertEquals(0.0, atm.AccountStatus(acc1),0);
    }

    @Test
    public void atmChangePinTest(){
        assertTrue(atm.ChangePinCard(card1,"0000","1234","1234"));
    }

    @Test
    public void multipleWrongPinsTest(){
        assertFalse(atm.ChangePinCard(card1,"0000","1234","1111"));
        assertFalse(atm.ChangePinCard(card1,"0000","0000","0000"));
        assertFalse(atm.ChangePinCard(card1,"0000","23","2222"));
        assertFalse(atm.ChangePinCard(card1,"0000","3331","3333"));
        assertFalse(atm.ChangePinCard(card1,"000000","333331","333333"));

    }

    @Test
    public void atmChangePinAndLogInTest(){
        assertTrue(atm.ChangePinCard(card1,"0000","3333","3333"));
        assertTrue(atm.CheckPinAndLogIn(card1, "3333"));
    }

    @Test
    public void withdrawATMTest(){
        card1.DepositFunds(50.0);
        assertTrue(atm.WithdrawFunds(card1,30.0));
    }

    @Test
    public void transferMoneyTest(){
        atm.DepositFunds(card1, 50.0);
        assertTrue(atm.Transfer(card1,acc2,30.0));
    }

    @Test
    public void transferMoneyWrongTest(){
        atm.DepositFunds(card1, 50.0);
        assertFalse(atm.Transfer(card1,acc2,70.0));
    }
}
