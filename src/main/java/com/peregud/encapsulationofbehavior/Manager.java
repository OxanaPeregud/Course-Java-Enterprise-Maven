package com.peregud.encapsulationofbehavior;

public class Manager extends Employee {

    public Manager() {
        workBehavior = new WorkInOffice();
        eatBehavior = new EatInCafe();
    }

    @Override
    public void taskExecution() {
        System.out.println("Managing a project");
    }
}
