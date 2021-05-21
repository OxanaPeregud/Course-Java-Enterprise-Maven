package com.peregud.sessionfactory.dao.impl;

import com.peregud.sessionfactory.dao.DAO;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.util.SessionUtil;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.Field;
import java.sql.SQLException;

public class DAOImpl<T> implements DAO<T> {
    @Getter
    private static final SessionUtil UTIL = new SessionUtil();
    private final Session session = UTIL.openSession();
    private final Transaction transaction = session.getTransaction();
    private final Logger log = Logger.getLogger(DAOImpl.class);

    @Override
    public T save(T t) throws SQLException, DaoException {
        try {
            transaction.begin();
            session.save(t);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    @Override
    public T get(Class<T> clazz, int id) throws SQLException, DaoException {
        T t;
        try {
            transaction.begin();
            t = session.get(clazz, id);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return t;
    }


    @Override
    public void update(Class<T> clazz, int id, String fieldName, int value) throws SQLException, DaoException,
            NoSuchFieldException, IllegalAccessException {
        try {
            transaction.begin();
            T t = session.get(clazz, id);
            Field field = t.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setInt(t, value);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Class<T> clazz, int id) throws SQLException, DaoException {
        try {
            transaction.begin();
            T t = session.get(clazz, id);
            session.delete(t);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
    }

    public void callProcedure(String procedure, int id) throws DaoException {
        try {
            transaction.begin();
            StoredProcedureQuery spQuery = session.createNamedStoredProcedureQuery(procedure);
            spQuery.setParameter("id", id);
            spQuery.execute();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error was thrown in DAO", e);
            transaction.rollback();
            throw new DaoException(e);
        }
    }
}
