package com.peregud.iteratorcompositepattern;

import com.peregud.iteratorcompositepattern.util.DBUtil;
import com.peregud.iteratorcompositepattern.util.PrintProductsUtil;

import java.util.List;

import static com.peregud.iteratorcompositepattern.types.Store.SECOND_STORE;

public class SecondStore implements OnlineStore, Stores {
    private final List<ProductItem> productItems;

    public SecondStore() {
        productItems = addItems();
    }

    public List<ProductItem> addItems() {
        return DBUtil.getProducts(SECOND_STORE.getStore());
    }

    public Iterator createIterator() {
        return new SecondStoreIterator(productItems);
    }

    @Override
    public void printProducts() {
        PrintProductsUtil.printProducts(createIterator());
    }
}
