package com.peregud.encapsulationofbehavior;

import lombok.Setter;

@Setter
public abstract class Employee {
    private WorkBehavior workBehavior;
    private EatBehavior eatBehavior;

    public Employee(WorkBehavior workBehavior, EatBehavior eatBehavior) {
        this.workBehavior = workBehavior;
        this.eatBehavior = eatBehavior;
    }

    public void startWork() {
        System.out.println("Employee starts working at 9:00 a.m.");
    }

    public void performWork() {
        workBehavior.work();
    }

    public abstract void taskExecution();

    public void takeBreak() {
        System.out.println("Employee is taking a break from work");
    }

    public void performEat() {
        eatBehavior.eat();
    }

    public void finishWork() {
        System.out.println("Employee finishes working at 6:00 p.m.");
    }

}
