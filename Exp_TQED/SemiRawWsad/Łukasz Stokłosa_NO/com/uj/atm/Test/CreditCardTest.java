import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreditCardTest {
    CreditCard card;
    Account ac1;

    @Before
    public void setCard() {
        card = new CreditCard("0000");
    }

    @Before
    public void setAccount() {
        ac1 = new Account(100);
    }

    @Test
    public void testChangePinSucces() {
        assertFalse(card.ChangePin("0000", "1234", "0000"));
    }

    @Test
    public void testChangePinNegative() {
        assertTrue(card.ChangePin("0000", "0000", "0000"));
    }

    @Test
    public void testIsPinValidSucces() {
        assertTrue(card.IsPinValid("0000"));
    }

    @Test
    public void testIsPinValidNegative() {

        assertFalse(card.IsPinValid("1234"));
        assertFalse(card.IsPinValid("asdf"));
        assertFalse(card.IsPinValid("asd"));
    }

    @Test
    public void testAddAccountSucces() {
        card.AddAccount(ac1);
        Assert.assertFalse(String.valueOf(ac1), ac1 == null);

    }

    @Test
    public void testAddAccountNegative() {
        card.AddAccount(ac1);
        Assert.assertFalse(String.valueOf(ac1), ac1 == null);

    }

    @Test
    public void DepositFundsSucces() {
        card.DepositFunds(50);
        //Account ac2= new Account(100);
        card.AddAccount(ac1);
        //card.AddAccount(ac2);
        assertTrue(card.DepositFunds(10));
    }


    @Test
    public void DepositFundsNegative() {
        card.AddAccount(ac1);
        assertFalse(card.DepositFunds(-40));
    }

    @Test
    public void WithdrawFundsSucces() {
        ac1 = new Account(100);
        card.AddAccount(ac1);
        assertTrue(card.WithdrawFunds(50));


    }


    @Test
    public void WithdrawFundsNegative() {
        ac1 = new Account(100);
        card.AddAccount(ac1);
        assertFalse(card.WithdrawFunds(450));
    }

}


  
   



