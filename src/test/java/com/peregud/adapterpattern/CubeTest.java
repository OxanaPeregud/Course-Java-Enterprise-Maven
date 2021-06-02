package com.peregud.adapterpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeTest {
    Cube cube = new Cube();

    @Test
    void calculateArea() {
        assertEquals(54.0, cube.calculateArea());
    }

    @Test
    void calculateVolume() {
        assertEquals(27.0, cube.calculateVolume());
    }
}
