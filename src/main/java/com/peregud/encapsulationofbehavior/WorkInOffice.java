package com.peregud.encapsulationofbehavior;

public class WorkInOffice implements WorkBehavior {

    @Override
    public void work() {
        System.out.println("Employee is working in office");
    }
}
