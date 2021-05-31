package com.peregud.abstractfactorypattern;

public class FactoryProvider {

    public static AbstractFactory<?> getFactory(String factory) {
        AbstractFactory<?> abstractFactory = null;
        if ("Car".equalsIgnoreCase(factory)) {
            abstractFactory = new CarFactory();
        } else if ("Motorcycle".equalsIgnoreCase(factory)) {
            abstractFactory = new MotorcycleFactory();
        }
        return abstractFactory;
    }
}
