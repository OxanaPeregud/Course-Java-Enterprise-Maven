package com.peregud.encapsulationofbehavior;

public class Analyst extends Employee {

    public Analyst(WorkBehavior workBehavior, EatBehavior eatBehavior) {
        super(workBehavior, eatBehavior);
    }

    @Override
    public void taskExecution() {
        System.out.println("Analyst is recording and formulating the requirements for a product");
    }
}
