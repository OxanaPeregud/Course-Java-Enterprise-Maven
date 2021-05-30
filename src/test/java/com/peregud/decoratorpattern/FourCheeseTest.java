package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourCheeseTest {
    Pizza pizza = new FourCheese(Size.MEDIUM);

    @Test
    void description() {
        assertEquals("Four Cheese", pizza.description());
    }

    @Test
    void cost() {
        assertEquals(5.5, pizza.cost());
    }
}
