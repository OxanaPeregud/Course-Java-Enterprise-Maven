package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.util.DBUtil;

import java.util.List;

public class Mazda implements Car {

    @Override
    public String getCarBrand() {
        return "Mazda";
    }

    @Override
    public List<?> getModel() {
        return DBUtil.getData("carModel", "CarModel", "carEntity", 2);
    }

    @Override
    public List<?> getPrice() {
        return DBUtil.getData("price", "CarModel", "carEntity", 2);
    }
}
