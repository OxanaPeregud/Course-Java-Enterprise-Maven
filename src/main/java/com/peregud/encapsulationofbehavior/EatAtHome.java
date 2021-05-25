package com.peregud.encapsulationofbehavior;

public class EatAtHome implements EatBehavior {

    @Override
    public void eat() {
        System.out.println("Employee is eating at home");
    }
}
