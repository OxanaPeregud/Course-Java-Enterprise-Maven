package com.peregud.commandpattern.command;

import java.sql.SQLException;

@FunctionalInterface
public interface DBOperation<T> {

    T execute(T t, Class<T> clazz, int id) throws SQLException;

}
