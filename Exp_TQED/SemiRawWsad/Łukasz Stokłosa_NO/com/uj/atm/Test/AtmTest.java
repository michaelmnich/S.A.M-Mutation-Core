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
    Account ac1;
    Account ac2;
    Atm atm;

    @Before
    public void setCard() {
        card = new CreditCard("0000");
        card2 = new CreditCard("1234");
    }

    @Before
    public void setAccount() {
        ac1 = new Account(100);
        ac2 = new Account(-300);
    }

    @Before
    public void setAtm() {
        atm = new Atm();

    }


    @Test
    public void testChekPinAndLoginSucces() {
        assertTrue(atm.CheckPinAndLogIn(card, "0000"));
    }

    @Test
    public void testChekPinAndLoginNegative() {
        assertFalse(atm.CheckPinAndLogIn(card, "PIN"));
        assertFalse(atm.CheckPinAndLogIn(card, "0012"));
        assertFalse(atm.CheckPinAndLogIn(card, "00aa"));
        assertFalse(atm.CheckPinAndLogIn(card, "qwert"));
    }


    @Test
    public void testAccountStatusSucces() {
        System.out.println("Stan konta wynosi: " + atm.AccountStatus(ac1)
                + "PLN");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAccountStatusNegative() {
        System.out.println("Stan konta wynosi: " + atm.AccountStatus(ac2)
                + "PLN");
    }

    @Test
    public void testChangePinCardSucces() {
        assertTrue(atm.ChangePinCard(card, "0000", "1234", "1234"));

    }

    @Test
    public void testChangePinCardNegative() {
        assertFalse(atm.ChangePinCard(card, "0000", "dsaa", "dsaa"));
        assertFalse(atm.ChangePinCard(card, "0000", "dsaa", "dsaa"));
        assertFalse(atm.ChangePinCard(card, "0000", "1234", "0000"));

    }

    @Test
    public void testDepositFundsSucces() {
        card.AddAccount(ac1);
        atm.DepositFunds(card, 50);
        assertTrue(atm.DepositFunds(card, 50));
    }


    @Test
    public void testDepositFundsNegative() {
        System.out.println(atm.AccountStatus(ac1));
        assertFalse(atm.DepositFunds(card, -50));
        assertFalse(atm.DepositFunds(card, -500));
    }

    @Test
    public void testWithdrawFunds() {
        card.AddAccount(ac1);
        atm.WithdrawFunds(card, 50);
        assertTrue(atm.WithdrawFunds(card, 40));
    }

    @Test
    public void testTransferSucces() {
        ac2 = new Account(300);
        card.AddAccount(ac1);
        assertTrue(atm.Transfer(card, ac2, 50));
    }

    @Test
    public void testTransferMegative() {
        ac2 = new Account(300);
        card.AddAccount(ac1);
        assertFalse(atm.Transfer(card, ac2, 150));
    }


}