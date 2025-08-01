import com.uj.atm.common.Account;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void accountStatus() {
        Account account = new Account();

        //Is account status 0 on start
        assert (account.AccountStatus() == 0);

        account.DepositFunds(10);

        //Is account status correct after deposit funds
        assert (account.AccountStatus() == 10);

        account.WithdrawFunds(10);

        //Is account status correct after withdraw funds
        assert (account.AccountStatus() == 0);
    }

    @Test
    public void depositFunds() {
        Account account = new Account();
        //First time running DepositFunds
        assert(account.DepositFunds(30.5) == 30.5);

        //Can you deposit negative amount?
        assert(account.DepositFunds(-30.5) == 30.5);
        
        //Second time running DepositFunds
        assert(account.DepositFunds(30.5) == 61);

        //Can you add amount with more than 2 digits after coma?
        assert(account.DepositFunds(0.00001) == 61);

        //Can you add amount with less than 2 digits after coma?
        assert(account.DepositFunds(0.01) == 61.01);
    }

    @Test
    public void withdrawFunds() {
        Account account = new Account();

        //Can you withdraw from account without money
        assert(account.WithdrawFunds(30) == 0);

        account.DepositFunds(1000000);

        //Can you withdraw funds
        assert (account.WithdrawFunds(10) == (1000000 - 10));

        //Can you withdraw funds with more than 2 digits after coma
        assert (account.WithdrawFunds(10.0001) == (1000000 - 20));

        //Can you withdraw funds with less than 2 digits after coma?
        assert(account.WithdrawFunds(10.10) == (1000000 - 30.10));
    }
}