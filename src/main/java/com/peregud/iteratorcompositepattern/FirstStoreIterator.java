package com.peregud.iteratorcompositepattern;

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

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can’t remove an item until you’ve done at least one next()");
        }
        if (items[position - 1] != null) {
            if (items.length - 1 - (position - 1) >= 0)
                System.arraycopy(items, position - 1 + 1, items, position - 1,
                        items.length - 1 - (position - 1));
            items[items.length - 1] = null;
        }
    }
}
