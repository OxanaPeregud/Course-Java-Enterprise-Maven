package com.peregud.adapterpattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Cube implements ThreeDimensionalShapes {
    private double side = 3;

    @Override
    public double calculateArea() {
        return RoundUtil.up(6 * Math.pow(side, 2));
    }

    @Override
    public double calculateVolume() {
        return RoundUtil.up(Math.pow(side, 3));
    }
}
