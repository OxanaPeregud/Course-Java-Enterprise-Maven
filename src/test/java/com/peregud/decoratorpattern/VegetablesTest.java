package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetablesTest {
    Pizza pizza = new Margherita(Size.SMALL);
    Vegetables vegetables = new Vegetables(pizza);

    @Test
    void description() {
        assertEquals("Margherita + Vegetables", vegetables.description());
    }

    @Test
    void cost() {
        assertEquals(3.37, vegetables.cost());
    }
}
