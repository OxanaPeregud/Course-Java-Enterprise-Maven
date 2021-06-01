package com.peregud.abstractfactorypattern;

import static com.peregud.abstractfactorypattern.type.MotorcycleBrand.*;

public class MotorcycleFactory implements AbstractFactory<Motorcycle> {

    @Override
    public Motorcycle create(Enum<?> type) {
        Motorcycle motorcycle = null;
        if (KAWASAKI.equals(type)) {
            motorcycle = new Kawasaki();
        } else if (SUZUKI.equals(type)) {
            motorcycle = new Suzuki();
        } else if (YAMAHA.equals(type)) {
            motorcycle = new Yamaha();
        }
        return motorcycle;
    }
}
