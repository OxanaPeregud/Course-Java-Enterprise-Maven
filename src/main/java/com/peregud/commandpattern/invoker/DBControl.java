package com.peregud.commandpattern.invoker;

import com.peregud.commandpattern.command.DBOperation;
import com.peregud.commandpattern.command.NoDBOperation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBControl<T> {
    private final List<DBOperation<T>> operations;

    @SuppressWarnings("unchecked")
    public DBControl(int numberOfOperations) {
        operations = Arrays.asList(new DBOperation[numberOfOperations]);
        NoDBOperation<T> noDBOperation = new NoDBOperation<>();
        for (int i = 0; i < numberOfOperations; i++) {
            operations.set(i, noDBOperation);
        }
    }

    public void setOperation(int choice, DBOperation<T> dbOperation) {
        operations.set(choice, dbOperation);
    }

    public void executeOperation(int choice, T t, Class<T> clazz, int id) throws SQLException {
        operations.get(choice).execute(t, clazz, id);
    }
}
