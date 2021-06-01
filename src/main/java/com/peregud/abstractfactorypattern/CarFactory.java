package com.peregud.abstractfactorypattern;

import static com.peregud.abstractfactorypattern.type.CarBrand.*;

public class CarFactory implements AbstractFactory<Car> {

    @Override
    public Car create(Enum<?> type) {
        Car car = null;
        if (PORSCHE.equals(type)) {
            car = new Porsche();
        } else if (MAZDA.equals(type)) {
            car = new Mazda();
        } else if (AUDI.equals(type)) {
            car = new Audi();
        }
        return car;
    }
}
