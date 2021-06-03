package com.peregud.adapterpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    Circle circle = new Circle();

    @Test
    void calculatePerimeter() {
        assertEquals(12.57, circle.calculatePerimeter());
    }

    @Test
    void calculateArea() {
        assertEquals(12.57, circle.calculateArea());
    }
}
