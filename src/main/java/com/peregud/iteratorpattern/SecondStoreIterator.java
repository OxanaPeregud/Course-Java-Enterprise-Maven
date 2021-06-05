package com.peregud.iteratorpattern;

import java.util.List;

public class SecondStoreIterator implements Iterator {
    private final List<ProductItem> items;
    private int position = 0;

    public SecondStoreIterator(List<ProductItem> items) {
        this.items = items;
    }

    public ProductItem next() {
        ProductItem item = items.get(position);
        position = position + 1;
        return item;
    }

    public boolean hasNext() {
        return position < items.size() && items.get(position) != null;
    }
}
