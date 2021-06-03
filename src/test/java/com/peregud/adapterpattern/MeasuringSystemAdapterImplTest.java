package com.peregud.adapterpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasuringSystemAdapterImplTest {
    MeasuringSystemAdapter measuringSystemAdapter = new MeasuringSystemAdapterImpl(ShapeType.RECTANGLE);

    @Test
    void calculatePerimeter() {
        assertEquals(3.9, measuringSystemAdapter.calculatePerimeter());
    }

    @Test
    void calculateArea() {
        assertEquals(2.34, measuringSystemAdapter.calculateArea());
    }

    @Test
    void calculateVolume() {
        assertEquals(0.0, measuringSystemAdapter.calculateVolume());
    }
}
