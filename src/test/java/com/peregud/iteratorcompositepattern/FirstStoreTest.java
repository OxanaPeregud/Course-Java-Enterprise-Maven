package com.peregud.iteratorcompositepattern;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class FirstStoreTest {

    @Test
    void addItems() {
        FirstStore firstStore = mock(FirstStore.class);
        ProductItem productItem1 = new ProductItem(1, "Product 1", 10.0);
        ProductItem productItem2 = new ProductItem(2, "Product 2", 5.0);
        ProductItem[] items = {productItem1, productItem2};
        when(firstStore.addItems()).thenReturn(items);
        assertEquals(items, firstStore.addItems());
    }
}
