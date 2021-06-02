package com.peregud.adapterpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoWaysCalculatorAdapterTest {

    @Test
    void calculateVolume() {
        TwoWaysCalculatorAdapter twoWaysCalculatorAdapter1 = new TwoWaysCalculatorAdapter(ShapeType.CUBE);
        assertEquals(27.0, twoWaysCalculatorAdapter1.calculateVolume());
        TwoWaysCalculatorAdapter twoWaysCalculatorAdapter2 = new TwoWaysCalculatorAdapter(ShapeType.RECTANGLE);
        assertEquals(0.0, twoWaysCalculatorAdapter2.calculateVolume());
    }

    @Test
    void calculatePerimeter() {
        TwoWaysCalculatorAdapter twoWaysCalculatorAdapter1 = new TwoWaysCalculatorAdapter(ShapeType.CIRCLE);
        assertEquals(12.57, twoWaysCalculatorAdapter1.calculatePerimeter());
        TwoWaysCalculatorAdapter twoWaysCalculatorAdapter2 = new TwoWaysCalculatorAdapter(ShapeType.CYLINDER);
        assertEquals(0.0, twoWaysCalculatorAdapter2.calculatePerimeter());
    }

    @Test
    void calculateArea() {
        TwoWaysCalculatorAdapter twoWaysCalculatorAdapter1 = new TwoWaysCalculatorAdapter(ShapeType.RECTANGLE);
        assertEquals(6.0, twoWaysCalculatorAdapter1.calculateArea());
    }
}
