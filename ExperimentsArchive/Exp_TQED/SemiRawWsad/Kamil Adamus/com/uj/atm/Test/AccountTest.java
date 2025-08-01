import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void accountStatus() {
        IAccount account = new Account();
        Assert.assertTrue(account.AccountStatus() == 0);

        Double res = account.AccountStatus();
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

///

    //Correct params in int
    @Test
    public void depositFundsDD() {
        IAccount account = new Account();
        Assert.assertTrue(account.DepositFunds(1337) == 1337);
        Assert.assertTrue(account.DepositFunds(3) == 1340);

        IAccount account1 = new Account();
        account1.DepositFunds(1337);
        Double res;
        res = account1.DepositFunds(3);
        Double wantedRes = 1340.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Correct params in double
    @Test
    public void depositFundsDD1() {
        IAccount account = new Account();
        Assert.assertTrue(account.DepositFunds(13.37) == 13.37);
        Assert.assertTrue(account.DepositFunds(0.03) == 13.4);

        IAccount account1 = new Account();
        account1.DepositFunds(13.37);
        Double res;
        res = account1.DepositFunds(0.03);
        Double wantedRes = 13.4;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Minus amount in int
    @Test
    public void depositFundsDD2() {
        IAccount account = new Account();
        Assert.assertTrue(account.DepositFunds(-10) == 0);

        IAccount account1 = new Account();
        Double res = account1.DepositFunds(-10);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Minus amount in double
    @Test
    public void depositFundsDD3() {
        IAccount account = new Account();
        Assert.assertTrue(account.DepositFunds(-10.01) == 0);

        IAccount account1 = new Account();
        Double res = account1.DepositFunds(-10.01);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Big numbers in int
    @Test
    public void depositFundsDI() {
        IAccount account = new Account();
        Assert.assertTrue(account.DepositFunds(1337123123) == 1337123123);

        IAccount account1 = new Account();
        Double res = account1.DepositFunds(1337123123);
        Double wantedRes = 1337123123.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Weird decimal places in double
    @Test
    public void depositFundsDI1() {
        IAccount account = new Account();
        Assert.assertTrue(account.DepositFunds(1.337123123) == 1.34);

        IAccount account1 = new Account();
        Double res = account1.DepositFunds(1.337123123);
        Double wantedRes = 1.34;
        Assert.assertTrue(res.equals(wantedRes));
    }

///

    //Correct params in int
    @Test
    public void WithdrawFundsDD() {
        IAccount account = new Account();
        Assert.assertTrue(account.WithdrawFunds(1337) == 0);
        Assert.assertTrue(account.WithdrawFunds(3) == 0);

        IAccount account1 = new Account();
        Double res = account1.WithdrawFunds(1337);
        res = account1.WithdrawFunds(3);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Correct params in double
    @Test
    public void WithdrawFundsDD1() {
        IAccount account = new Account();
        Assert.assertTrue(account.WithdrawFunds(13.37) == 0);
        Assert.assertTrue(account.WithdrawFunds(0.03) == 0);

        IAccount account1 = new Account();
        Double res = account1.WithdrawFunds(13.37);
        res = account1.WithdrawFunds(0.03);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Minus amount in int
    @Test
    public void WithdrawFundsDD2() {
        IAccount account = new Account();
        Assert.assertTrue(account.WithdrawFunds(-10) == 0);

        IAccount account1 = new Account();
        Double res = account1.WithdrawFunds(-10);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Minus amount in double
    @Test
    public void WithdrawFundsDD3() {
        IAccount account = new Account();
        Assert.assertTrue(account.WithdrawFunds(-10.01) == 0);

        IAccount account1 = new Account();
        Double res = account1.WithdrawFunds(-10.01);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Big numbers in int
    @Test
    public void WithdrawFundsDI() {
        IAccount account = new Account();
        Assert.assertTrue(account.WithdrawFunds(1337123123) == 0);

        IAccount account1 = new Account();
        Double res = account1.WithdrawFunds(1337123123);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

    //Weird decimal places in double
    @Test
    public void WithdrawFundsDI1() {
        IAccount account = new Account();
        Assert.assertTrue(account.WithdrawFunds(1.337123123) == 0);

        IAccount account1 = new Account();
        Double res = account1.WithdrawFunds(1.337123123);
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));
    }

///

    @Test
    public void ZZ() {
        IAccount account = new Account();
        Assert.assertTrue(account.AccountStatus() == 0);
        Assert.assertTrue(account.WithdrawFunds(1.337123123) == 0);
        Assert.assertTrue(account.DepositFunds(13.37) == 13.37);
        Assert.assertTrue(account.AccountStatus() == 13.37);
        Assert.assertTrue(account.DepositFunds(-13.37) == 13.37);
        Assert.assertTrue(account.AccountStatus() == 13.37);
        Assert.assertTrue(account.WithdrawFunds(1) == 12.37);
        Assert.assertTrue(account.AccountStatus() == 12.37);

        IAccount account1 = new Account();
        Double res = account1.AccountStatus();
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.WithdrawFunds(1.337123123);
        wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.DepositFunds(13.37);
        wantedRes = 13.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.AccountStatus();
        wantedRes = 13.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.DepositFunds(-13.37);
        wantedRes = 13.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.AccountStatus();
        wantedRes = 13.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.WithdrawFunds(1);
        wantedRes = 12.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.AccountStatus();
        wantedRes = 12.37;
        Assert.assertTrue(res.equals(wantedRes));
    }

    @Test
    public void ZZ1() {
        IAccount account = new Account();
        Assert.assertTrue(account.AccountStatus() == 0);
        Assert.assertTrue(account.DepositFunds(13.37) == 13.37);
        Assert.assertTrue(account.WithdrawFunds(10) == 3.37);
        Assert.assertTrue(account.AccountStatus() == 3.37);
        Assert.assertTrue(account.DepositFunds(-13.37) == 3.37);
        Assert.assertTrue(account.AccountStatus() == 3.37);
        Assert.assertTrue(account.WithdrawFunds(13.37) == 3.37);
        Assert.assertTrue(account.AccountStatus() == 3.37);

        IAccount account1 = new Account();
        Double res = account1.AccountStatus();
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.DepositFunds(13.37);
        wantedRes = 13.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.WithdrawFunds(10);
        wantedRes = 3.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.AccountStatus();
        wantedRes = 3.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.DepositFunds(-13.37);
        wantedRes = 3.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.AccountStatus();
        wantedRes = 3.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.WithdrawFunds(13.37);
        wantedRes = 3.37;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.AccountStatus();
        wantedRes = 3.37;
        Assert.assertTrue(res.equals(wantedRes));
    }

    @Test
    public void ZZ2() {
        IAccount account = new Account();
        Assert.assertTrue(account.AccountStatus() == 0);
        Assert.assertTrue(account.DepositFunds(13.378) == 13.38);
        Assert.assertTrue(account.DepositFunds(1.999999999) == 15.38);
        Assert.assertTrue(account.WithdrawFunds(3.55) == 11.83);
        Assert.assertTrue(account.AccountStatus() == 11.83);

        IAccount account1 = new Account();
        Double res = account1.AccountStatus();
        Double wantedRes = 0.0;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.DepositFunds(13.378);
        wantedRes = 13.38;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.DepositFunds(1.999999999);
        wantedRes = 15.38;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.WithdrawFunds(3.55);
        wantedRes = 11.83;
        Assert.assertTrue(res.equals(wantedRes));

        res = account1.AccountStatus();
        wantedRes = 11.83;
        Assert.assertTrue(res.equals(wantedRes));
    }
}