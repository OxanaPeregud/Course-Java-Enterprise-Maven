package com.peregud.iteratorpattern;

import com.peregud.iteratorpattern.util.DBUtil;
import com.peregud.iteratorpattern.util.SessionUtil;

public class IteratorApp {
    public static void main(String[] args) {
        try {

            FirstStore firstStore = new FirstStore();
            SecondStore secondStore = new SecondStore();
            StoreManager storeManager = new StoreManager(firstStore, secondStore);
            storeManager.printProducts();

            DBUtil.getProducts("first_store");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SessionUtil.closeSession();
        }
    }
}
