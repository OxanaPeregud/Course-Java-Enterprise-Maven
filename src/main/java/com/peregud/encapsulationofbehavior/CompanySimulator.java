package com.peregud.encapsulationofbehavior;

public class CompanySimulator {
    public static void main(String[] args) {
        Employee employee1 = new Programmer();
        employee1.performWork();
        employee1.performEat();

        Employee employee2 = new Manager();
        employee2.performEat();
        employee2.setEatBehavior(new EatInOffice());
        employee2.performEat();
    }
}
