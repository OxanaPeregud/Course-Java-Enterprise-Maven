package com.peregud.hibernate.util;

import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import java.util.List;

@UtilityClass
public class DataUtil {

    public <T> void persistData(List<T> list) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        for (T t : list) {
            entityManager.persist(t);
        }
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }

    public <T> T getData(int id, Class<T> clazz) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        T t = entityManager.find(clazz, id);
        entityManager.detach(t);
        HibernateUtil.close();
        return t;
    }
}
