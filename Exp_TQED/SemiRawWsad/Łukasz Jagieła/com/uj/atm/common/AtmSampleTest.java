package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class AtmSampleTest {

    @Test
    public void checkPinAndLogIn_ShouldReturnTrueIfPinIsCorrect() {
        AtmSample atmSample = new AtmSample();
        ICreditCard card = new CreditCardSample();
        String pin = "1221";
        card.ChangePin("1234", pin, pin);
        boolean check = atmSample.CheckPinAndLogIn(card, pin);
        assertTrue(check);
    }

    @Test
    public void checkPinAndLogIn_ShouldReturnFalseIfCardIsNull() {
        AtmSample atmSample = new AtmSample();
        ICreditCard card = null;
        String pin = "1221";
        boolean check = atmSample.CheckPinAndLogIn(card, pin);
        assertFalse(check);
    }

    @Test
    public void checkPingAndLogin_ShouldReturnFalseIfPinIsTooLong(){
        AtmSample atmSample = new AtmSample();
        ICreditCard card = new CreditCardSample();
        String pin = "12211";
        boolean check = atmSample.CheckPinAndLogIn(card, pin);
        assertFalse(check);
    }

    @Test
    public void checkPingAndLogin_ShouldReturnFalseIfPinIsNull(){
        AtmSample atmSample = new AtmSample();
        ICreditCard card = new CreditCardSample();
        String pin = null;
        boolean check = atmSample.CheckPinAndLogIn(card, pin);
        assertFalse(check);
    }

    @Test
    public void checkPingAndLogin_ShouldReturnFalseIfPinIsTooShort(){
        AtmSample atmSample = new AtmSample();
        ICreditCard card = new CreditCardSample();
        String pin = "122";
        boolean check = atmSample.CheckPinAndLogIn(card, pin);
        assertFalse(check);
    }

    @Test
    public void checkPingAndLogin_ShouldReturnFalseIfPinHasLetters(){
        AtmSample atmSample = new AtmSample();
        ICreditCard card = new CreditCardSample();
        String pin = "1B21";
        boolean check = atmSample.CheckPinAndLogIn(card, pin);
        assertFalse(check);
    }

    @Test
    public void checkPingAndLogin_ShouldReturnFalseIfPinHasSpecialCharacters(){
        AtmSample atmSample = new AtmSample();
        ICreditCard card = new CreditCardSample();
        String pin = "1!2.";
        boolean check = atmSample.CheckPinAndLogIn(card, pin);
        assertFalse(check);
    }

    @Test
    public void accountStatus_ShouldReturnAccountBalance(){
        IAccount account = new AccountSample(400);
        AtmSample atmSample = new AtmSample();
        double balance = atmSample.AccountStatus(account);
        assertEquals(balance, 400, 0.0);
    }

    @Test
    public void accountStatus_ShouldThrowExceptionIfAccountIsNull(){
        IAccount account = null;
        AtmSample atmSample = new AtmSample();
        assertThatThrownBy(() -> atmSample.AccountStatus(account))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Account cannot be null");
    }


    @Test
    public void changePinCard_ShouldReturnTrueIfPinHasBeenChanged() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "1221";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertTrue(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfCardIsNull() {
        ICreditCard card = null;
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "1221";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfOldPinIsNull() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = null;
        String newPin = "1221";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinIsNull() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = null;
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinConfirmIsNull() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "1221";
        String newPinConfirm = null;
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfOldPinIsTooLong() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "12341";
        String newPin = "1221";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfOldPinIsTooShort() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "123";
        String newPin = "1221";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinIsTooLong() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "12211";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinIsTooShort() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "122";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinConfirmIsTooLong() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "1221";
        String newPinConfirm = "12211";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinConfirmIsTooShort() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "1221";
        String newPinConfirm = "122";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfOldPinHasLetters() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "12A4";
        String newPin = "1221";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfOldPinHasSpecialCharacters() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1!34";
        String newPin = "1221";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinHasLetters() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "122a";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinHasSpecialCharacters() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "122#";
        String newPinConfirm = "1221";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinConfirmHasLetters() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "1221";
        String newPinConfirm = "122q";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinConfirmHasSpecialCharacters() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "1234";
        String newPin = "1221";
        String newPinConfirm = "122@";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void changePinCard_ShouldReturnFalseIfNewPinIsNotEqualToNewPinConfirm() {
        ICreditCard card = new CreditCardSample();
        AtmSample atm = new AtmSample();
        String oldPin = "12A4";
        String newPin = "1221";
        String newPinConfirm = "1222";
        boolean check = atm.ChangePinCard(card, oldPin, newPin, newPinConfirm);
        assertFalse(check);
    }

    @Test
    public void depositFunds_ShouldReturnTrueIfDepositFunds(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        double amount = 100;
        boolean check = atm.DepositFunds(card, amount);
        assertTrue(check);
    }

    @Test
    public void depositFunds_ShouldReturnFalseIfAmountIsNegative(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        double amount = -100;
        boolean check = atm.DepositFunds(card, amount);
        assertFalse(check);
    }

    @Test
    public void depositFunds_ShouldReturnFalseIfCardIsNull(){
        AtmSample atm = new AtmSample();
        ICreditCard card = null;
        IAccount account = new AccountSample(400);
        double amount = 100;
        boolean check = atm.DepositFunds(card, amount);
        assertFalse(check);
    }

    @Test
    public void depositFunds_ShouldAddAmountToAccountBalance(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        double amount = 100;
        atm.DepositFunds(card, amount);
        assertEquals(account.AccountStatus(), 500, 0.0);
    }

    @Test
    public void depositFunds_ShouldNotAddAnythingToAccountBalanceIfAmountIs0(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        double amount = 0;
        atm.DepositFunds(card, amount);
        assertEquals(account.AccountStatus(), 400, 0.0);
    }




    @Test
    public void withdrawFunds_ShouldReturnTrueIfWithdrawFunds() {
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(1000);
        card.AddAccount(account);
        double amount = 50;
        boolean check = atm.DepositFunds(card, amount);
        assertTrue(check);
    }

    @Test
    public void withdrawFunds_ShouldReturnFalseIfAmountIsNegative(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(100);
        card.AddAccount(account);
        double amount = -50;
        boolean check = atm.DepositFunds(card, amount);
        assertFalse(check);
    }

    @Test
    public void withdrawFunds_ShouldReturnFalseIfCardIsNull(){
        AtmSample atm = new AtmSample();
        ICreditCard card = null;
        IAccount account = new AccountSample(1000);
        double amount = 50;
        boolean isWithdrawn = atm.DepositFunds(card, amount);
        assertFalse(isWithdrawn);
    }

    @Test
    public void withdrawFunds_ShouldWithdraw50FromAccountBalance(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(1000);
        card.AddAccount(account);
        double amount = 50;
        atm.WithdrawFunds(card, amount);
        assertEquals(account.AccountStatus(), 950, 0.0);
    }

    @Test
    public void withdrawFunds_ShouldWithdrawNothingIfAmountIs0(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(1000);
        card.AddAccount(account);
        double amount = 0;
        atm.WithdrawFunds(card, amount);
        assertEquals(account.AccountStatus(), 1000, 0.0);
    }

    @Test
    public void withdrawFunds_ShouldThrowExceptionIfAmountIsHigherThanAccountBalance(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(1000);
        card.AddAccount(account);
        assertThatThrownBy(() -> atm.WithdrawFunds(card, 1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not enough money");
    }

    @Test
    public void transfer_ShouldReturnTrueIfTransferMoney(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        IAccount recipientAccount = new AccountSample(200);
        boolean check = atm.Transfer(card, recipientAccount, 200);
        assertTrue(check);
    }

    @Test
    public void transfer_ShouldReturnFalseIfAmountIsNegative(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        IAccount recipientAccount = new AccountSample(200);
        boolean check = atm.Transfer(card, recipientAccount, -200);
        assertFalse(check);
    }

    @Test
    public void transfer_ShouldReturnFalseIfCardIsNull(){
        AtmSample atm = new AtmSample();
        ICreditCard card = null;
        IAccount account = new AccountSample(400);
        IAccount recipientAccount = new AccountSample(200);
        boolean check = atm.Transfer(card, recipientAccount, -200);
        assertFalse(check);
    }

    @Test
    public void transfer_ShouldReturnFalseIfRecipientAccountIsNull(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        IAccount recipientAccount = null;
        boolean check = atm.Transfer(card, recipientAccount, -200);
        assertFalse(check);
    }

    @Test
    public void transfer_ShouldTransfer100ToRecipientAccount(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        IAccount recipientAccount = new AccountSample(2100);
        atm.Transfer(card, recipientAccount, 100);
        assertEquals(recipientAccount.AccountStatus(), 2200, 0.0);
    }

    @Test
    public void transfer_ShouldWithdraw200FromAccount(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        IAccount recipientAccount = new AccountSample(2100);
        atm.Transfer(card, recipientAccount, 100);
        assertEquals(account.AccountStatus(), 300, 0.0);
    }

    @Test
    public void transfer_ShouldThrowException_WhenAmountIsHigherThanAccountBalance(){
        AtmSample atm = new AtmSample();
        ICreditCard card = new CreditCardSample();
        IAccount account = new AccountSample(400);
        card.AddAccount(account);
        IAccount recipientAccount = new AccountSample(100);
        assertThatThrownBy(() -> atm.Transfer(card, recipientAccount, 450))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not enough money");
    }

}
