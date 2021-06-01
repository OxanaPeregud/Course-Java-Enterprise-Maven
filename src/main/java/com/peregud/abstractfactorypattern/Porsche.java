package com.peregud.abstractfactorypattern;

import com.peregud.abstractfactorypattern.util.DBUtil;

import java.util.List;

public class Porsche implements Car {

    @Override
    public String getCarBrand() {
        return "Porsche";
    }

    @Override
    public List<?> getModel() {
        return DBUtil.getData("carModel", "CarModel", "carEntity", 1);
    }

    @Override
    public List<?> getPrice() {
        return DBUtil.getData("price", "CarModel", "carEntity", 1);
    }
}
