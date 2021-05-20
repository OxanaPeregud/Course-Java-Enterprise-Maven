package com.peregud.sessionfactory.dao;

import com.peregud.sessionfactory.exceptions.DaoException;

import java.sql.SQLException;

public interface DAO<T> {

    T save(T t) throws SQLException, DaoException;

    T get(int id) throws SQLException, DaoException;

    void update(int id, int value) throws SQLException, DaoException, NoSuchFieldException, IllegalAccessException;

    void delete(int id) throws SQLException, DaoException;

}
