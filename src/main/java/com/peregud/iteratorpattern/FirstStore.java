package com.peregud.iteratorpattern;

public class FirstStore implements OnlineStore {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private final ProductItem[] productItems;

    public FirstStore() {
        productItems = new ProductItem[MAX_ITEMS];
        addItem(1, "First Product 1", 20.5, true);
        addItem(2, "First Product 2", 12.1, false);
        addItem(3, "First Product 3", 9.7, true);
    }

    public void addItem(int id, String name, double price, boolean inStock) {
        ProductItem productItem = new ProductItem(id, name, price, inStock);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Can’t add item to product list");
        } else {
            productItems[numberOfItems] = productItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Iterator createIterator() {
        return new FirstStoreIterator(productItems);
    }
}
