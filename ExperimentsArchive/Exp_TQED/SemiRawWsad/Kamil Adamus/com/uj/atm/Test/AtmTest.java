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
    public void checkPinAndLogInD() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);
    }

    @Test
    public void checkPinAndLogInD1() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "") == false);
    }

    @Test
    public void checkPinAndLogInD2() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "    ") == false);
    }

    @Test
    public void checkPinAndLogInD3() {
        IAtm atm = new Atm();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "4a42") == false);
    }

    @Test
    public void checkPinAndLogInDZ() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.ChangePin("0000", "1337", "1337") == true);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "1337") == true);
    }

    @Test
    public void checkPinAndLogInDZ1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.ChangePin("0000", "abcd", "abcd") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "abcd") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);
    }

    ///

    @Test
    public void accountStatusD() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void accountStatusD1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void accountStatusZZ() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
        Assert.assertTrue(account.DepositFunds(13.378) == 13.38);
        Assert.assertTrue(atm.AccountStatus(account) == 13.38);
    }

    @Test
    public void accountStatusZZ1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
        Assert.assertTrue(account.DepositFunds(13.378) == 13.38);
        Assert.assertTrue(atm.AccountStatus(account) == 13.38);
        Assert.assertTrue(account.WithdrawFunds(13.378) == 0.0);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    ///

    @Test
    public void changePinCardDZ() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "1234", "1234") == true);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "1234") == true);
    }

    @Test
    public void changePinCardDZ1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "eeeeeeee", "eeeeeeee") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "eeeeeeee") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);
    }

    @Test
    public void changePinCardDZ2() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "", "") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);
    }

    @Test
    public void changePinCardDZ3() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "    ", "    ") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "    ") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);
    }

    @Test
    public void changePinCardDZ4() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "9999", "3123") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "0000") == true);
    }

    @Test
    public void changePinCardZZ() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "9999", "9999") == true);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "9999") == true);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "9999", "8888", "8888") == true);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "8888") == true);
    }

    @Test
    public void changePinCardZZ1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "0000", "1234", "1234") == true);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "1234") == true);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "9999", "5555", "5555") == false);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "5555") == false);
        Assert.assertTrue(atm.ChangePinCard(creditCard, "1234", "5555", "5555") == true);
        Assert.assertTrue(atm.CheckPinAndLogIn(creditCard, "5555") == true);
    }

    ///

    @Test
    public void depositFundsD() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 5555) == true);
        Assert.assertTrue(atm.AccountStatus(account) == account.AccountStatus());
    }

    @Test
    public void depositFundsD1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 5.555) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 5.55);
        Assert.assertTrue(atm.AccountStatus(account) == account.AccountStatus());
    }

    @Test
    public void depositFundsD2() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, -50) == false);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void depositFundsDI() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.DepositFunds(creditCard, 5.555) == false);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void depositFundsDI1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        IAccount account1 = new Account();
        creditCard.AddAccount(account1);
        Assert.assertTrue(atm.DepositFunds(creditCard, 5.555) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 5.55);
        Assert.assertTrue(atm.AccountStatus(account1) == 0.0);
    }

    @Test
    public void depositFundsZI() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 10) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 10.0);
        Assert.assertTrue(atm.DepositFunds(creditCard, 10) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 20.0);
        Assert.assertTrue(atm.DepositFunds(creditCard, 1) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 21.0);
    }

    ///

    @Test
    public void withdrawFundsD() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 10) == false);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void withdrawFundsD1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, -10) == false);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void withdrawFundsD2() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 10.75) == false);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void withdrawFundsDI() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 5.555) == false);
    }

    @Test
    public void withdrawFundsZI() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 10) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 10.0);
        Assert.assertTrue(atm.DepositFunds(creditCard, 10) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 20.0);
        Assert.assertTrue(atm.DepositFunds(creditCard, 1) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 21.0);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 5) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 16.0);
    }

    @Test
    public void withdrawFundsZI1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 10) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 10.0);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 5) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 5.0);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 2) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 3.0);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 1) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 2.0);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 1) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 1.0);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 1) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 0.0);
    }

    @Test
    public void withdrawFundsZI2() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.DepositFunds(creditCard, 10) == true);
        Assert.assertTrue(atm.AccountStatus(account) == 10.0);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 50) == false);
        Assert.assertTrue(atm.AccountStatus(account) == 10.0);
    }

    ///

    @Test
    public void transferD() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.Transfer(creditCard, account, 1) == false);
    }

    @Test
    public void transferD1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        Assert.assertTrue(atm.Transfer(creditCard, account, 0) == false);
    }

    @Test
    public void transferDZ() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.Transfer(creditCard, account, 0) == false);
    }

    @Test
    public void transferDZ1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(500) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account, 10) == true);
        Assert.assertTrue(account.AccountStatus() == 500);
    }

    @Test
    public void transferZZ() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        IAccount account1 = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(500) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account1, 10) == true);
        Assert.assertTrue(account.AccountStatus() == 490);
        Assert.assertTrue(account1.AccountStatus() == 10);
    }

    @Test
    public void transferZZ1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        IAccount account1 = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(500) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account1, 5060.55) == false);
        Assert.assertTrue(account.AccountStatus() == 500);
        Assert.assertTrue(account1.AccountStatus() == 0.0);
    }

    @Test
    public void transferZI() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        IAccount account1 = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(500) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account1, 100) == true);
        Assert.assertTrue(account.AccountStatus() == 400);
        Assert.assertTrue(account1.AccountStatus() == 100);
        Assert.assertTrue(creditCard.WithdrawFunds(400) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account1, 100) == false);
    }

    @Test
    public void transferZI1() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        IAccount account1 = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account1, 100) == true);
        Assert.assertTrue(account.AccountStatus() == 0.0);
        Assert.assertTrue(account1.AccountStatus() == 100);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account1, 100) == true);
        Assert.assertTrue(account.AccountStatus() == 300);
        Assert.assertTrue(account1.AccountStatus() == 200);
    }

    @Test
    public void transferZI2() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        IAccount account1 = new Account();
        IAccount account2 = new Account();
        ICreditCard creditCard = new CreditCard();
        creditCard.AddAccount(account);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account1, 100) == true);
        Assert.assertTrue(account.AccountStatus() == 0);
        Assert.assertTrue(account1.AccountStatus() == 100);
        Assert.assertTrue(account2.AccountStatus() == 0);
        Assert.assertTrue(creditCard.DepositFunds(1000) == true);
        Assert.assertTrue(atm.Transfer(creditCard, account2, 500) == true);
        Assert.assertTrue(account.AccountStatus() == 500);
        Assert.assertTrue(account1.AccountStatus() == 100);
        Assert.assertTrue(account2.AccountStatus() == 500);
    }

    @Test
    public void transferZI3() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        IAccount account1 = new Account();
        IAccount account2 = new Account();
        ICreditCard creditCard = new CreditCard();
        ICreditCard creditCard1 = new CreditCard();
        ICreditCard creditCard2 = new CreditCard();
        creditCard.AddAccount(account);
        creditCard1.AddAccount(account1);
        creditCard2.AddAccount(account2);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(atm.Transfer(creditCard2, account1, 100) == false);
        Assert.assertTrue(account.AccountStatus() == 100);
        Assert.assertTrue(account1.AccountStatus() == 0);
        Assert.assertTrue(account2.AccountStatus() == 0);
    }

    @Test
    public void transferZI4() {
        IAtm atm = new Atm();
        IAccount account = new Account();
        IAccount account1 = new Account();
        IAccount account2 = new Account();
        ICreditCard creditCard = new CreditCard();
        ICreditCard creditCard1 = new CreditCard();
        ICreditCard creditCard2 = new CreditCard();
        creditCard.AddAccount(account);
        creditCard1.AddAccount(account1);
        creditCard2.AddAccount(account2);
        Assert.assertTrue(creditCard.DepositFunds(100) == true);
        Assert.assertTrue(creditCard1.DepositFunds(500) == true);
        Assert.assertTrue(creditCard2.DepositFunds(0.05) == true);
        Assert.assertTrue(atm.Transfer(creditCard2, account1, 0.05) == true);
        Assert.assertTrue(account.AccountStatus() == 100);
        Assert.assertTrue(account1.AccountStatus() == 500.05);
        Assert.assertTrue(account2.AccountStatus() == 0);
    }
}