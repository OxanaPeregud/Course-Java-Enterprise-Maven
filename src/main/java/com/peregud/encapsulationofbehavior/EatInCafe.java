package com.peregud.encapsulationofbehavior;

public class EatInCafe implements EatBehavior {

    @Override
    public void eat() {
        System.out.println("Employee is eating in cafe");
    }
}
