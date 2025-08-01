package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class CreditCardSampleTest {

    @Test
    public void changePin_ShouldReturnTrueIfPinHasBeenChanged() {
        CreditCardSample creditCard = new CreditCardSample();
        boolean check = creditCard.ChangePin("1234", "4321", "4321");
        assertEquals(true, check);
    }

    @Test
    public void changePin_ShouldReturnFalseIfOldPinDoesNotMatchTheCurrentPin() {
        CreditCardSample creditCard = new CreditCardSample();
        boolean check = creditCard.ChangePin("1233", "4321", "4321");
        assertEquals(false, check);
    }

    @Test
    public void changePin_ShouldReturnFalseIfNewPinAndNewPinConfirmAreNotTheSame() {
        CreditCardSample creditCard = new CreditCardSample();
        boolean check = creditCard.ChangePin("1234", "4322", "4321");
        assertEquals(false, check);
    }

    @Test
    public void isPinValid_ShouldReturnTrueIfGivenPinIsTheSameAsCurrentPin() {
        CreditCardSample creditCard = new CreditCardSample();
        String pin = "1234";
        boolean check = creditCard.IsPinValid(pin);
        assertEquals(true, check);
    }

    @Test
    public void isPinValid_ShouldReturnFalseIfGivenPinIsNotTheSameAsCurrentPin() {
        CreditCardSample creditCard = new CreditCardSample();
        String pin = "1233";
        boolean check = creditCard.IsPinValid(pin);
        assertEquals(false, check);
    }


    @Test
    public void addAccount_ShouldThrowExceptionIfAccountIsNull(){
        IAccount cardAccount = null;
        ICreditCard card = new CreditCardSample();
        assertThatThrownBy(() -> card.AddAccount(cardAccount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Account cannot be null");
    }

    @Test
    public void addAccount_ShouldThrowExceptionIfCardHasAlreadyAccount(){
        IAccount account = new AccountSample(400);
        CreditCardSample card = new CreditCardSample();
        IAccount account1 = new AccountSample(500);
        card.AddAccount(account);
        assertThatThrownBy(() -> card.AddAccount(account1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Card has account");
    }

    @Test
    public void depositFunds_ShouldThrowExceptionIfAccountIsNull(){
        IAccount account = null;
        ICreditCard card = new CreditCardSample();
        assertThatThrownBy(() -> card.AddAccount(account))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Account cannot be null");

    }

    @Test
    public  void depositFunds_ShouldIncreaseAccountBalanceAndReturnTrue(){
        IAccount account = new AccountSample(400);
        ICreditCard card = new CreditCardSample();
        card.AddAccount(account);
        boolean check = card.DepositFunds(400);
        assertTrue(check);
        assertEquals(account.AccountStatus(), 800, 0.0);
    }

    @Test
    public void depositFunds_ShouldAddAmountToAccountBalanceAndReturnTrue(){
        IAccount account = new AccountSample(400);
        ICreditCard card = new CreditCardSample();
        card.AddAccount(account);
        boolean check = card.DepositFunds(400.12);
        assertTrue(check);
        assertEquals(account.AccountStatus(), 800.12, 0.0);
    }

    @Test
    public void withdrawFunds_ShouldWithdraw100FromAccountAndReturnTrue(){
        IAccount account = new AccountSample(400);
        ICreditCard card = new CreditCardSample();
        card.AddAccount(account);
        boolean check = card.WithdrawFunds(100);
        assertTrue(check);
        assertEquals(account.AccountStatus(), 300, 0.0);
    }

    @Test
    public void withdrawFunds_ShouldThrowExceptionIfAccountIsNull(){
        IAccount account = null;
        ICreditCard card = new CreditCardSample();
        assertThatThrownBy(() ->  card.AddAccount(account))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Account cannot be null");
    }

    @Test
    public void withdrawFunds_ShouldReturnFalseIfAmountIsHigherThanAccountBalance(){
        IAccount account = new AccountSample(600);
        ICreditCard card = new CreditCardSample();
        card.AddAccount(account);
        assertThatThrownBy(() -> card.WithdrawFunds(700))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not enough money");

    }






}
