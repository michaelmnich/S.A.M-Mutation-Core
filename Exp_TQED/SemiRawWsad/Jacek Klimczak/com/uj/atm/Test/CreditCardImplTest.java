package com.uj.atm.Test;

import com.uj.atm.common.AccountImpl;
import com.uj.atm.common.CreditCardImpl;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardImplTest {

    CreditCardImpl creditCard;
    IAccount account;
    String oldPin = "0000";

    @Before
    public void setUp() throws Exception {
        creditCard = new CreditCardImpl();
        account = new AccountImpl();
        creditCard.AddAccount(account);
    }

    @Test
    public void ShouldChangePinIfNewPinIsValid()
    {
        //Given
        String newPin = "1234";

        //When
        boolean isPinChanged = creditCard.ChangePin(oldPin, newPin, newPin);

        //Then
        assertTrue(isPinChanged);
    }

    @Test
    public void ShouldNotChangePinIfNewPinIsNotNumeric()
    {
        //Given
        String newPin = "12ABC";

        //When
        boolean isPinChanged = creditCard.ChangePin(oldPin, newPin, newPin);

        //Then
        assertFalse(isPinChanged);
    }

    @Test
    public void ShouldNotChangePinIfNewPinIsNotSameAsConfirmed()
    {
        //Given
        String newPin = "1234";
        String newPinConfirm = "4321";

        //When
        boolean isPinChanged = creditCard.ChangePin(oldPin, newPin, newPinConfirm);

        //Then
        assertFalse(isPinChanged);
    }

    @Test
    public void ShouldNotChangePinIfNewPinIsGraterOrLessThanFour()
    {
        //Given
        String newPinGrater = "12345";
        String newPinLess = "123";

        //When
        boolean isPinChangedGrater = creditCard.ChangePin(oldPin, newPinGrater, newPinGrater);
        boolean isPinChangedLess = creditCard.ChangePin(oldPin, newPinLess, newPinLess);

        //Then
        assertFalse(isPinChangedGrater);
        assertFalse(isPinChangedLess);
    }

    @Test
    public void ShouldNotChangePinIfNewPinStartsWithMinusOrPlus()
    {
        //Given
        String newPinMinus = "-123";
        String newPinPlus = "+123";

        //When
        boolean isPinChangedMinus = creditCard.ChangePin(oldPin, newPinMinus, newPinMinus);
        boolean isPinChangedPlus = creditCard.ChangePin(oldPin, newPinPlus, newPinPlus);

        //Then
        assertFalse(isPinChangedMinus);
        assertFalse(isPinChangedPlus);
    }

    @Test
    public void ShouldNotChangePinIfOldPinIsNotValid()
    {
        //Given
        String notValidOldPin = "5678";
        String newPin = "0123";

        //When
        boolean isPinChanged = creditCard.ChangePin(notValidOldPin, newPin, newPin);

        //Then
        assertFalse(isPinChanged);
    }

    @Test
    public void ShouldNotChangePinIfOneOfParametersIsNull()
    {
        //Given
        //When
        boolean isPinChangedNull1 = creditCard.ChangePin(null, "", "");
        boolean isPinChangedNull2 = creditCard.ChangePin("", null, "");
        boolean isPinChangedNull3 = creditCard.ChangePin("", "", null);

        //Then
        assertFalse(isPinChangedNull1);
        assertFalse(isPinChangedNull2);
        assertFalse(isPinChangedNull3);
    }

    @Test
    public void ShouldReturnTrueIfPinIsValid()
    {
        //Given
        String pin = "0000";
        //When
        boolean isPinValid = creditCard.IsPinValid(pin);

        //Then
        assertTrue(isPinValid);
    }

    @Test
    public void ShouldReturnFalseIfPinIsNotValid()
    {
        //Given
        String pin = "1234";
        String pinNull = null;

        //When
        boolean isPinValid = creditCard.IsPinValid(pin);
        boolean isPinValidNull = creditCard.IsPinValid(pinNull);

        //Then
        assertFalse(isPinValid);
        assertFalse(isPinValidNull);
    }

    @Test
    public void ShouldDepositFunds()
    {
        //Given
        double toDeposit = 123.45;
        //When
        boolean isDeposited = creditCard.DepositFunds(toDeposit);

        //Then
        assertTrue(isDeposited);
    }

    @Test
    public void ShouldNotDepositFundsIfAccountIsNotConnected()
    {
        //Given
        CreditCardImpl creditCard = new CreditCardImpl();
        double toDeposit = 123.45;
        //When
        boolean isDeposited = creditCard.DepositFunds(toDeposit);

        //Then
        assertFalse(isDeposited);
    }

    @Test
    public void ShouldWithdrawFunds()
    {
        //Given
        double toWithdraw = 123.45;
        double initialBalance = 200;
        creditCard.DepositFunds(initialBalance);

        //When
        boolean isWithdrawn = creditCard.WithdrawFunds(toWithdraw);

        //Then
        assertTrue(isWithdrawn);
    }

    @Test
    public void ShouldNotWithdrawFundsIfAccountIsNotConnected()
    {
        //Given
        CreditCardImpl creditCard = new CreditCardImpl();
        double toWithdraw = 123.45;
        double initialBalance = 200;
        creditCard.DepositFunds(initialBalance);

        //When
        boolean isWithdrawn = creditCard.WithdrawFunds(toWithdraw);

        //Then
        assertFalse(isWithdrawn);
    }

    @Test
    public void ShouldNotWithdrawFundsIfNotEnoughBalance()
    {
        //Given
        double toWithdraw = 123.45;

        //When
        boolean isWithdrawn = creditCard.WithdrawFunds(toWithdraw);

        //Then
        assertFalse(isWithdrawn);
    }
}