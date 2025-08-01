import com.uj.atm.common.Account;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void accountStatusT() {
        Account test = new Account();
        assertTrue(test.AccountStatus()==0);
    }

    @Test
    public void depositFundsT() {
        Account test = new Account();
        assertTrue(test.DepositFunds(50)==50);
        assertTrue(test.AccountStatus()==50);
    }

    @Test
    public void withdrawFundsT() {
        Account test = new Account();
        assertTrue(test.DepositFunds(50)==50);
        assertTrue(test.WithdrawFunds(50)==0);
        assertTrue(test.AccountStatus()==0);
    }
}