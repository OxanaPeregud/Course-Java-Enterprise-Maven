package com.peregud.sessionfactory.dao.impl;

import com.peregud.sessionfactory.dao.DAO;
import com.peregud.sessionfactory.dao.DAOPerson;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.model.Person;

import java.sql.SQLException;

public class DAOPersonImpl extends DAOImpl<Person> implements DAOPerson {
    private final DAO<Person> dao = new DAOImpl<>();

    @Override
    public Person save(Person person) throws DaoException, SQLException {
        return dao.save(person);
    }

    @Override
    public Person get(Class<Person> clazz, int id) throws DaoException, SQLException {
        return dao.get(Person.class, id);
    }

    @Override
    public void update(Class<Person> clazz, int id, String fieldName, int value)
            throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        dao.update(Person.class, id, fieldName, value);
    }

    @Override
    public void delete(Class<Person> clazz, int id) throws DaoException, SQLException {
        dao.delete(Person.class, id);
    }
}
