package com.peregud.iteratorpattern;

public class FirstStoreIterator implements Iterator {
    private final ProductItem[] items;
    private int position = 0;

    public FirstStoreIterator(ProductItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public ProductItem next() {
        ProductItem productItem = items[position];
        position = position + 1;
        return productItem;
    }
}
