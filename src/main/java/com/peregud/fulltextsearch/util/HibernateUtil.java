package com.peregud.fulltextsearch.util;

import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@UtilityClass
public class HibernateUtil {
    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory entityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("com.peregud");
        }
        return entityManagerFactory;
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory().createEntityManager();
    }

    public void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
