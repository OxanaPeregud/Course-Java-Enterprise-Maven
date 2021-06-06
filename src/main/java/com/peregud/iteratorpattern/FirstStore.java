package com.peregud.iteratorpattern;

import com.peregud.iteratorpattern.util.DBUtil;

import static com.peregud.iteratorpattern.types.Store.FIRST_STORE;

public class FirstStore implements OnlineStore {
    private final ProductItem[] productItems;

    public FirstStore() {
        productItems = addItems();
    }

    public ProductItem[] addItems() {
        return DBUtil.getProducts(FIRST_STORE.getStore()).toArray(new ProductItem[0]);
    }

    public Iterator createIterator() {
        return new FirstStoreIterator(productItems);
    }
}
