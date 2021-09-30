package com.uj.atm.interfaces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    /**
     * Test sprawdzający czy po dokonaniu wypłaty większej niż aktualny stan konta stan będzie ujemny do poprzedniech
     */

    @Test
    public void accountStatus(){
        IAccount konto = new Account();
        double L1 = konto.AccountStatus()+100;
        Assert.assertFalse(konto.WithdrawFunds(L1)<0);
    }

    /**
     * Test sprawdzający czy można wpłacić złamanego grosza (zakładajać ze 0.01 = grosz dzielony na pół =0.005)
     * Test sprawdza czy jest ograniczenie groszowe
     */


    @Test
    public void depositFunds() {
        IAccount test2 = new Account();
        double L2 = test2.AccountStatus()+0.005;
        Assert.assertFalse(L2==test2.DepositFunds(0.005));
    }

    /**
     * Test sprawdzający czy można wypłacić kwotę większą niż aktualny stan konta
     */
    @Test
    public void withdrawFunds() {
        IAccount konto = new Account();
        double test = konto.AccountStatus();
        double L3 = konto.AccountStatus()+100;
        Assert.assertFalse(konto.WithdrawFunds(L3)==test-L3);
    }

}

