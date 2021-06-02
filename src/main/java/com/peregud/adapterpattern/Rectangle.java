package com.peregud.adapterpattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Rectangle implements TwoDimensionalShapes {
    private double firstSide = 2;
    private double secondSide = 3;

    @Override
    public double calculatePerimeter() {
        return RoundUtil.up(2 * (firstSide + secondSide));
    }

    @Override
    public double calculateArea() {
        return RoundUtil.up(firstSide * secondSide);
    }

    @Override
    public String description() {
        return "rectangle area: " + calculateArea() + ", rectangle perimeter: " + calculatePerimeter();
    }
}
