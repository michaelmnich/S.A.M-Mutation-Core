package com.uj.atm.Test.IAtm;

import com.uj.atm.common.IAccount;
import com.uj.atm.common.IAtm;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;


public class IAtmTest {

    @Test
    public void test_check_pin_and_log_in() {
        ICreditCard card = new ICreditCard();
        IAtm iAtm = new IAtm();
        Assert.assertTrue(
                iAtm.CheckPinAndLogIn(card, "0000")
        );
        Assert.assertFalse(
                iAtm.CheckPinAndLogIn(card, "000")
        );
        Assert.assertFalse(
                iAtm.CheckPinAndLogIn(card, "00000")
        );
        Assert.assertTrue(
                iAtm.CheckPinAndLogIn(card, "0000")
        );
    }

    @Test
    public void test_account_status() {
        IAccount account = new IAccount();
        IAtm iAtm = new IAtm();
        account.DepositFunds(50.05);
        Assert.assertEquals(iAtm.AccountStatus(account), 50.05, 0);
        Assert.assertEquals(iAtm.AccountStatus(account), 50.05, 0);
    }

}

