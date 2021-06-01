package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.type.MotorcycleBrand;

public class MotorcycleFactory implements AbstractFactory<Motorcycle> {

    @Override
    public Motorcycle create(Enum<?> type) {
        Motorcycle motorcycle = null;
        if (type instanceof MotorcycleBrand) {
            MotorcycleBrand motorcycleBrand = (MotorcycleBrand) type;
            switch (motorcycleBrand) {
                case KAWASAKI:
                    motorcycle = new Kawasaki();
                    break;
                case SUZUKI:
                    motorcycle = new Suzuki();
                    break;
                case YAMAHA:
                    motorcycle = new Yamaha();
                    break;
            }
        }
        return motorcycle;
    }
}
