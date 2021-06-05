package com.peregud.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

public class SecondStore implements OnlineStore {
    private final List<ProductItem> productItems;

    public SecondStore() {
        productItems = new ArrayList<>();
        addItem(1, "Second Product 1", 5.3, true);
        addItem(2, "Second Product 2", 8.6, false);
        addItem(3, "Second Product 3", 5.2, true);
    }

    public void addItem(int id, String name, double price, boolean inStock) {
        ProductItem productItem = new ProductItem(id, name, price, inStock);
        productItems.add(productItem);
    }

    public Iterator createIterator() {
        return new SecondStoreIterator(productItems);
    }
}
