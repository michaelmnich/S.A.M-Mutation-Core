import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void test_changePin() throws Exception{
        ICreditCard obj1 = new CreditCard("1111");
        Assert.assertTrue(obj1.ChangePin("9999","1111","1111"));

    }

    @Test
    public void test_isPinValid() throws Exception{
        ICreditCard obj1 = new CreditCard("0000");
        assertNotNull(obj1);
        Assert.assertFalse(obj1.IsPinValid("000000"));
        Assert.assertFalse(obj1.IsPinValid("000"));
        Assert.assertFalse(obj1.IsPinValid("aaaa"));
        Assert.assertFalse(obj1.IsPinValid("       "));
    }

    @Test
    public void test_addAccount() throws Exception{
        IAccount obj1Acc = new Account(22,1);
        Assert.assertNotNull(obj1Acc);
    }

    @Test
    public void test_depositFunds() throws Exception{
        IAccount obj1Acc = new Account(22,1) ;
        Assert.assertNotNull(obj1Acc);
        Assert.assertTrue(obj1Acc.DepositFunds(10)==32);
    }

    @Test
    public void test_withdrawFunds() throws Exception{
        IAccount obj1Acc = new Account(22,1) ;
        Assert.assertNotNull(obj1Acc);
        Assert.assertFalse(obj1Acc.WithdrawFunds(20)==0);
    }
}