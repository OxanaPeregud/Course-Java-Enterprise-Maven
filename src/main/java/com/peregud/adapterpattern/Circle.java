package com.peregud.adapterpattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Circle implements TwoDimensionalShapes {
    private double radius;

    @Override
    public double calculatePerimeter() {
        return RoundUtil.up(2 * Math.PI * radius);
    }

    @Override
    public double calculateArea() {
        return RoundUtil.up(Math.pow(radius, 2) * Math.PI);
    }

    @Override
    public String description() {
        return "radius " + radius + ", area " + calculateArea();
    }
}
