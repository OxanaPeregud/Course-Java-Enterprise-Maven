package com.peregud.abstractfactorypattern;

import static com.peregud.abstractfactorypattern.type.FactoryType.CAR;
import static com.peregud.abstractfactorypattern.type.FactoryType.MOTORCYCLE;

public class FactoryProvider {

    public static AbstractFactory<?> getFactory(Enum<?> factory) {
        AbstractFactory<?> abstractFactory = null;
        if (CAR.equals(factory)) {
            abstractFactory = new CarFactory();
        } else if (MOTORCYCLE.equals(factory)) {
            abstractFactory = new MotorcycleFactory();
        }
        return abstractFactory;
    }
}
