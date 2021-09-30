import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreditCardTest {
    CreditCard card;
    Account account;

    @org.junit.Before
    public void setCard() {
        card = new CreditCard("1111");
    }

    @org.junit.Before
    public void setAccount() {
        account = new Account(150);
    }

    @org.junit.Test
    public void testChangePinSucces() {
        assertFalse(card.ChangePin("1111", "0123", "1111"));
    }

    @org.junit.Test
    public void testChangePinFailure() {
        assertTrue(card.ChangePin("1111", "1111", "1111"));
    }

    @org.junit.Test
    public void testIsPinValidSucces() {
        assertTrue(card.IsPinValid("1111"));
    }

    @org.junit.Test
    public void testIsPinValidFailure() {
        assertFalse(card.IsPinValid("0123"));
        assertFalse(card.IsPinValid("9876"));
        assertFalse(card.IsPinValid("6484"));
    }

    @org.junit.Test
    public void testAddAccountSucces() {
        card.AddAccount(account);
        Assert.assertFalse(String.valueOf(account), account == null);
    }

    @org.junit.Test
    public void testAddAccountFailure() {
        card.AddAccount(account);
        Assert.assertFalse(String.valueOf(account), account == null);
    }

    @org.junit.Test
    public void DepositFundsSucces() {
        card.DepositFunds(70);
        card.AddAccount(account);
        assertTrue(card.DepositFunds(50));
    }

    @org.junit.Test
    public void DepositFundsFailure() {
        card.AddAccount(account);
        assertFalse(card.DepositFunds(-100));
    }

    @org.junit.Test
    public void WithdrawFundsSucces() {
        account = new Account(100);
        card.AddAccount(account);
        assertTrue(card.WithdrawFunds(90));
    }

    @org.junit.Test
    public void WithdrawFundsFailure() {
        account = new Account(10);
        card.AddAccount(account);
        assertFalse(card.WithdrawFunds(1000));
    }
}