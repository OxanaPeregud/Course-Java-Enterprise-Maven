package com.peregud.transactionisolation.util;

import lombok.experimental.UtilityClass;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.util.List;

@UtilityClass
public class DataUtil {

    public <T> void saveData(List<T> list) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            list.forEach(entityManager::merge);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public <T> T get(Class<T> clazz, int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        T t = null;
        try {
            t = entityManager.find(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return t;
    }

    public <T> void updateData(List<T> list, int transactionIsolationLevel) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Session session = entityManager.unwrap(Session.class);
            Connection connection = ConnectorUtil.getConnection();
            connection.setTransactionIsolation(transactionIsolationLevel);
            list.forEach(session::merge);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
