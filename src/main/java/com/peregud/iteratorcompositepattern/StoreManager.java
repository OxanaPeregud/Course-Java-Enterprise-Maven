package com.peregud.iteratorcompositepattern;

import java.util.ArrayList;
import java.util.List;

public class StoreManager implements Stores {
    private final List<Stores> storesList;

    public StoreManager() {
        this.storesList = new ArrayList<>();
    }

    @Override
    public void printProducts() {
        storesList.forEach(Stores::printProducts);
    }

    public void addStore(Stores store) {
        storesList.add(store);
    }

    public void removeStore(Stores store) {
        storesList.remove(store);
    }
}
