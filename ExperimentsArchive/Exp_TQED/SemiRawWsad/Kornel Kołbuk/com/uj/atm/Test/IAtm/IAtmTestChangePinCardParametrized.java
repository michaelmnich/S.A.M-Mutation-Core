package com.uj.atm.Test.IAtm;

import com.uj.atm.common.IAtm;
import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


@RunWith(Parameterized.class)
public record IAtmTestChangePinCardParametrized(
        String currentPin,
        String expectedPin,
        String newPin,
        String newPinConfirm,
        boolean expectedChangePinReturn
) {
    @Parameterized.Parameters(name = "{index}: current pin: {0}, expected pin after change: {1}, newPin: {2}, newPinConfirm {3}, change status {4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"0000", "1234", "1234", "1234", true},
                        {"0001", "0000", "1234", "1234", false},
                        {"0000", "0000", "12345", "12345", false},
                        {"0000", "0000", "1234", "12345", false},
                        {"0000", "0000", "12345", "1234", false},
                }
        );
    }

    @Test
    public void test_change_pin_via_atm() {
        ICreditCard card = new ICreditCard();
        IAtm iAtm = new IAtm();
        boolean status = iAtm.ChangePinCard(card, this.currentPin, this.newPin, this.newPinConfirm);
        Assert.assertEquals(status, this.expectedChangePinReturn);
        Assert.assertTrue(card.IsPinValid(this.expectedPin));
        // -------
        if (status) {
            // lets try revert to old pin
            Assert.assertTrue(
                    iAtm.ChangePinCard(card, this.newPin, this.currentPin, this.currentPin)
            );
            Assert.assertTrue(card.IsPinValid(this.currentPin));
            Assert.assertFalse(card.IsPinValid(this.newPin));
        }
    }
}


