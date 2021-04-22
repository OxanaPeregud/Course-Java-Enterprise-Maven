package com.peregud.join_sql_db;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(int id) throws SQLException;

    List<T> getAll() throws SQLException;

}
