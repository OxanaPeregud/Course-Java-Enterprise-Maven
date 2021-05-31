package com.peregud.abstractfactorypattern;

public class MotorcycleFactory implements AbstractFactory<Motorcycle> {

    @Override
    public Motorcycle create(String type) {
        Motorcycle motorcycle = null;
        if ("Kawasaki".equalsIgnoreCase(type)) {
            motorcycle = new Kawasaki();
        } else if ("Suzuki".equalsIgnoreCase(type)) {
            motorcycle = new Suzuki();
        } else if ("Yamaha".equalsIgnoreCase(type)) {
            motorcycle = new Yamaha();
        }
        return motorcycle;
    }
}
