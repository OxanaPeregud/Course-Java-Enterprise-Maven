package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.util.DBUtil;

import java.util.List;

public class Audi implements Car {

    @Override
    public String getCarBrand() {
        return "Audi";
    }

    @Override
    public List<?> getModel() {
        return DBUtil.getData("carModel", "CarModel", "carEntity", 3);
    }

    @Override
    public List<?> getPrice() {
        return DBUtil.getData("price", "CarModel", "carEntity", 3);
    }
}
