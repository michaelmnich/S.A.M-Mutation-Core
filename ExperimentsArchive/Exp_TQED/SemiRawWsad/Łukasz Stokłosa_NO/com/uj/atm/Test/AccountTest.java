import com.uj.atm.common.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AccountTest {
    Account ac1;
    private Object IllegalArgumentException;
    private Object expected;

    @Before
    public void setAc1() {
        ac1 = new Account();
    }
/*
    @Test
    public void testAccountStatus() {
        assertEquals(ac1.WithdrawFunds(100), 0);
    }
*/

    @Test(expected = IllegalArgumentException.class)
    public void testDepositFundsNegative() {
        ac1.WithdrawFunds(50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositFundsSucces() {
        ac1.WithdrawFunds(50);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFundsNegative() {
        ac1.WithdrawFunds(160);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFundsSucces() {
        ac1.WithdrawFunds(50);
    }


}

