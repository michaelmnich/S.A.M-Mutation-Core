import com.uj.atm.common.Account;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    Account account1;
    private Object IllegalArgumentException;
    private Object expected;

    @org.junit.Before
    public void setaccount1() {
        account1 = new Account();
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testDepositFundsFailure() {
        account1.WithdrawFunds(60);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testDepositFundsSucces() {
        account1.WithdrawFunds(60);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testWithdrawFundsFailure() {
        account1.WithdrawFunds(250);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testWithdrawFundsSucces() {
        account1.WithdrawFunds(190);
    }
}