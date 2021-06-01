package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.util.DBUtil;

import java.util.List;

public class Kawasaki implements Motorcycle {

    @Override
    public String getMotorcycleBrand() {
        return "Kawasaki";
    }

    @Override
    public List<?> getModel() {
        return DBUtil.getData("motorcycleModel", "MotorcycleModel", "motorcycleEntity", 1);
    }

    @Override
    public List<?> getPrice() {
        return DBUtil.getData("price", "MotorcycleModel", "motorcycleEntity", 1);
    }
}
