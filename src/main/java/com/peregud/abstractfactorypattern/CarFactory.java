package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.type.CarBrand;

public class CarFactory implements AbstractFactory<Car> {

    @Override
    public Car create(Enum<?> type) {
        Car car = null;
        if (type instanceof CarBrand) {
            CarBrand carBrand = (CarBrand) type;
            switch (carBrand) {
                case PORSCHE:
                    car = new Porsche();
                    break;
                case MAZDA:
                    car = new Mazda();
                    break;
                case AUDI:
                    car = new Audi();
                    break;
            }
        }
        return car;
    }
}
