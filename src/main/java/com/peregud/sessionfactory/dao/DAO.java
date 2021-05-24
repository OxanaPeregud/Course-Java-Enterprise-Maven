package com.peregud.sessionfactory.dao;

import com.peregud.sessionfactory.exceptions.DaoException;

import java.sql.SQLException;

public interface DAO<T> {

    T save(T t) throws SQLException, DaoException;

    T get(Class<T> clazz, int id) throws SQLException, DaoException;

    void update(Class<T> clazz, int id, String fieldName, int value) throws SQLException, DaoException,
            NoSuchFieldException, IllegalAccessException;

    void delete(Class<T> clazz, int id) throws SQLException, DaoException;

    void callProcedure(String procedure, int id) throws DaoException;

}
