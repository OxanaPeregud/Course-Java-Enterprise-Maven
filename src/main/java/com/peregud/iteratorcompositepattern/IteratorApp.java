package com.peregud.iteratorcompositepattern;

import com.peregud.iteratorcompositepattern.util.SessionUtil;

public class IteratorApp {
    public static void main(String[] args) {
        try {
            SessionUtil.openSession();

            FirstStore firstStore = new FirstStore();
            SecondStore secondStore = new SecondStore();
            StoreManager storeManager = new StoreManager();
            storeManager.addStore(firstStore);
            storeManager.addStore(secondStore);
            storeManager.printProducts();
            storeManager.removeStore(secondStore);
            storeManager.printProducts();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SessionUtil.closeSession();
        }
    }
}
