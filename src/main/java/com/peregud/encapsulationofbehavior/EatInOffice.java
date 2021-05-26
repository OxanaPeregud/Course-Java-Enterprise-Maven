package com.peregud.encapsulationofbehavior;

public class EatInOffice implements EatBehavior {

    @Override
    public void eat() {
        System.out.println("Employee is eating in office");
    }
}
