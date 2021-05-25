package com.peregud.encapsulationofbehavior;

public class Manager extends Employee {

    public Manager(WorkBehavior workBehavior, EatBehavior eatBehavior) {
        super(workBehavior, eatBehavior);
    }

    @Override
    public void taskExecution() {
        System.out.println("Managing a project");
    }
}
