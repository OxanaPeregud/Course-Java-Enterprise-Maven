package com.peregud.hibernate.util;

import com.peregud.hibernate.model.Address;
import com.peregud.hibernate.model.Person;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@UtilityClass
public class DataUtil {

    public <T> void persistData(List<T> list) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        for (T t : list) {
            entityManager.persist(t);
        }
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }

    public <T> T findData(Class<T> clazz, int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        T t = entityManager.find(clazz, id);
        entityManager.detach(t);
        HibernateUtil.close();
        return t;
    }

    public <T> void removeData(Class<T> clazz, int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        T t = entityManager.find(clazz, id);
        entityManager.remove(t);
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }

    public void callProcedure(String procedure, int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        StoredProcedureQuery spQuery =
                entityManager.createNamedStoredProcedureQuery(procedure);
        spQuery.setParameter("id", id);
        spQuery.execute();
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }

    public void updateAge(int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        Person person = entityManager.find(Person.class, id);
        person.setAge(person.getAge() + 1);
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }

    public void updateAddress(int id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, id);
        address.setHouse(address.getHouse() + 1);
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }
}
