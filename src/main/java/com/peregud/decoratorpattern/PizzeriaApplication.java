package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;

public class PizzeriaApplication {
    public static void main(String[] args) {

        Pizza pizza1 = new FourCheese(Size.LARGE);
        System.out.println(pizza1.description() + " " + pizza1.cost() + "$");

        Pizza pizza2 = new Margherita(Size.MEDIUM);
        pizza2 = new Cheese(pizza2);
        System.out.println(pizza2.description() + " " + pizza2.cost() + "$");

        Pizza pizza3 = new MeatDelight(Size.SMALL);
        pizza3 = new Cheese(pizza3);
        pizza3 = new Vegetables(pizza3);
        pizza3 = new Vegetables(pizza3);
        System.out.println(pizza3.description() + " " + pizza3.cost() + "$");
    }
}
