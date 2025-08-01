import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmTest {

    @Test
    public void checkPinAndLogIn() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();

        //Test for right value
        assert (atm.CheckPinAndLogIn(card, "0000"));

        //Test for wrong values
        assertFalse (atm.CheckPinAndLogIn(card, "1111"));


        //Right PIN numbers
        assert (atm.CheckPinAndLogIn(card, "0000"));

        //Letter inside PIN
        assertFalse (atm.CheckPinAndLogIn(card, "000s"));

        //Is pin valid after changing it
        card.ChangePin("0000", "0101", "0101");
        assert (atm.CheckPinAndLogIn(card, "0101"));

        //Can you cheat and write right pin with more characters
        assertFalse (atm.CheckPinAndLogIn(card, "0101a2d"));
    }

    @Test
    public void accountStatus() {
        Atm atm = new Atm();
        Account account = new Account();
        CreditCard card = new CreditCard();

        account.DepositFunds(100);

        //Can show status without logging in
        assert (atm.AccountStatus(account) == 0.0);

        //Can show status with logging in
        atm.CheckPinAndLogIn(card, "0000");
        assert (atm.AccountStatus(account) == 100.0);

        account.DepositFunds(10);

        //Is account status correct after deposit funds
        assert (atm.AccountStatus(account) == 110);

        account.WithdrawFunds(10);

        //Is account status correct after withdraw funds
        assert (atm.AccountStatus(account) == 100);
    }

    @Test
    public void changePinCard() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();

        //Can change ping without logging in
        assertFalse (atm.ChangePinCard(card, "0000", "1111", "1111"));

        //Can change ping with logging in
        atm.CheckPinAndLogIn(card, "0000");
        assert (atm.ChangePinCard(card, "0000", "1111", "1111"));
        assert (atm.ChangePinCard(card, "1111", "0000", "0000"));


        //Is function working at all
        assert (atm.ChangePinCard(card,"0000", "1111", "1111"));

        //Is working with wrong old pin
        assertFalse (atm.ChangePinCard(card,"0000", "0101", "0101"));

        //Is working with wrong confirmation pin
        assertFalse (atm.ChangePinCard(card,"1111", "1234", "1243"));

        //Letters in newPin
        assertFalse (atm.ChangePinCard(card,"1111", "abcd", "abcd"));

        //Too long new pin
        assertFalse (atm.ChangePinCard(card,"1111", "00000", "00000"));

        //Characters in new pin
        assertFalse (atm.ChangePinCard(card,"1111", ".,;s", ".,;s"));

        //Confirmation pass have same first 4 numbers but is longer than new pin
        assertFalse (atm.ChangePinCard(card,"1111", "0101", "010100"));

        //New pin have more than 4 numbers but confirmation have 4
        assertFalse (atm.ChangePinCard(card,"1111", "01010", "0101"));

        //Is changing still working after all those commands
        assert (atm.ChangePinCard(card,"1111", "0000", "0000"));

        //Checks for empty strings
        String emptyString = "";
        assertFalse (atm.ChangePinCard(card,"0000", emptyString, "1111"));
        assertFalse (atm.ChangePinCard(card,"0000", "1111", emptyString));
        assertFalse (atm.ChangePinCard(card, emptyString, "1111", "1111"));
    }

    @Test
    public void depositFunds() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();
        Account account =  new Account();
        card.AddAccount(account);

        //Can deposit funds without logging in
        assertFalse (atm.DepositFunds(card, 100));

        //Can deposit funds with logging in
        atm.CheckPinAndLogIn(card, "0000");
        assert (atm.DepositFunds(card, 100));
    }

    @Test
    public void withdrawFunds() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();
        Account account =  new Account();
        card.AddAccount(account);

        //Can withdraw funds without logging in
        assertFalse (atm.WithdrawFunds(card, 100));

        //Can withdraw funds with logging in
        atm.CheckPinAndLogIn(card, "0000");
        assert (atm.WithdrawFunds(card, 100));
    }

    @Test
    public void transfer() {
        Atm atm = new Atm();
        CreditCard card = new CreditCard();
        Account account =  new Account();
        Account accountRecipient =  new Account();
        card.AddAccount(account);

        //Can withdraw funds without logging in
        assertFalse (atm.Transfer(card, accountRecipient, 100));

        //Can withdraw funds with logging in
        atm.CheckPinAndLogIn(card, "0000");
        assert (atm.Transfer(card, accountRecipient, 100));
    }
}