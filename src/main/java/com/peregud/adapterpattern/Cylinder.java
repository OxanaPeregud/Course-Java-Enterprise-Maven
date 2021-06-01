package com.peregud.adapterpattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cylinder implements ThreeDimensionalShapes {
    private double radius;
    private double height;

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
