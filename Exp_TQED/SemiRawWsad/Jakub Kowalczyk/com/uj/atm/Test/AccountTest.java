import com.uj.atm.common.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void accountStatus() {
        Account account = new Account();

        assert account.AccountStatus() == 0.0;
    }

    @Test
    public void depositFunds() {
        Account account = new Account();

        account.DepositFunds(0);
        account.DepositFunds(-1);
        account.DepositFunds(-155.22);
        assertEquals(account.AccountStatus(), 0.00, 0.01d);


        account.DepositFunds(0.01);
        assertEquals(account.AccountStatus(), 0.01, 0.01d);

        account.DepositFunds(1);
        assertEquals(account.AccountStatus(), 1.01, 0.01d);

        account.DepositFunds(1000.10);
        assertEquals(account.AccountStatus(), 1001.11, 0.01d);
    }

    @Test
    public void withdrawFunds() {
        Account account = new Account();

        account.WithdrawFunds(0);
        account.WithdrawFunds(-1);
        account.WithdrawFunds(-155.22);
        assertEquals(account.AccountStatus(), 0.0, 0.01d);

        account.WithdrawFunds(0);
        account.WithdrawFunds(100);
        account.WithdrawFunds(150);
        assertEquals(account.AccountStatus(), 0.0, 0.01d);

        account.DepositFunds(150);
        account.WithdrawFunds(100.98);
        assertEquals(account.AccountStatus(), 49.02, 0.01d);

        account.WithdrawFunds(100.00);
        assertEquals(account.AccountStatus(), 49.02, 0.01d);

    }
}