import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AtmTest {
    CreditCard card;
    CreditCard card2;
    Account account1;
    Account account2;
    Atm atm;

    @org.junit.Before
    public void setCard() {
        card = new CreditCard("0000");
        card2 = new CreditCard("1234");
    }

    @org.junit.Before
    public void setAccount() {
        account1 = new Account(100);
        account2 = new Account(-300);
    }

    @org.junit.Before
    public void setAtm() {
        atm = new Atm();
    }

    @org.junit.Test
    public void testChekPinAndLoginSucces() {
        assertTrue(atm.CheckPinAndLogIn(card, "0000"));
    }

    @org.junit.Test
    public void testChekPinAndLoginFailure() {
        assertFalse(atm.CheckPinAndLogIn(card, "PIN"));
        assertFalse(atm.CheckPinAndLogIn(card, "0012"));
        assertFalse(atm.CheckPinAndLogIn(card, "00aa"));
        assertFalse(atm.CheckPinAndLogIn(card, "qwert"));
    }

    @org.junit.Test
    public void testAccountStatusSucces() {
        System.out.println("Aktualny stan konta wynosi: " + atm.AccountStatus(account1) + "PLN");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAccountStatusFailure() {
        System.out.println("Aktualny stan konta wynosi: " + atm.AccountStatus(account2) + "PLN");
    }

    @org.junit.Test
    public void testChangePinCardSucces() {
        assertTrue(atm.ChangePinCard(card, "0000", "1234", "1234"));
    }

    @org.junit.Test
    public void testChangePinCardFailure() {
        assertFalse(atm.ChangePinCard(card, "0000", "dsaa", "dsaa"));
        assertFalse(atm.ChangePinCard(card, "0000", "dsaa", "dsaa"));
        assertFalse(atm.ChangePinCard(card, "0000", "1234", "0000"));
    }

    @org.junit.Test
    public void testDepositFundsSucces() {
        card.AddAccount(account1);
        atm.DepositFunds(card, 90);
        assertTrue(atm.DepositFunds(card, 90));
    }

    @org.junit.Test
    public void testDepositFundsFailure() {
        System.out.println(atm.AccountStatus(account1));
        assertFalse(atm.DepositFunds(card, -10));
        assertFalse(atm.DepositFunds(card, -90));
    }

    @org.junit.Test
    public void testWithdrawFunds() {
        card.AddAccount(account1);
        atm.WithdrawFunds(card, 90);
        assertTrue(atm.WithdrawFunds(card, 10));
    }

    @org.junit.Test
    public void testTransferSucces() {
        account2 = new Account(90);
        card.AddAccount(account1);
        assertTrue(atm.Transfer(card, account2, 10));
    }

    @org.junit.Test
    public void testTransferMegative() {
        account2 = new Account(90);
        card.AddAccount(account1);
        assertFalse(atm.Transfer(card, account2, 80));
    }
}