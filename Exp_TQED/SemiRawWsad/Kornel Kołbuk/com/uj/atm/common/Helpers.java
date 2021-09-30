package com.uj.atm.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Helpers {
    static BigDecimal SetScaleInBigDecimal(BigDecimal value) {
        return value.setScale(
                2, RoundingMode.HALF_UP
        );
    }

    static BigDecimal CreateBigDecimal(String value) {
        return SetScaleInBigDecimal(
                new BigDecimal(
                        value
                )
        );
    }
}
