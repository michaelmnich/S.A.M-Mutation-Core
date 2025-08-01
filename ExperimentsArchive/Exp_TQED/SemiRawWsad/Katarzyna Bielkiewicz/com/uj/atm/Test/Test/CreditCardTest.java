package Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class CreditCardTest {

    private ICreditCard testCreditCard = new CreditCard();
    IAccount account1 = new Account();

    @Test
    public void changePin_correctPin() {
        Assert.assertEquals(true, testCreditCard.ChangePin("0000", "1234", "1234"));
    }

    @Test
    public void changePin_wrongOldPin() {
        testCreditCard.ChangePin("0000","9823","9823");
        Assert.assertEquals(false, testCreditCard.ChangePin("0000","6578","6578"));
    }
    @Test
    public void changePin_wrongNewPinConfirm() {
        Assert.assertEquals(false, testCreditCard.ChangePin("0000","6578","6579"));

    }
    @Test
    public void changePin_oldPin_sameAs_newPin() {
        Assert.assertEquals(false, testCreditCard.ChangePin("0000","0000","0000"));

    }

    @Test
    public void changePin_letters_insteadof_numbers() {
        Assert.assertEquals(false, testCreditCard.ChangePin("0000","abcd","abcd"));

    }

    @Test
    public void changePin_toShort_newPin() {
        Assert.assertEquals(false, testCreditCard.ChangePin("0000","678","678"));

    }

    @Test
    public void changePin_toLong_newPin() {
        Assert.assertEquals(false, testCreditCard.ChangePin("0000","67800","67800"));

    }



    @Test
    public void isPinValid_correctPin() {
        Assert.assertEquals(true, testCreditCard.IsPinValid("0000"));

    }

    @Test
    public void isPinValid_wrongPin() {

        Assert.assertEquals(false, testCreditCard.IsPinValid("0009"));
    }



    @Test
    public void addAccount_2Account_to_1Card() {
        IAccount account2 = new Account();
        testCreditCard.AddAccount(account1);
        Assert.assertThrows(Exception.class,() -> testCreditCard.AddAccount(account2));
    }

    @Test
    public void depositFunds() {
        testCreditCard.AddAccount(account1);
        Assert.assertEquals(true, testCreditCard.DepositFunds(3898));

    }
    @Test
    public void depositFunds_negativeAmount() {
        testCreditCard.AddAccount(account1);
        Assert.assertEquals(false, testCreditCard.DepositFunds(-100));
    }

    @Test
    public void depositFunds_amount0() {
        testCreditCard.AddAccount(account1);
        Assert.assertEquals(false, testCreditCard.DepositFunds(0));
    }

    @Test
    public void depositFunds_accountNull() {

        Assert.assertEquals(false, testCreditCard.DepositFunds(40));
    }



    @Test
    public void withdrawFunds() {
        testCreditCard.AddAccount(account1);
        testCreditCard.DepositFunds(3000);
        Assert.assertEquals(true, testCreditCard.WithdrawFunds(3000));
    }

    @Test
    public void withdrawFunds_negativeAmount() {
        testCreditCard.AddAccount(account1);
        testCreditCard.DepositFunds(6789);
        Assert.assertEquals(false, testCreditCard.WithdrawFunds(-100));
    }

    @Test
    public void withdrawFunds_AccountStatus_lessThan_amount() {
        testCreditCard.AddAccount(account1);
        testCreditCard.DepositFunds(90);
        Assert.assertEquals(false, testCreditCard.WithdrawFunds(250));
    }

    @Test
    public void withdrawFunds_amount0() {
        testCreditCard.AddAccount(account1);
        testCreditCard.DepositFunds(900);
        Assert.assertEquals(false, testCreditCard.WithdrawFunds(0));
    }







}