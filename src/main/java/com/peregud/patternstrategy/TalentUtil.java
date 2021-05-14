package com.peregud.patternstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class TalentUtil {

    public static double getTalent() {
        return BigDecimal.valueOf((Math.random() * (1 - 0.1)) + 0.1)
                .setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
