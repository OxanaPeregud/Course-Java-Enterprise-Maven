package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.type.FactoryType;

public class FactoryProvider {

    public static AbstractFactory<?> getFactory(Enum<?> factory) {
        AbstractFactory<?> abstractFactory = null;
        if (factory instanceof FactoryType) {
            FactoryType factoryType = (FactoryType) factory;
            switch (factoryType) {
                case CAR:
                    abstractFactory = new CarFactory();
                    break;
                case MOTORCYCLE:
                    abstractFactory = new MotorcycleFactory();
                    break;
            }
        }
        return abstractFactory;
    }
}
