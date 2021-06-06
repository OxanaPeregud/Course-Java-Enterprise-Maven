package com.peregud.iteratorpattern;

import java.util.List;

public class SecondStoreIterator implements Iterator {
    private final List<ProductItem> items;
    private int position = 0;

    public SecondStoreIterator(List<ProductItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size() && items.get(position) != null;
    }

    @Override
    public ProductItem next() {
        ProductItem item = items.get(position);
        position = position + 1;
        return item;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can’t remove an item until you’ve done at least one next()");
        }
        if (items.get(position - 1) != null) {
            for (int i = position - 1; i < (items.size() - 1); i++) {
                items.set(i, items.get(i + 1));
            }
            items.set(items.size() - 1, null);
        }
    }
}
