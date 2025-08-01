package com.uj.atm.Test.ICard;

import com.uj.atm.common.ICreditCard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;


@RunWith(Parameterized.class)
public record ICardTestChangeDefaultPin(
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
    public void test_change_pin() {
        ICreditCard card = new ICreditCard();
        boolean status = card.ChangePin(this.currentPin, this.newPin, this.newPinConfirm);
        Assert.assertEquals(status, this.expectedChangePinReturn);
        Assert.assertTrue(card.IsPinValid(this.expectedPin));
        // -------
        if (status) {
            // lets try revert to old pin
            Assert.assertTrue(
                    card.ChangePin(this.newPin, this.currentPin, this.currentPin)
            );
            Assert.assertTrue(card.IsPinValid(this.currentPin));
            Assert.assertFalse(card.IsPinValid(this.newPin));
        }
    }
}


