package com.peregud.sessionfactory.dao.impl;

import com.peregud.sessionfactory.model.Person;
import com.peregud.sessionfactory.dao.DAOPerson;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.util.DataUtil;

public class DAOPersonImpl implements DAOPerson {

    @Override
    public Person save(Person person) throws DaoException {
        return DataUtil.save(person);
    }

    @Override
    public Person get(int id) throws DaoException {
        return DataUtil.get(Person.class, id);
    }

    @Override
    public void update(int id, int value)
            throws DaoException, NoSuchFieldException, IllegalAccessException {
        DataUtil.update(Person.class, id, "age", value);
    }

    @Override
    public void delete(int id) throws DaoException {
        DataUtil.delete(Person.class, id);
    }
}
