package com.peregud.adapterpattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Cylinder implements ThreeDimensionalShapes {
    private double radius = 2;
    private double height = 3;

    @Override
    public double calculateArea() {
        return RoundUtil.up(2 * Math.PI * radius * (height + radius));
    }

    @Override
    public double calculateVolume() {
        return RoundUtil.up(Math.PI * Math.pow(radius, 2) * height);
    }

    @Override
    public String description() {
        return "cylinder volume: " + calculateVolume() + ", area: " + calculateArea();
    }
}
