package com.peregud.encapsulationofbehavior;

public class CompanySimulator {
    public static void main(String[] args) {
        Employee employee1 = new Programmer(new WorkFromHome(), new EatAtHome());
        employee1.startWork();
        employee1.performWork();
        employee1.performEat();

        Employee employee2 = new Manager(new WorkInOffice(), new EatInOffice());
        employee2.performEat();
        employee2.setEatBehavior(new EatInCafe());
        employee2.performEat();
    }
}
