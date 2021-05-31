package com.peregud.abstractfactorypattern;

public class AbstractPatternApp {
    public static void main(String[] args) {
        AbstractFactory<?> abstractFactory;

        abstractFactory = FactoryProvider.getFactory("Car");
        Car car = (Car) abstractFactory.create("Mazda");

        abstractFactory = FactoryProvider.getFactory("Motorcycle");
        Motorcycle motorcycle = (Motorcycle) abstractFactory.create("Suzuki");

        String result = car.getCarBrand() + " + " + motorcycle.getMotorcycleBrand();

        System.out.println(result);
    }
}
