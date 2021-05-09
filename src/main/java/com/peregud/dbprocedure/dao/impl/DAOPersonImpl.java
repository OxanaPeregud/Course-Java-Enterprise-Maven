package com.peregud.dbprocedure.dao.impl;

import com.peregud.dbprocedure.dao.DAOPerson;
import com.peregud.dbprocedure.model.Person;
import com.peregud.dbprocedure.util.DBUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DAOPersonImpl implements DAOPerson {
    private static final String SQL_SAVE = "INSERT INTO personDB.person(person_id, first_name, last_name, age)" +
            "VALUE (?, ?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM personDB.person WHERE person_id = ";
    private static final String SQL_UPDATE = "UPDATE personDB.person SET age = ? WHERE person_id = ?";
    private static final String SQL_DELETE = "DELETE FROM personDB.person WHERE person_id = ";

    @Override
    public Person save(Person person) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, person.getPersonID());
        param.put(2, person.getFirstName());
        param.put(3, person.getLastName());
        param.put(4, person.getAge());
        DBUtil.executePreparedStatement(SQL_SAVE, param);
        return person;
    }

    @Override
    public Person get(Serializable id) {
        Person person = new Person();
        return DBUtil.executeResultSet(SQL_GET + id, person);
    }

    @Override
    public void update(Person person) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, person.getAge());
        param.put(2, person.getPersonID());
        DBUtil.executePreparedStatement(SQL_UPDATE, param);
    }

    @Override
    public void delete(Serializable id) {
        DBUtil.executeStatement(SQL_DELETE + id);
    }
}
