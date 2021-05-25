package com.peregud.encapsulationofbehavior;

public class NoEat implements EatBehavior {

    @Override
    public void eat() {
        System.out.println("Employee is not eating at all");
    }
}
