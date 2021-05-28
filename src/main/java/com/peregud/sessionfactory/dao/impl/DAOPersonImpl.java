package com.peregud.sessionfactory.dao.impl;

import com.peregud.sessionfactory.dao.DAOPerson;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.model.Person;
import org.hibernate.ReplicationMode;

import java.sql.SQLException;

public class DAOPersonImpl extends AbstractDAO<Person> implements DAOPerson {

    @Override
    public Person save(Person person) throws DaoException, SQLException {
        return super.save(person);
    }

    @Override
    public Person get(Class<Person> clazz, int id) throws DaoException, SQLException {
        return super.get(Person.class, id);
    }

    @Override
    public void update(Class<Person> clazz, int id, String fieldName, int value)
            throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        super.update(Person.class, id, fieldName, value);
    }

    @Override
    public void delete(Class<Person> clazz, int id) throws DaoException, SQLException {
        super.delete(Person.class, id);
    }

    @Override
    public void callProcedure(String procedure, int id) throws DaoException {
        super.callProcedure(procedure, id);
    }

    @Override
    public void replicate(Person person, ReplicationMode replicationMode) throws DaoException {
        super.replicate(person, replicationMode);
    }
}
