package com.peregud.adapterpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {
    Cylinder cylinder = new Cylinder();

    @Test
    void calculateArea() {
        assertEquals(62.83, cylinder.calculateArea());
    }

    @Test
    void calculateVolume() {
        assertEquals(37.7, cylinder.calculateVolume());
    }
}
