package com.peregud.adapterpattern;

import java.util.ArrayList;
import java.util.List;

public class CalculatingArea {
    private final List<TwoDimensionalShapes> shapes = new ArrayList<>();

    public void addShape(TwoDimensionalShapes shape) {
        shapes.add(shape);
    }

    public void calculatingArea() {
        if (shapes.isEmpty()) {
            System.out.println("Nothing to calculate!");
        } else {
            shapes.forEach(TwoDimensionalShapes::calculateArea);
        }
    }
}
