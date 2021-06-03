package com.peregud.adapterpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle rectangle = new Rectangle();

    @Test
    void calculatePerimeter() {
        assertEquals(10.0, rectangle.calculatePerimeter());
    }

    @Test
    void calculateArea() {
        assertEquals(6.0, rectangle.calculateArea());
    }
}
