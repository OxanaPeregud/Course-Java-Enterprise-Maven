package com.peregud.encapsulationofbehavior;

public class Programmer extends Employee {

    public Programmer() {
        workBehavior = new WorkFromHome();
        eatBehavior = new EatAtHome();
    }

    @Override
    public void taskExecution() {
        System.out.println("Programmer is writing a code");
    }
}
