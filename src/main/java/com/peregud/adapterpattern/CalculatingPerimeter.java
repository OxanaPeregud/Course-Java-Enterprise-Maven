package com.peregud.adapterpattern;

import java.util.ArrayList;
import java.util.List;

public class CalculatingPerimeter {
    private final List<TwoDimensionalShapes> shapes = new ArrayList<>();

    public void addShape(TwoDimensionalShapes shape) {
        shapes.add(shape);
    }

    public void calculatingPerimeter() {
        if (shapes.isEmpty()) {
            System.out.println("Nothing to calculate!");
        } else {
            shapes.forEach(TwoDimensionalShapes::calculatePerimeter);
        }
    }
}
