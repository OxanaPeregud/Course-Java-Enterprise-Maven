package com.peregud.encapsulationofbehavior;

public abstract class Employee {
    WorkBehavior workBehavior;
    EatBehavior eatBehavior;

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

    public void setWorkBehavior(WorkBehavior wb) {
        workBehavior = wb;
    }

    public void setEatBehavior(EatBehavior eb) {
        eatBehavior = eb;
    }
}
