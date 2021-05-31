package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MargheritaTest {
    Pizza pizza = new Margherita(Size.LARGE);

    @Test
    void description() {
        assertEquals("Margherita", pizza.description());
    }

    @Test
    void cost() {
        assertEquals(6.0, pizza.cost());
    }
}
