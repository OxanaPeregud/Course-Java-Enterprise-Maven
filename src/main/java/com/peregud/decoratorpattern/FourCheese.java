package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import com.peregud.decoratorpattern.util.PizzaDBUtil;
import com.peregud.decoratorpattern.util.RoundUtil;

public class FourCheese extends Pizza {

    public FourCheese(Size size) {
        super(size);
    }

    @Override
    public String description() {
        return "Four Cheese";
    }

    @Override
    public double cost() {
        double cost = PizzaDBUtil.getPizzaCost("'Four Cheese'");
        if (getSize() == Size.LARGE) {
            cost = cost * 1.5;
        } else if (getSize() == Size.SMALL) {
            cost = cost / 1.5;
        }
        return RoundUtil.up(cost);
    }
}
