package com.peregud.iteratorcompositepattern;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SecondStoreIteratorTest {
    ProductItem productItem1 = new ProductItem(1, "Product 1", 10.0);
    ProductItem productItem2 = new ProductItem(2, "Product 2", 5.0);

    public SecondStoreIterator secondStoreIterator() {
        List<ProductItem> items = List.of(productItem1, productItem2);
        return new SecondStoreIterator(items);
    }

    @Test
    void hasNext() {
        assertTrue(secondStoreIterator().hasNext());
    }

    @Test
    void next() {
        assertEquals(productItem1, secondStoreIterator().next());
    }
}
