package com.peregud.iteratorpattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StoreManager {
    private final FirstStore firstStore;
    private final SecondStore secondStore;

    public void printProducts() {
        Iterator firstStoreIterator = firstStore.createIterator();
        Iterator secondStoreIterator = secondStore.createIterator();
        printProducts(firstStoreIterator);
        System.out.println();
        printProducts(secondStoreIterator);
    }

    private void printProducts(Iterator iterator) {
        while (iterator.hasNext()) {
            ProductItem productItem = (ProductItem) iterator.next();
            System.out.print(productItem.getId() + ": ");
            System.out.print(productItem.getName() + ", ");
            System.out.print(productItem.getPrice() + ", ");
            System.out.println(productItem.isInStock());
        }
    }
}
