package com.peregud.sessionfactory.util;

import com.peregud.sessionfactory.exceptions.DaoException;
import lombok.experimental.UtilityClass;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.StoredProcedureQuery;

@UtilityClass
public class DataUtil {
    private final SessionUtil UTIL = new SessionUtil();
    private final Session SESSION = UTIL.openSession();
    private final Transaction TRANSACTION = SESSION.getTransaction();
    private final Logger LOG = Logger.getLogger(DataUtil.class);

    public <T> T save(T t) throws DaoException {
        try {
            TRANSACTION.begin();
            SESSION.save(t);
            TRANSACTION.commit();
        } catch (HibernateException e) {
            LOG.error("Error was thrown in DAO", e);
            TRANSACTION.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public <T> T load(Class<T> clazz, int id) throws DaoException {
        T t;
        try {
            TRANSACTION.begin();
            t = SESSION.load(clazz, id);
            TRANSACTION.commit();
        } catch (HibernateException e) {
            LOG.error("Error was thrown in DAO", e);
            TRANSACTION.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public <T> T find(Class<T> clazz, int id) throws DaoException {
        T t;
        try {
            TRANSACTION.begin();
            t = SESSION.get(clazz, id);
            TRANSACTION.commit();
        } catch (HibernateException e) {
            LOG.error("Error was thrown in DAO", e);
            TRANSACTION.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public <T> void delete(Class<T> clazz, int id) throws DaoException {
        try {
            TRANSACTION.begin();
            T t = SESSION.get(clazz, id);
            SESSION.delete(t);
            TRANSACTION.commit();
        } catch (HibernateException e) {
            LOG.error("Error was thrown in DAO", e);
            TRANSACTION.rollback();
            throw new DaoException(e);
        }
    }

    public void callProcedure(String procedure, int id) throws DaoException {
        try {
            TRANSACTION.begin();
            StoredProcedureQuery spQuery = SESSION.createNamedStoredProcedureQuery(procedure);
            spQuery.setParameter("id", id);
            spQuery.execute();
            TRANSACTION.commit();
        } catch (HibernateException e) {
            LOG.error("Error was thrown in DAO", e);
            TRANSACTION.rollback();
            throw new DaoException(e);
        }
    }
}
