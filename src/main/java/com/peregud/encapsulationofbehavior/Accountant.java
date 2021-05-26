package com.peregud.encapsulationofbehavior;

public class Accountant extends Employee {

    public Accountant(WorkBehavior workBehavior, EatBehavior eatBehavior) {
        super(workBehavior, eatBehavior);
    }

    @Override
    public void taskExecution() {
        System.out.println("Accountant is working with documents");
    }
}
