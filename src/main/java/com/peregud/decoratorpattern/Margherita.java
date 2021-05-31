package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import com.peregud.decoratorpattern.util.CostUtil;
import com.peregud.decoratorpattern.util.PizzaDBUtil;
import com.peregud.decoratorpattern.util.RoundUtil;

public class Margherita extends Pizza {

    public Margherita(Size size) {
        super(size);
    }

    @Override
    public String description() {
        return "Margherita";
    }

    @Override
    public double cost() {
        return RoundUtil.up(CostUtil.getCost(getSize(), PizzaDBUtil.getPizzaCost("'Margherita'")));
    }
}
