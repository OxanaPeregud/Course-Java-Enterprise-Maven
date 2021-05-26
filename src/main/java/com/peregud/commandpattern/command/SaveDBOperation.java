package com.peregud.commandpattern.command;

import com.peregud.commandpattern.receiver.DB;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class SaveDBOperation<T> implements DBOperation<T> {
    private final DB<T> DB;

    @Override
    public T execute(T t, Class<T> clazz, int id) throws SQLException {
        return DB.save(t);
    }
}
