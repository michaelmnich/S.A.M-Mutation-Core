package Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class AtmTest {

    private boolean testlog;
    private IAtm testAtm = new Atm(testlog);
    ICreditCard testAtmCard = new CreditCard();
    IAccount testAtmAccount = new Account();



    @Test
    public void checkPinAndLogIn_correctPin() {
        Assert.assertEquals(true,testAtm.CheckPinAndLogIn(testAtmCard,"0000"));
    }

    @Test
    public void checkPinAndLogIn_wrongPin() {
        Assert.assertEquals(false, testAtm.CheckPinAndLogIn(testAtmCard, "2222"));
    }


    @Test
    public void accountStatus() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        Assert.assertTrue(testAtm.AccountStatus(testAtmAccount) == 0.0);

    }

    @Test
    public void accountStatus_after_DepositFunds() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,100.89);
        Assert.assertTrue(testAtm.AccountStatus(testAtmAccount) == 100.89);

    }

    @Test
    public void accountStatus_after_DepositFunds_and_withdrawFunds() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,100);
        testAtm.WithdrawFunds(testAtmCard,99);
        Assert.assertTrue(testAtm.AccountStatus(testAtmAccount) == 1);

    }

    @Test
    public void accountStatus_notLogged() {
        testAtmCard.AddAccount(testAtmAccount);
        Assert.assertThrows(Exception.class,() -> testAtm.AccountStatus(testAtmAccount));

    }

    @Test
    public void accountStatus_wrongAccount() {
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        Assert.assertThrows(Exception.class,() -> testAtm.AccountStatus(testAtmAccount));
    }


    @Test
    public void changePinCard() {
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        Assert.assertTrue(testAtm.ChangePinCard(testAtmCard,"0000","1234","1234"));
    }

    @Test
    public void changePinCard_notLogged() {
        Assert.assertFalse(testAtm.ChangePinCard(testAtmCard, "0000", "1234", "1234"));
    }



    @Test
    public void depositFunds() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        Assert.assertTrue(testAtm.DepositFunds(testAtmCard,50));
    }

    @Test
    public void depositFunds_notLogged() {
        testAtmCard.AddAccount(testAtmAccount);
        Assert.assertFalse(testAtm.DepositFunds(testAtmCard,50));
    }

    @Test
    public void depositFunds_accountNull() {
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        Assert.assertFalse(testAtm.DepositFunds(testAtmCard,9));
    }

    @Test
    public void depositFunds_negativeAmount() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        Assert.assertFalse(testAtm.DepositFunds(testAtmCard,-76));
    }

    @Test
    public void depositFunds_amount0() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        Assert.assertFalse(testAtm.DepositFunds(testAtmCard,0));
    }


    @Test
    public void withdrawFunds() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,999);
        Assert.assertTrue(testAtm.WithdrawFunds(testAtmCard,999));
        Assert.assertTrue(testAtm.AccountStatus(testAtmAccount) == 0);

    }

    @Test
    public void withdrawFunds_negativeAmount() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,50);
        Assert.assertFalse(testAtm.WithdrawFunds(testAtmCard,-25));
    }

    @Test
    public void withdrawFunds_notLogged() {
        Assert.assertFalse(testAtm.WithdrawFunds(testAtmCard,25));
    }

    @Test
    public void withdrawFunds_AccountStatus_lessThan_amount() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,6);
        Assert.assertFalse(testAtm.WithdrawFunds(testAtmCard,47));
    }

    @Test
    public void withdrawFunds_amount0() {
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,13);
        Assert.assertFalse(testAtm.WithdrawFunds(testAtmCard,0));
    }


    @Test
    public void transfer() {
        IAccount testRecipient = new Account();
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,50);
        Assert.assertTrue(testAtm.Transfer(testAtmCard,testRecipient,2));
        assertEquals(48.0,testAtm.AccountStatus(testAtmAccount));
        assertEquals(2.0,testRecipient.AccountStatus());

    }

    @Test
    public void transfer_all() {
        IAccount testRecipient = new Account();
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,5000);
        Assert.assertTrue(testAtm.Transfer(testAtmCard,testRecipient,5000));
        assertEquals(0.0,testAtm.AccountStatus(testAtmAccount));
        assertEquals(5000.0,testRecipient.AccountStatus());

    }

    @Test
    public void transfer_AccountStatus_lessThan_amount() {
        IAccount testRecipient = new Account();
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,1234);
        Assert.assertFalse(testAtm.Transfer(testAtmCard,testRecipient,2888));
    }

    @Test
    public void transfer_negativeAmount() {
        IAccount testRecipient = new Account();
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,1234);
        Assert.assertFalse(testAtm.Transfer(testAtmCard,testRecipient,-78));

    }

    @Test
    public void transfer_to_yourself() {
        IAccount testRecipient = new Account();
        testAtmCard.AddAccount(testAtmAccount);
        testAtm.CheckPinAndLogIn(testAtmCard,"0000");
        testAtm.DepositFunds(testAtmCard,678);
        Assert.assertFalse(testAtm.Transfer(testAtmCard,testAtmAccount,78));
    }






}