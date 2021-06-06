package com.peregud.iteratorpattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstStoreIteratorTest {
    ProductItem productItem1 = new ProductItem(1, "Product 1", 10.0);
    ProductItem productItem2 = new ProductItem(2, "Product 2", 5.0);

    public FirstStoreIterator firstStoreIterator() {
        ProductItem[] items = {productItem1, productItem2};
        return new FirstStoreIterator(items);
    }

    @Test
    void hasNext() {
        assertTrue(firstStoreIterator().hasNext());
    }

    @Test
    void next() {
        assertEquals(productItem1, firstStoreIterator().next());
    }
}
