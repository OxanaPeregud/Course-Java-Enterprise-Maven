package com.peregud.adapterpattern;

import java.util.ArrayList;
import java.util.List;

public class CalculatingVolume {
    private final List<ThreeDimensionalShapes> shapes = new ArrayList<>();

    public void addShape(ThreeDimensionalShapes shape) {
        shapes.add(shape);
    }

    public void calculatingVolume() {
        if (shapes.isEmpty()) {
            System.out.println("Nothing to calculate!");
        } else {
            shapes.forEach(ThreeDimensionalShapes::calculateVolume);
        }
    }
}
