package com.peregud.adapterpattern;

import java.util.ArrayList;
import java.util.List;

public class GettingDescription {
    private final List<ThreeDimensionalShapes> shapes = new ArrayList<>();

    public void addShape(ThreeDimensionalShapes shape) {
        shapes.add(shape);
    }

    public void gettingDescription() {
        if (shapes.isEmpty()) {
            System.out.println("Nothing to describe!");
        } else {
            shapes.forEach(ThreeDimensionalShapes::description);
        }
    }
}
