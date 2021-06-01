package com.peregud.abstractfactorypattern;

import java.util.List;

public interface Car {
    String getCarBrand();
    List<?> getModel();
    List<?> getPrice();
}
