package com.uj.atm.Test;

import com.uj.atm.common.AccountSample;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    AccountSample accSample;
    @Before
    public void setupAcc(){

        accSample = new AccountSample();
    }

    @Test
    public void depoFoundsTest(){
        accSample.DepositFunds(50.0);
        assertEquals(50.0, accSample.AccountStatus(), 0);
    }

    @Test
    public void withdrawFoundsTest(){
        accSample.DepositFunds(50.0);
        accSample.WithdrawFunds(20.0);
        assertEquals(30.0, accSample.AccountStatus(), 0);
    }

    @Test
    public void checkAccSaldo(){
        assertEquals(0.0, accSample.AccountStatus(), 0);
    }

    @Test
    public void depoMinusFoundsTest(){
        accSample.DepositFunds(-50.0);
        assertEquals(0.0, accSample.AccountStatus(), 0);
    }

    @Test
    public void withdrawBiggerValueThenSaldoTest(){
        accSample.DepositFunds(50.0);
        accSample.WithdrawFunds(90.0);
        assertEquals(50.0, accSample.AccountStatus(), 0);
    }
}
