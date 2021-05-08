package com.peregud.dbprocedure.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T> {

    void save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    void delete(Serializable id) throws SQLException;

}
