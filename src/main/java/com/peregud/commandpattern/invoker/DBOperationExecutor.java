package com.peregud.commandpattern.invoker;

import com.peregud.commandpattern.command.DBOperation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBOperationExecutor<T> {
    private final List<DBOperation<T>> DBOperations = new ArrayList<>();

    public T executeOperation(DBOperation<T> DBOperation, T t, Class<T> clazz, int id) throws SQLException {
        DBOperations.add(DBOperation);
        return DBOperation.execute(t, clazz, id);
    }
}
