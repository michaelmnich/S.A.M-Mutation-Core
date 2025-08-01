import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogInT() {
        Atm t = new Atm();
        CreditCard test = new CreditCard();
        assertFalse(t.CheckPinAndLogIn(test, "1111"));
        assertTrue(t.CheckPinAndLogIn(test, "0000"));
    }

    @Test
    public void accountStatusT() {
        Atm t = new Atm();
        Account test = new Account();
        CreditCard test2 = new CreditCard();
        assertTrue(t.AccountStatus(test)==0);
        assertFalse(t.DepositFunds(test2, 50));
        test2.AddAccount(test);
        assertTrue(t.DepositFunds(test2, 50));
        assertTrue(t.AccountStatus(test)==50);
    }

    @Test
    public void changePinCardT() {
        Atm t = new Atm();
        CreditCard test = new CreditCard();

    }

    @Test
    public void depositFundsT() {
        Atm t = new Atm();
        Account test = new Account();
        CreditCard test2 = new CreditCard();
        test2.AddAccount(test);
        assertTrue(t.DepositFunds(test2, 50));
        assertTrue(t.AccountStatus(test)==50);
    }

    @Test
    public void withdrawFundsT() {
        Atm t = new Atm();
        Account test = new Account();
        CreditCard test2 = new CreditCard();
        test2.AddAccount(test);
        assertTrue(t.DepositFunds(test2, 50));
        assertFalse(t.WithdrawFunds(test2, 70));
        assertTrue(t.WithdrawFunds(test2, 25));
        assertTrue(t.AccountStatus(test)==25);
    }

    @Test
    public void transferT() {
        Atm t = new Atm();
        CreditCard test = new CreditCard();
        Account test2 = new Account();
        Account test2v2 = new Account();
        test.AddAccount(test2);
        assertFalse(t.AccountStatus(test2v2)==50);
        test2v2.DepositFunds(50);
        assertTrue(t.AccountStatus(test2v2)==50);
        assertFalse(t.AccountStatus(test2)==50);
        test2.DepositFunds(50);
        assertTrue(test2.AccountStatus()==50);
        t.Transfer(test, test2v2, 50);
        assertTrue(test2.AccountStatus()==0);
        assertTrue(t.AccountStatus(test2v2)==100);
    }
}