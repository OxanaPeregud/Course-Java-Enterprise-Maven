package com.peregud.encapsulationofbehavior;

public class Analyst extends Employee {

    public Analyst() {
        workBehavior = new WorkInOffice();
        eatBehavior = new NoEat();
    }

    @Override
    public void taskExecution() {
        System.out.println("Analyst is recording and formulating the requirements for a product");
    }
}
