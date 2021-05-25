package com.peregud.encapsulationofbehavior;

public class WorkFromHome implements WorkBehavior {

    @Override
    public void work() {
        System.out.println("Employee is working from home");
    }
}
