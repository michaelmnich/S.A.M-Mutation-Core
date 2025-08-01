package Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


public class AccountTest {

    private IAccount testAccount = new Account();

    @Test
    public void accountStatus() {

        assertEquals(0.0,testAccount.AccountStatus());
    }

    @Test
    public void accountStatus_after_depositFunds() {
        testAccount.DepositFunds(423.67 );
        assertEquals(423.67,testAccount.AccountStatus());
    }

    @Test
    public void depositFunds() {
        assertEquals(testAccount.AccountStatus()+56,testAccount.DepositFunds(56));
    }
    @Test
    public void depositFunds_amount0_Exception() {
        Assert.assertThrows(Exception.class, () -> testAccount.DepositFunds(0));
    }

    @Test
    public void depositFunds_amount_negative_Exception() {
        Assert.assertThrows(Exception.class, () -> testAccount.DepositFunds(-1450));
    }


    @Test
    public void withdrawFunds() {
        testAccount.DepositFunds(60);
        assertEquals(testAccount.AccountStatus()-30,testAccount.WithdrawFunds(30));

    }

    @Test
    public void withdrawFunds_amount0_Exception() {
        testAccount.DepositFunds(124);
        Assert.assertThrows(Exception.class, () -> testAccount.WithdrawFunds(0));

    }

    @Test
    public void withdrawFunds_balanceSmallerThanAmount_Exception() {
        testAccount.DepositFunds(300);
        Assert.assertThrows(Exception.class, () -> testAccount.WithdrawFunds(723));

    }


    @Test
    public void withdrawFunds_amount_negative_Exception() {
        testAccount.DepositFunds(4023);
        Assert.assertThrows(Exception.class, () -> testAccount.WithdrawFunds(-123));

    }






}