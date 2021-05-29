package com.peregud.commandpattern.receiver;

import com.peregud.commandpattern.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class DB<T> {
    private final EntityManager entityManager = HibernateUtil.createEntityManager();
    private final Logger log = Logger.getLogger(DB.class);

    public T save(T t, Class<T> clazz, int id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return t;
    }

    public T find(T t, Class<T> clazz, int id) {
        try {
            entityManager.getTransaction().begin();
            t = entityManager.find(clazz, id);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return t;
    }

    public T delete(T t, Class<T> clazz, int id) {
        try {
            entityManager.getTransaction().begin();
            t = entityManager.find(clazz, id);
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return t;
    }
}
