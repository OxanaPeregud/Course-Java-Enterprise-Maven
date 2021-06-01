package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.util.DBUtil;

import java.util.List;

public class Yamaha implements Motorcycle {

    @Override
    public String getMotorcycleBrand() {
        return "Yamaha";
    }

    @Override
    public List<?> getModel() {
        return DBUtil.getData("motorcycleModel", "MotorcycleModel", "motorcycleEntity", 3);
    }

    @Override
    public List<?> getPrice() {
        return DBUtil.getData("price", "MotorcycleModel", "motorcycleEntity", 3);
    }
}
