package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatDelightTest {
    Pizza pizza = new MeatDelight(Size.SMALL);

    @Test
    void description() {
        assertEquals("Meat Delight", pizza.description());
    }

    @Test
    void cost() {
        assertEquals(4.87, pizza.cost());
    }
}
