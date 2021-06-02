package com.peregud.adapterpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoWaysAdapterTest {

    @Test
    void calculateVolume() {
        TwoWaysAdapter twoWaysAdapter1 = new TwoWaysAdapter(ShapeType.CUBE);
        assertEquals(27.0, twoWaysAdapter1.calculateVolume());
        TwoWaysAdapter twoWaysAdapter2 = new TwoWaysAdapter(ShapeType.RECTANGLE);
        assertEquals(0.0, twoWaysAdapter2.calculateVolume());
    }

    @Test
    void calculatePerimeter() {
        TwoWaysAdapter twoWaysAdapter1 = new TwoWaysAdapter(ShapeType.CIRCLE);
        assertEquals(12.57, twoWaysAdapter1.calculatePerimeter());
        TwoWaysAdapter twoWaysAdapter2 = new TwoWaysAdapter(ShapeType.CYLINDER);
        assertEquals(0.0, twoWaysAdapter2.calculatePerimeter());
    }

    @Test
    void calculateArea() {
        TwoWaysAdapter twoWaysAdapter1 = new TwoWaysAdapter(ShapeType.RECTANGLE);
        assertEquals(6.0, twoWaysAdapter1.calculateArea());
    }
}
