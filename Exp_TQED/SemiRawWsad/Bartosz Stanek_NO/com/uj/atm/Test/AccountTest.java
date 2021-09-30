import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void test_accountStatus() throws Exception {
        IAccount obj1Acc = new Account(22,1);
        Assert.assertTrue(obj1Acc.AccountStatus()>=0);
        double b=22;
        Assert.assertFalse(obj1Acc.equals(b));
    }

    @Test
    public void test_depositFunds() throws Exception{
        IAccount obj1Acc = new Account(22,1);
        Assert.assertTrue(obj1Acc.DepositFunds(10)==32);
        int b=-2;
        Assert.assertTrue(obj1Acc.DepositFunds(b)>=0);
    }

    @Test
    public void test_withdrawFunds() throws Exception{
        IAccount obj1Acc = new Account(0,1);
        Assert.assertTrue(obj1Acc.WithdrawFunds(20)==0);
    }
}