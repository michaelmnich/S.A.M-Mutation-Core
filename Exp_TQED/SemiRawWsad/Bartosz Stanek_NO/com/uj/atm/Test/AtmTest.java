import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void test_checkPinAndLogIn() {
        ICreditCard o1 = new CreditCard("1111");
        IAccount acc1 = new Account(22,1);
        IAtm obj1Atm = new Atm(o1,acc1);
        Assert.assertNotNull(obj1Atm);
        Assert.assertTrue(obj1Atm.CheckPinAndLogIn(o1,"1111"));
        Assert.assertFalse(o1.IsPinValid("1111")!=obj1Atm.CheckPinAndLogIn(o1,"1111"));
    }

    @Test
    public void test_accountStatus() {
        ICreditCard o1 = new CreditCard("1111");
        IAccount acc1 = new Account(22,1);
        IAtm obj1Atm = new Atm(o1,acc1);
        Assert.assertNotNull(obj1Atm.AccountStatus(acc1));
        Assert.assertTrue(obj1Atm.AccountStatus(acc1)>=0);
    }

    @Test
    public void test_changePinCard() {
        ICreditCard o1 = new CreditCard("1111");
        IAccount acc1 = new Account(22,1);
        IAtm obj1Atm = new Atm(o1,acc1);
        Assert.assertTrue(obj1Atm.ChangePinCard(o1,"1111","2222","2222"));
    }

    @Test
    public void test_depositFunds() {
        ICreditCard o1 = new CreditCard("1111");
        IAccount acc1 = new Account(22,1);
        IAtm obj1Atm = new Atm(o1,acc1);
        Assert.assertEquals(obj1Atm.AccountStatus(acc1),acc1.AccountStatus(),22);
    }

    @Test
    public void withdrawFunds() {
        ICreditCard o1 = new CreditCard("1111");
        IAccount acc1 = new Account(22,1);
        IAtm obj1Atm = new Atm(o1,acc1);
        Assert.assertTrue(obj1Atm.WithdrawFunds(o1,22));
        Assert.assertFalse(obj1Atm.AccountStatus(acc1)==0);
    }

    @Test
    public void transfer() {
        ICreditCard o1 = new CreditCard("1111");
        IAccount acc1 = new Account(22,1);
        IAtm obj1Atm = new Atm(o1,acc1);

        Assert.assertTrue(obj1Atm.Transfer(o1,acc1,10));
        Assert.assertTrue(obj1Atm.Transfer(o1,acc1,100));
    }
}