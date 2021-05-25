package com.peregud.encapsulationofbehavior;

public class Accountant extends Employee {

    public Accountant() {
        workBehavior = new WorkInOffice();
        eatBehavior = new EatInOffice();
    }

    @Override
    public void taskExecution() {
        System.out.println("Accountant is working with documents");
    }
}
