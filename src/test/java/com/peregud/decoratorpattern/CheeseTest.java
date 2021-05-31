package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {
    Pizza pizza = new FourCheese(Size.LARGE);
    Cheese cheese = new Cheese(pizza);

    @Test
    void description() {
        assertEquals("Four Cheese + Cheese", cheese.description());
    }

    @Test
    void cost() {
        assertEquals(9.25, cheese.cost());
    }
}
