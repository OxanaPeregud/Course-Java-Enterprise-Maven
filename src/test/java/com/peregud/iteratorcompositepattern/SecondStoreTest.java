package com.peregud.iteratorcompositepattern;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class SecondStoreTest {

    @Test
    void addItems() {
        SecondStore secondStore = mock(SecondStore.class);
        ProductItem productItem1 = new ProductItem(1, "Product 1", 10.0);
        ProductItem productItem2 = new ProductItem(2, "Product 2", 5.0);
        List<ProductItem> items = List.of(productItem1, productItem2);
        when(secondStore.addItems()).thenReturn(items);
        assertEquals(items, secondStore.addItems());
    }
}
