package com.peregud.abstractfactorypattern;

public class CarFactory implements AbstractFactory<Car> {

    @Override
    public Car create(String type) {
        Car car = null;
        if ("Mazda".equalsIgnoreCase(type)) {
            car = new Mazda();
        } else if ("Porsche".equalsIgnoreCase(type)) {
            car = new Porsche();
        } else if ("Audi".equalsIgnoreCase(type)) {
            car = new Audi();
        }
        return car;
    }
}
