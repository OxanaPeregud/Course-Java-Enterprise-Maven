package com.peregud.commandpattern.command;

import java.sql.SQLException;

public class NoDBOperation<T> implements DBOperation<T> {

    @Override
    public T execute(T t, Class<T> clazz, int id) throws SQLException {
        return null;
    }
}
