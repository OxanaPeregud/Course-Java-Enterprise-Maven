package com.peregud.abstractfactorypattern.util;

import lombok.experimental.UtilityClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@UtilityClass
public class DBUtil {

    public List<?> getData(String value, String clazz, String idName, int brandId) {
        SessionUtil util = new SessionUtil();
        Session session = util.openSession();
        Transaction transaction = session.getTransaction();
        List<?> products = null;
        try {
            transaction.begin();
            products = session
                    .createQuery("select " + value + " from " + clazz + " where " + idName + " = " + brandId)
                    .getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            util.closeSession();
        }
        return products;
    }
}


