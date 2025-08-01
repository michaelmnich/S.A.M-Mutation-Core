package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class AtmTest {

    @Test
    public void IsPinCorrectYes(){
        CreditCard card = new CreditCard();
        Atm atm = new Atm();
        assertTrue(atm.CheckPinAndLogIn(card,"0000"));
    }
    @Test
    public void IsPinCorrectNo() {
        CreditCard card = new CreditCard();
        Atm atm = new Atm();
        assertFalse(atm.CheckPinAndLogIn(card,"1234"));
    }

    @Test
    public void WrongOldAndNew(){
        CreditCard card = new CreditCard();
        Atm atm = new Atm();
        assertFalse(atm.ChangePinCard(card,"1234", "5678", "9012"));
    }
    @Test
    public void GoodOldAndWrongNew(){
        CreditCard card = new CreditCard();
        Atm atm = new Atm();
        assertFalse(atm.ChangePinCard(card, "0000", "5678", "9012"));
    }
    @Test
    public void WrongOldAndGoodNew(){
        CreditCard card = new CreditCard();
        Atm atm = new Atm();
        assertFalse(atm.ChangePinCard(card,"1234", "5678", "5678"));
    }
    @Test
    public void GoodOldAndGoodNew(){
        CreditCard card = new CreditCard();
        Atm atm = new Atm();
        assertTrue(atm.ChangePinCard(card,"0000", "5678", "5678"));
    }

    @Test
    public void WasMoneyDeposited(){
        CreditCard card = new CreditCard();
        IAccount account = new Account(100);
        card.AddAccount(account);
        Atm atm = new Atm();
        assertTrue(atm.DepositFunds(card,50.0));
        assertEquals(150.0, account.AccountStatus());
    }
    @Test
    public void WithdrawFunds(){
        CreditCard card = new CreditCard();
        IAccount account = new Account(100);
        card.AddAccount(account);
        Atm atm = new Atm();
        assertFalse(atm.WithdrawFunds(card,50.0));
        assertEquals(100.0, account.AccountStatus());
    }

    @Test
    public void NotEnoughMoney(){
        CreditCard card = new CreditCard();
        IAccount account = new Account(100);
        IAccount account2 = new Account(200);
        Atm atm = new Atm();
        card.AddAccount(account);
        assertFalse(atm.Transfer(card, account2, 300));
        assertEquals(100.0, account.AccountStatus());
        assertEquals(200.0, account2.AccountStatus());

    }

    @Test
    public void EnoughMoney(){
        CreditCard card = new CreditCard();
        IAccount account = new Account(100);
        IAccount account2 = new Account(200);
        Atm atm = new Atm();
        card.AddAccount(account);
        assertTrue(atm.Transfer(card, account2, 50));
        assertEquals(50.0, account.AccountStatus());
        assertEquals(250.0, account2.AccountStatus());

    }
}
