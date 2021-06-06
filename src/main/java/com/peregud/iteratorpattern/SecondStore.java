package com.peregud.iteratorpattern;

import com.peregud.iteratorpattern.util.DBUtil;

import java.util.List;

import static com.peregud.iteratorpattern.types.Store.SECOND_STORE;

public class SecondStore implements OnlineStore {
    private final List<ProductItem> productItems;

    public SecondStore() {
        productItems = DBUtil.getProducts(SECOND_STORE.getStore());
    }

    public Iterator createIterator() {
        return new SecondStoreIterator(productItems);
    }
}
