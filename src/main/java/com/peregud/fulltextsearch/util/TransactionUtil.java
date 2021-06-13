package com.peregud.fulltextsearch.util;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransactionUtil {

    protected static void inTransaction(EntityManager entityManager, Consumer<EntityTransaction> consumer) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            consumer.accept(transaction);
            transaction.commit();
        } catch (Throwable t) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw t;
        }
    }
}
