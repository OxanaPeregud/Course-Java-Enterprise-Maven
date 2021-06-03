package com.peregud.adapterpattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static com.peregud.adapterpattern.ShapeType.*;

@AllArgsConstructor
@Getter
public class TwoWaysCalculatorAdapter implements TwoDimensionalShapes, ThreeDimensionalShapes {
    private final ShapeType shapeType;
    private static final Map<ShapeType, Supplier<TwoDimensionalShapes>> MAP_1;
    private static final Map<ShapeType, Supplier<ThreeDimensionalShapes>> MAP_2;

    static {
        MAP_1 = new HashMap<>();
        MAP_2 = new HashMap<>();
        Supplier<TwoDimensionalShapes> supplier1 = Circle::new;
        Supplier<TwoDimensionalShapes> supplier2 = Rectangle::new;
        Supplier<ThreeDimensionalShapes> supplier3 = Cube::new;
        Supplier<ThreeDimensionalShapes> supplier4 = Cylinder::new;
        MAP_1.put(CIRCLE, supplier1);
        MAP_1.put(RECTANGLE, supplier2);
        MAP_2.put(CUBE, supplier3);
        MAP_2.put(CYLINDER, supplier4);
    }

    @Override
    public double calculateVolume() {
        double volume = 0;
        switch (shapeType) {
            case CIRCLE:
            case RECTANGLE:
                System.out.println("It's two dimensional shape, can't calculate volume");
                break;
            case CUBE:
            case CYLINDER:
                volume = MAP_2.get(shapeType).get().calculateVolume();
                break;
        }
        return volume;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        switch (shapeType) {
            case CIRCLE:
            case RECTANGLE:
                perimeter = MAP_1.get(shapeType).get().calculatePerimeter();
                break;
            case CUBE:
            case CYLINDER:
                System.out.println("It's three dimensional shape, can't calculate perimeter");
                break;
        }
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = 0;
        switch (shapeType) {
            case CIRCLE:
            case RECTANGLE:
                area = MAP_1.get(shapeType).get().calculateArea();
                break;
            case CUBE:
            case CYLINDER:
                area = MAP_2.get(shapeType).get().calculateArea();
                break;
        }
        return area;
    }
}
