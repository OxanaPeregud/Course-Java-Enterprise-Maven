package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.util.PizzaDBUtil;
import com.peregud.decoratorpattern.util.RoundUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Vegetables extends Ingredients {
    private final Pizza pizza;

    @Override
    public String description() {
        return pizza.description() + " + Vegetables";
    }

    @Override
    public double cost() {
        return RoundUtil.up(pizza.cost() + PizzaDBUtil.getIngredientCost("'Vegetables'"));
    }
}
