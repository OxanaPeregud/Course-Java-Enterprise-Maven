package com.peregud.iteratorcompositepattern;

import com.peregud.iteratorcompositepattern.util.DBUtil;
import com.peregud.iteratorcompositepattern.util.PrintProductsUtil;

import static com.peregud.iteratorcompositepattern.types.Store.FIRST_STORE;

public class FirstStore implements OnlineStore, Stores {
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

    @Override
    public void printProducts() {
        PrintProductsUtil.printProducts(createIterator());
    }
}
