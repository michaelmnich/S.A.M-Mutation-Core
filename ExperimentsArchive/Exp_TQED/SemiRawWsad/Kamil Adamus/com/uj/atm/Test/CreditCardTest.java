import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePinD() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "1234", "1234") == true);
    }

    @Test
    public void changePinD1() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "temp", "temp") == false);
    }

    @Test
    public void changePinD2() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "    ", "    ") == false);
    }

    @Test
    public void changePinD3() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "123456", "123456") == false);
    }

    @Test
    public void changePinDD() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "123456", "6") == false);
    }

    @Test
    public void changePinDD1() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "0 0 0 0", "0000") == false);
    }

    @Test
    public void changePinDD2() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "0000", "0000") == true);
    }

    @Test
    public void changePinDI() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "123456", "123456") == false);
    }

    @Test
    public void changePinDI1() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.ChangePin("0000", "", "") == false);
    }

    ///

    @Test
    public void isPinValidD() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid("0000") == true);
    }

    @Test
    public void isPinValidD1() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid(String.valueOf(0000)) == false);
    }

    @Test
    public void isPinValidD2() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid("null") == false);
    }

    @Test
    public void isPinValidD3() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid("9821121312131221312312") == false);
    }

    @Test
    public void isPinValidD4() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid("0") == false);
    }

    @Test
    public void isPinValidD5() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid("") == false);
    }

    @Test
    public void isPinValidD6() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.IsPinValid(" ") == false);
    }

    ///

    @Test
    public void depositFundsD() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(500) == true);
        Assert.assertTrue(account.AccountStatus() == 500.0);
    }

    @Test
    public void depositFundsD1() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(-500) == false);
        Assert.assertTrue(account.AccountStatus() == 0.0);
    }

    @Test
    public void depositFundsD2() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(0) == false);
        Assert.assertTrue(account.AccountStatus() == 0.0);
    }

    @Test
    public void depositFundsD3() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(199.981478) == true);
        Assert.assertTrue(account.AccountStatus() == 199.98);
    }

    @Test
    public void depositFundsD4() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(75577.981478) == true);
        Assert.assertTrue(account.AccountStatus() == 75577.98);
    }

    @Test
    public void depositFundsDZ() {
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.DepositFunds(75577.981478) == false);
    }

    ///

    @Test
    public void withdrawFundsD() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.WithdrawFunds(75577.981478) == false);
        Assert.assertTrue(account.AccountStatus() == 0.0);
    }

    @Test
    public void withdrawFundsD1() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.WithdrawFunds(0) == false);
        Assert.assertTrue(account.AccountStatus() == 0.0);
    }

    @Test
    public void withdrawFundsD2() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.WithdrawFunds(04.23) == false);
        Assert.assertTrue(account.AccountStatus() == 0.0);
    }

    @Test
    public void withdrawFundsDZ() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.WithdrawFunds(75577.981478) == false);
        Assert.assertTrue(account.AccountStatus() == 0.0);
    }

    ///

    @Test
    public void ZZ() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(creditCard.DepositFunds(75577.981478) == false);
        creditCard.AddAccount(account);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.WithdrawFunds(75577.981478) == false);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.DepositFunds(75577.981478) == true);
        Assert.assertTrue(account.AccountStatus() == 75577.98);
        Assert.assertTrue(creditCard.WithdrawFunds(10000000) == false);
        Assert.assertTrue(account.AccountStatus() == 75577.98);
        Assert.assertTrue(creditCard.WithdrawFunds(0.00001) == true);
        Assert.assertTrue(account.AccountStatus() == 75577.98);
        Assert.assertTrue(creditCard.WithdrawFunds(0.10) == true);
        Assert.assertTrue(account.AccountStatus() == 75577.88);
    }

    @Test
    public void ZZ1() {
        IAccount account = new Account();
        IAccount account1 = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.DepositFunds(75577.981478) == true);
        Assert.assertTrue(account.AccountStatus() == 75577.98);
        creditCard.AddAccount(account1);
        Assert.assertTrue(account.AccountStatus() == 75577.98);
        Assert.assertTrue(account1.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.DepositFunds(1.99) == true);
        Assert.assertTrue(account.AccountStatus() == 75579.97);
        Assert.assertTrue(account1.AccountStatus() == 0.0);
    }

    @Test
    public void ZZ2() {
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.DepositFunds(0.01) == true);
        Assert.assertTrue(account.AccountStatus() == 0.01);
        Assert.assertTrue(creditCard.WithdrawFunds(1.99) == false);
        Assert.assertTrue(account.AccountStatus() == 0.01);
    }

    @Test
    public void ZZ3() {
        IAccount account = new Account();
        IAccount account1 = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.DepositFunds(7.47) == true);
        Assert.assertTrue(account.AccountStatus() == 7.47);
        creditCard.AddAccount(account1);
        Assert.assertTrue(account.AccountStatus() == 7.47);
        Assert.assertTrue(account1.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.DepositFunds(1.99) == true);
        Assert.assertTrue(account.AccountStatus() == 9.46);
        Assert.assertTrue(account1.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.WithdrawFunds(10.0) == false);
        Assert.assertTrue(account.AccountStatus() == 9.46);
        Assert.assertTrue(account1.AccountStatus() == 0.0);
        Assert.assertTrue(creditCard.WithdrawFunds(9.46) == true);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Assert.assertTrue(account1.AccountStatus() == 0.0);
    }
}