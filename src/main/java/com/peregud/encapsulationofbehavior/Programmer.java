package com.peregud.encapsulationofbehavior;

public class Programmer extends Employee {

    public Programmer(WorkBehavior workBehavior, EatBehavior eatBehavior) {
        super(workBehavior, eatBehavior);
    }

    @Override
    public void taskExecution() {
        System.out.println("Programmer is writing a code");
    }
}
