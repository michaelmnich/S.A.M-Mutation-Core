import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogIn() {
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();

        assert !atm.CheckPinAndLogIn(creditCard, "1111");
        assert !atm.CheckPinAndLogIn(creditCard, "00000");
        assert !atm.CheckPinAndLogIn(creditCard, "000");
        assert atm.CheckPinAndLogIn(creditCard, "0000");
    }

    @Test
    public void accountStatus() {
        Atm atm = new Atm();
        Account account = new Account();

        assertEquals(atm.AccountStatus(account), 0.00, 0.01d);

        account.DepositFunds(100);
        assertEquals(atm.AccountStatus(account), 100.00, 0.01d);
    }

    @Test
    public void changePinCard() {
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();

        assert !atm.ChangePinCard(creditCard, "0002", "0001", "0001");
        assert !atm.ChangePinCard(creditCard, "0000", "0001", "0002");
        assert !atm.ChangePinCard(creditCard, "0000", "0002", "0001");
        assert !atm.ChangePinCard(creditCard, "0000", "-0002", "-0002");
        assert !atm.ChangePinCard(creditCard, "0000", "10000", "10000");
        assert !atm.ChangePinCard(creditCard, "0000", "aaaa", "aaaa");
        assert atm.ChangePinCard(creditCard, "0000", "0001", "0001");
        assert atm.ChangePinCard(creditCard, "0001", "1001", "1001");

    }

    @Test
    public void depositFunds() {
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        assert !atm.DepositFunds(creditCard, 100);

        Account account = new Account();
        creditCard.AddAccount(account);

        assert atm.DepositFunds(creditCard, 100);
        assert !atm.DepositFunds(creditCard, -100);
        assert atm.DepositFunds(creditCard, 12.5);
        assertEquals(account.AccountStatus(), 112.5, 0.01d);
    }

    @Test
    public void withdrawFunds() {
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        assert !atm.WithdrawFunds(creditCard,100);

        Account account = new Account();
        creditCard.AddAccount(account);
        assert !atm.WithdrawFunds(creditCard,0);
        assert !atm.WithdrawFunds(creditCard,50);

        assert atm.DepositFunds(creditCard,100);
        assert !atm.WithdrawFunds(creditCard,-50);
        assert atm.WithdrawFunds(creditCard,50);
        assert atm.WithdrawFunds(creditCard,20.05);
        assertEquals(account.AccountStatus(), 29.95, 0.01d);
        assert !atm.WithdrawFunds(creditCard,50);
    }

    @Test
    public void transfer() {
        Atm atm = new Atm();
        CreditCard creditCard = new CreditCard();
        Account account1 = new Account();
        Account account2 = new Account();

        assert !atm.Transfer(creditCard, account2, 50);

        creditCard.AddAccount(account1);
        assert !atm.Transfer(creditCard, account2, 50);

        account1.DepositFunds(100);
        assert atm.Transfer(creditCard, account2, 50);
        assert atm.AccountStatus(account1) == 50;
        assert atm.AccountStatus(account2) == 50;

        assert atm.Transfer(creditCard, account2, 50);
        assertEquals(atm.AccountStatus(account1), 0, 0.01d);
        assertEquals(atm.AccountStatus(account2), 100, 0.01d);

    }
}