import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePinT() {
        CreditCard test = new CreditCard();
        assertTrue(test.Pin=="0000");
        assertFalse(test.ChangePin("1337", "1234", "1234"));
        assertTrue(test.ChangePin("0000", "1234", "1234"));
        assertTrue(test.Pin=="1234");
    }

    @Test
    public void isPinValidT() {
        CreditCard test = new CreditCard();
        assertFalse(test.IsPinValid("251"));
        assertTrue(test.IsPinValid("0000"));
        assertFalse(test.ChangePin("1337", "1234", "1234"));
        assertTrue(test.IsPinValid("0000"));
        assertTrue(test.ChangePin("0000", "1234", "1234"));
        assertTrue(test.IsPinValid("1234"));
    }

    @Test
    public void addAccountT() {
        CreditCard test = new CreditCard();
        Account test2 = new Account();
        assertFalse(test.DepositFunds(50));
        test.AddAccount(test2);
        assertTrue(test.DepositFunds(50));
    }

    @Test
    public void depositFundsT() {
        CreditCard test = new CreditCard();
        Account test2 = new Account();
        test.AddAccount(test2);
        assertTrue(test.DepositFunds(100)==true);
    }

    @Test
    public void withdrawFundsT() {
        CreditCard test = new CreditCard();
        Account test2 = new Account();
        test.AddAccount(test2);
        assertTrue(test.DepositFunds(90)==true);
        assertTrue(test.WithdrawFunds(100)==false);
        assertTrue(test.WithdrawFunds(85)==true);
    }
}