package com.peregud.abstractfactorypattern;

import static com.peregud.abstractfactorypattern.type.CarBrand.PORSCHE;
import static com.peregud.abstractfactorypattern.type.FactoryType.CAR;
import static com.peregud.abstractfactorypattern.type.FactoryType.MOTORCYCLE;
import static com.peregud.abstractfactorypattern.type.MotorcycleBrand.SUZUKI;

public class AbstractPatternApp {
    public static void main(String[] args) {
        AbstractFactory<?> abstractFactory;

        abstractFactory = FactoryProvider.getFactory(CAR);
        Car car = (Car) abstractFactory.create(PORSCHE);

        abstractFactory = FactoryProvider.getFactory(MOTORCYCLE);
        Motorcycle motorcycle = (Motorcycle) abstractFactory.create(SUZUKI);

        String result = car.getCarBrand() + " + " + motorcycle.getMotorcycleBrand();

        System.out.println(result);
    }
}
