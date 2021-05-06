package com.peregud.daoutil.repository;

import com.peregud.daoutil.model.Person;
import com.peregud.daoutil.util.DAOUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DAOPersonRepositoryImpl implements DAOPersonRepository {
    private static final String SQL_SAVE = "INSERT INTO personDB.person(person_id, first_name, last_name, age)" +
            "VALUE (?, ?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM personDB.person WHERE person_id = ";
    private static final String SQL_UPDATE = "UPDATE personDB.person SET age = ? WHERE person_id = ?";
    private static final String SQL_DELETE = "DELETE FROM personDB.person WHERE person_id = ";
    private final DAOUtil<Person> DAOUtil = new DAOUtil<>();

    @Override
    public void save(Person person) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, person.getPersonID());
        param.put(2, person.getFirstName());
        param.put(3, person.getLastName());
        param.put(4, person.getAge());
        DAOUtil.executePreparedStatement(SQL_SAVE, param);
    }

    @Override
    public Person get(Serializable id) {
        Person person = new Person();
        return DAOUtil.executeResultSet(SQL_GET + id, person);
    }

    @Override
    public void update(Person person) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, person.getAge());
        param.put(2, person.getPersonID());
        DAOUtil.executePreparedStatement(SQL_UPDATE, param);
    }

    @Override
    public void delete(Serializable id) {
        DAOUtil.executeStatement(SQL_DELETE + id);
    }
}
