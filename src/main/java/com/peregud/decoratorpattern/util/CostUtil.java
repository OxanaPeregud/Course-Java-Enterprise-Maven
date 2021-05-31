package com.peregud.decoratorpattern.util;

import com.peregud.decoratorpattern.model.Size;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CostUtil {

    public double getCost(Size size, double cost) {
        if (size == Size.LARGE) {
            cost = cost * 1.5;
        } else if (size == Size.SMALL) {
            cost = cost / 1.5;
        }
        return RoundUtil.up(cost);
    }
}
