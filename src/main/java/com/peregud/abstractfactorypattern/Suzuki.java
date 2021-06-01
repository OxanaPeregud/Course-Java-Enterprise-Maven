package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.util.DBUtil;

import java.util.List;

public class Suzuki implements Motorcycle {

    @Override
    public String getMotorcycleBrand() {
        return "Suzuki";
    }

    @Override
    public List<?> getModel() {
        return DBUtil.getData("motorcycleModel", "MotorcycleModel", "motorcycleEntity", 2);
    }

    @Override
    public List<?> getPrice() {
        return DBUtil.getData("price", "MotorcycleModel", "motorcycleEntity", 2);
    }
}
