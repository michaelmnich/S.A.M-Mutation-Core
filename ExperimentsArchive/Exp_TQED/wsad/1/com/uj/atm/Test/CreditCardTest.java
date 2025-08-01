package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CreditCardTest {
    @Test
    public void WrongOldAndNew(){
        CreditCard card = new CreditCard();
        assertFalse(card.ChangePin("1234", "5678", "9012"));
    }
    @Test
    public void GoodOldAndWrongNew(){
        CreditCard card = new CreditCard();
        assertFalse(card.ChangePin("0000", "5678", "9012"));
    }
    @Test
    public void WrongOldAndGoodNew(){
        CreditCard card = new CreditCard();
        assertFalse(card.ChangePin("1234", "5678", "5678"));
    }
    @Test
    public void GoodOldAndGoodNew(){
        CreditCard card = new CreditCard();
        assertTrue(card.ChangePin("0000", "5678", "5678"));
    }
    @Test
    public void IsPinCorrectYes(){
        CreditCard card = new CreditCard();
        assertTrue(card.IsPinValid("0000"));
    }
    @Test
    public void IsPinCorrectNo(){
        CreditCard card = new CreditCard();
        assertFalse(card.IsPinValid("1234"));
    }
    @Test
    public void WasMoneyDeposited(){
        CreditCard card = new CreditCard();
        IAccount account = new Account(100);
        card.AddAccount(account);
        assertTrue(card.DepositFunds(50));
        assertEquals(150.0, account.AccountStatus());
    }
    @Test
    public void WithdrawFunds(){
        CreditCard card = new CreditCard();
        IAccount account = new Account(100);
        card.AddAccount(account);
        assertTrue(card.WithdrawFunds(50));
        assertEquals(50.0, account.AccountStatus());
    }


}
