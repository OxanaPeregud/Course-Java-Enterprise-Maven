package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import com.peregud.decoratorpattern.util.CostUtil;
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
        return RoundUtil.up(CostUtil.getCost(getSize(), PizzaDBUtil.getPizzaCost("'Four Cheese'")));
    }
}
