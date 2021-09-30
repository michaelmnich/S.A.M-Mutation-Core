import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.IAccount;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void changePin() {
        CreditCard card = new CreditCard();

        //Is function working at all
        assert (card.ChangePin("0000", "1111", "1111"));

        //Is working with wrong old pin
        assertFalse (card.ChangePin("0000", "0101", "0101"));

        //Is working with wrong confirmation pin
        assertFalse (card.ChangePin("1111", "1234", "1243"));

        //Letters in newPin
        assertFalse (card.ChangePin("1111", "abcd", "abcd"));

        //Too long new pin
        assertFalse (card.ChangePin("1111", "00000", "00000"));

        //Characters in new pin
        assertFalse (card.ChangePin("1111", ".,;s", ".,;s"));

        //Confirmation pass have same first 4 numbers but is longer than new pin
        assertFalse (card.ChangePin("1111", "0101", "010100"));

        //New pin have more than 4 numbers but confirmation have 4
        assertFalse (card.ChangePin("1111", "01010", "0101"));

        //Is changing still working after all those commands
        assert (card.ChangePin("1111", "0000", "0000"));

        //Checks for empty strings
        String emptyString = "";
        assertFalse (card.ChangePin("0000", emptyString, "1111"));
        assertFalse (card.ChangePin("0000", "1111", emptyString));
        assertFalse (card.ChangePin(emptyString, "1111", "1111"));
    }

    @Test
    public void isPinValid() {
        CreditCard card = new CreditCard();

        //Wrong PIN numbers
        assertFalse (card.IsPinValid("1000"));

        //Right PIN numbers
        assert (card.IsPinValid("0000"));

        //Letter inside PIN
        assertFalse (card.IsPinValid("000s"));

        //Is pin valid after changing it
        card.ChangePin("0000", "0101", "0101");
        assert (card.IsPinValid("0101"));

        //Can you cheat and write right pin with more characters
        assertFalse (card.IsPinValid("0101a2d"));
    }

    @Test
    public void addAccount() {
        CreditCard card = new CreditCard();
        Account account = new Account();
        card.AddAccount(account);

        //Is linked acc same that created acc
        assert (card.linkedAcc == account);

        Account account2 = new Account();
        card.AddAccount(account2);

        //Does linked acc change after adding second acc
        assert (card.linkedAcc == account);
    }

    @Test
    public void depositFunds() {
        CreditCard card = new CreditCard();
        Account account = new Account();

        //Con you deposit funds without linked acc
        assertFalse (card.DepositFunds(100));

        //Con you deposit funds without linked acc
        card.AddAccount(account);
        assert (card.DepositFunds(100));
    }

    @Test
    public void withdrawFunds() {
        CreditCard card = new CreditCard();
        Account account = new Account();

        //Con you deposit funds without linked acc
        assertFalse (card.WithdrawFunds(100));

        //Con you deposit funds without linked acc
        card.AddAccount(account);
        assert (card.WithdrawFunds(100));
    }
}