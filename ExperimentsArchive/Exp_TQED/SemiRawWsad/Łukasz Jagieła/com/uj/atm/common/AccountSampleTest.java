package com.uj.atm.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

public class AccountSampleTest {


    @Test
    public void accountStatus_ShouldReturnCurrentBalance(){
        AccountSample account = new AccountSample();
        account.DepositFunds(384.0);
        assertEquals(384.0, account.AccountStatus(), 0);
    }


    @Test
    public void withdrawFunds_ShouldWithdraw50(){
        AccountSample account = new AccountSample(450.0);
        account.WithdrawFunds(50.0);
        assertEquals(400.0, account.AccountStatus(), 0);
    }

    @Test
    public void withdrawFunds_ShouldThrowExceptionIfAmountIsHigherThanAccountBalance(){
        AccountSample account = new AccountSample(450);
        assertThatThrownBy(() ->  account.WithdrawFunds(500.0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not enough money");
    }

    @Test
    public void withdrawFunds_ShouldReturnCurrentBalanceIfAmountIsNegative(){
        AccountSample account = new AccountSample(450.0);
        account.WithdrawFunds(-500.0);
        assertEquals(450.0, account.AccountStatus(), 0);
    }

    @Test
    public void withdrawFunds_ShouldReturnCurrentBalanceIfAmountIs0(){
        AccountSample account = new AccountSample(450.0);
        account.WithdrawFunds(0);
        assertEquals(450.0, account.AccountStatus(), 0);
    }

    @Test
    public void depositFunds_ShouldDeposit50() {
        AccountSample account = new AccountSample(100);
        account.DepositFunds(50.0);
        assertEquals(150.0, account.AccountStatus(), 0);
    }

    @Test
    public void depositFunds_ShouldReturnCurrentBalanceIfAmountIsNegative() {
        AccountSample account = new AccountSample(100);
        account.DepositFunds(-50.0);
        assertEquals(100.0, account.AccountStatus(), 0);
    }

    @Test
    public void depositFunds_ShouldDepositNothingIfAmountIs0() {
        AccountSample account = new AccountSample(100);
        account.DepositFunds(0);
        assertEquals(100.0, account.AccountStatus(), 0);
    }

}
