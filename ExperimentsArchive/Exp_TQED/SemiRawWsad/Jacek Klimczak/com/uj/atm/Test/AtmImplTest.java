package com.uj.atm.Test;

import com.uj.atm.common.AccountImpl;
import com.uj.atm.common.AtmImpl;
import com.uj.atm.common.CreditCardImpl;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmImplTest {

    AtmImpl atm;
    ICreditCard creditCard;
    IAccount account;

    @Before
    public void setUp() throws Exception {
        atm = new AtmImpl();
        creditCard = new CreditCardImpl();
        account = new AccountImpl();
    }

    @Test
    public void ShouldLoginToAccount()
    {
        //Given
        String pin = "1234";
        creditCard.ChangePin("0000", pin, pin);

        //When
        boolean isLogged = atm.CheckPinAndLogIn(creditCard, pin);

        //Then
        assertTrue(isLogged);
    }

    @Test
    public void ShouldNotLoginToAccountIfWrongPin()
    {
        //Given
        String pin = "1234";
        String pinNull = null;

        //When
        boolean isLogged = atm.CheckPinAndLogIn(creditCard, pin);
        boolean isLoggedNull = atm.CheckPinAndLogIn(creditCard, pinNull);

        //Then
        assertFalse(isLogged);
        assertFalse(isLoggedNull);
    }

    @Test
    public void ShouldNotLoginToAccountIfCreditCardIsNull()
    {
        //Given
        String pin = "0000";
        creditCard = null;

        //When
        boolean isLogged = atm.CheckPinAndLogIn(creditCard, pin);

        //Then
        assertFalse(isLogged);
    }

    @Test
    public void ShouldReturnAccountStatus()
    {
        //Given
        double initialBalance = 123;
        account.DepositFunds(initialBalance);

        //When
        double balance = atm.AccountStatus(account);

        //Then
        assertEquals(initialBalance, balance, 0.1);
    }

    @Test
    public void ShouldReturnZeroIfAccountIsNull()
    {
        //Given
        //When
        double balance = atm.AccountStatus(null);

        //Then
        assertEquals(0.0, balance, 0.1);
    }

    @Test
    public void ShouldChangePinAndLoginUsingNewPin()
    {
        //Given
        String oldPin = "0000";
        String newPin = "1234";

        //When
        boolean isPinChanged = atm.ChangePinCard(creditCard, oldPin, newPin, newPin);
        boolean isLogged = atm.CheckPinAndLogIn(creditCard, newPin);

        //Then
        assertTrue(isPinChanged);
        assertTrue(isLogged);
    }

    @Test
    public void ShouldNotChangePinAndLoginUsingOldPin()
    {
        //Given
        String oldPin = "0000";
        String newPin = "12A3";

        //When
        boolean isPinChanged = atm.ChangePinCard(creditCard, oldPin, newPin, newPin);
        boolean isLogged = atm.CheckPinAndLogIn(creditCard, oldPin);

        //Then
        assertFalse(isPinChanged);
        assertTrue(isLogged);
    }

    @Test
    public void ShouldNotChangePinIfCreditCardIsNull()
    {
        //Given
        String oldPin = "0000";
        String newPin = "12A3";

        //When
        boolean isPinChanged = atm.ChangePinCard(null, oldPin, newPin, newPin);

        //Then
        assertFalse(isPinChanged);
    }

    @Test
    public void ShouldDepositFunds()
    {
        //Given
        double amount = 12.12;
        creditCard.AddAccount(account);

        //When
        boolean isDeposited = atm.DepositFunds(creditCard, amount);

        //Then
        assertTrue(isDeposited);
        assertEquals(amount, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldNotDepositFundsIfCreditCardIsNull()
    {
        //Given
        double amount = 12.12;
        creditCard.AddAccount(account);

        //When
        boolean isDeposited = atm.DepositFunds(null, amount);

        //Then
        assertFalse(isDeposited);
        assertEquals(0.0, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldNotDepositFundsIfAmountIsLessThanZero()
    {
        //Given
        double amount = -12.12;
        creditCard.AddAccount(account);

        //When
        boolean isDeposited = atm.DepositFunds(creditCard, amount);

        //Then
        assertFalse(isDeposited);
        assertEquals(0.0, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldWithdrawFunds()
    {
        //Given
        double initialBalance = 12.12;
        creditCard.AddAccount(account);
        atm.DepositFunds(creditCard, initialBalance);

        double amount = 10;

        //When
        boolean isWithdrawn = atm.WithdrawFunds(creditCard, amount);

        //Then
        assertTrue(isWithdrawn);
        assertEquals(initialBalance - amount, account.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldTransferAmountToRecipient()
    {
        //Given
        double initialBalance = 100;
        creditCard.AddAccount(account);
        atm.DepositFunds(creditCard, initialBalance);

        IAccount recipient = new AccountImpl();
        double amount = 10;

        //When
        boolean isAmountTransferred = atm.Transfer(creditCard, recipient, amount);

        //Then
        assertTrue(isAmountTransferred);
        assertEquals(initialBalance - amount, account.AccountStatus(), 0.1);
        assertEquals(amount, recipient.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldNotTransferAmountToRecipientIfCardOrAccountIsNull()
    {
        //Given
        double initialBalance = 100;
        creditCard.AddAccount(account);
        atm.DepositFunds(creditCard, initialBalance);

        IAccount recipient = new AccountImpl();
        double amount = 10;

        //When
        boolean isAmountTransferredCardNull = atm.Transfer(null, recipient, amount);
        boolean isAmountTransferredRecipientNull = atm.Transfer(creditCard, null, amount);

        //Then
        assertFalse(isAmountTransferredCardNull);
        assertFalse(isAmountTransferredRecipientNull);
        assertEquals(initialBalance, account.AccountStatus(), 0.1);
        assertEquals(0.0, recipient.AccountStatus(), 0.1);
    }

    @Test
    public void ShouldNotTransferAmountToRecipientIfAmountIsLessThanZero()
    {
        //Given
        double initialBalance = 100;
        creditCard.AddAccount(account);
        atm.DepositFunds(creditCard, initialBalance);

        IAccount recipient = new AccountImpl();
        double amount = -10;

        //When
        boolean isAmountTransferred = atm.Transfer(null, recipient, amount);

        //Then
        assertFalse(isAmountTransferred);
        assertEquals(initialBalance, account.AccountStatus(), 0.1);
        assertEquals(0.0, recipient.AccountStatus(), 0.1);
    }
}