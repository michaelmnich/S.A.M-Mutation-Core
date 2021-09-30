import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePin() {
        CreditCard creditCard = new CreditCard();

        creditCard.ChangePin("0002", "0001", "0001");
        assert creditCard.pin == 0;

        creditCard.ChangePin("0000", "0001", "0002");
        assert creditCard.pin == 0;

        creditCard.ChangePin("0000", "0002", "0001");
        assert creditCard.pin == 0;

        creditCard.ChangePin("0000", "-0002", "-0002");
        assert creditCard.pin == 0;

        creditCard.ChangePin("0000", "10000", "10000");
        assert creditCard.pin == 0;

        creditCard.ChangePin("0000", "aaaa", "aaaa");
        assert creditCard.pin == 0;

        creditCard.ChangePin("0000", "0001", "0001");
        assert creditCard.pin == 1;

        creditCard.ChangePin("0001", "1001", "1001");
        assert creditCard.pin == 1001;
    }

    @Test
    public void isPinValid() {
        CreditCard creditCard = new CreditCard();
        assert creditCard.IsPinValid("0000");

        assert !creditCard.IsPinValid("00000");
        assert !creditCard.IsPinValid("0");

        creditCard.ChangePin("0000", "0001", "0001");
        assert creditCard.IsPinValid("0001");

        creditCard.ChangePin("0001", "0100", "0100");
        assert creditCard.IsPinValid("0100");

        creditCard.ChangePin("0100", "1000", "1000");
        assert creditCard.IsPinValid("1000");

    }

    @Test
    public void addAccount() {
        CreditCard creditCard = new CreditCard();
        Account account = new Account();

        creditCard.AddAccount(account);
        assert creditCard.account == account;

        Account account2 = new Account();
        creditCard.AddAccount(account2);
        assert creditCard.account != account2;

    }

    @Test
    public void depositFunds() {
        CreditCard creditCard = new CreditCard();
        assert !creditCard.DepositFunds(100);

        Account account = new Account();
        creditCard.AddAccount(account);
        assert creditCard.DepositFunds(100);
        assert !creditCard.DepositFunds(-100);
        assert creditCard.DepositFunds(12.5);
        assertEquals(account.AccountStatus(), 112.5, 0.01d);
    }

    @Test
    public void withdrawFunds() {
        CreditCard creditCard = new CreditCard();
        assert !creditCard.WithdrawFunds(100);

        Account account = new Account();
        creditCard.AddAccount(account);
        assert !creditCard.WithdrawFunds(0);
        assert !creditCard.WithdrawFunds(50);

        assert creditCard.DepositFunds(100);
        assert !creditCard.WithdrawFunds(-50);
        assert creditCard.WithdrawFunds(50);
        assert creditCard.WithdrawFunds(20.05);
        assertEquals(account.AccountStatus(), 29.95, 0.01d);
        assert !creditCard.WithdrawFunds(50);
    }
}