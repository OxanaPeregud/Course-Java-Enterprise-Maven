package com.peregud.adapterpattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TwoWaysAdapter implements TwoDimensionalShapes, ThreeDimensionalShapes {
    private final ShapeType shapeType;

    @Override
    public double calculateVolume() {
        double volume = 0;
        switch (shapeType) {
            case CIRCLE:
            case RECTANGLE:
                System.out.println("It's two dimensional shape, can't calculate volume");
                break;
            case CUBE:
                volume = new Cube().calculateVolume();
                break;
            case CYLINDER:
                volume = new Cylinder().calculateVolume();
                break;
        }
        return volume;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        switch (shapeType) {
            case CIRCLE:
                perimeter = new Circle().calculatePerimeter();
            case RECTANGLE:
                perimeter = new Rectangle().calculatePerimeter();
                break;
            case CUBE:
                perimeter = new Cube().getSide() * 12;
                break;
            case CYLINDER:
                perimeter = new Cylinder().getHeight() * 2 + new Cylinder().getRadius() * 4;
                break;
        }
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = 0;
        switch (shapeType) {
            case CIRCLE:
                area = new Circle().calculateArea();
            case RECTANGLE:
                area = new Rectangle().calculateArea();
                break;
            case CUBE:
                area = new Cube().calculateArea();
                break;
            case CYLINDER:
                area = new Cylinder().calculateArea();
                break;
        }
        return area;
    }

    @Override
    public String description() {
        String description = null;
        switch (shapeType) {
            case CIRCLE:
                description = new Circle().description();
            case RECTANGLE:
                description = new Rectangle().description();
                break;
            case CUBE:
                description = new Cube().description();
                break;
            case CYLINDER:
                description = new Cylinder().description();
                break;
        }
        return description;
    }
}
