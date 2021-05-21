package com.peregud.sessionfactory.dao.impl;

import com.peregud.sessionfactory.dao.DAO;
import com.peregud.sessionfactory.dao.DAOAddress;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.model.Address;

import java.sql.SQLException;

public class DAOAddressImpl extends DAOImpl<Address> implements DAOAddress {
    private final DAO<Address> dao = new DAOImpl<>();

    @Override
    public Address save(Address address) throws DaoException, SQLException {
        return dao.save(address);
    }

    @Override
    public Address get(Class<Address> clazz, int id) throws DaoException, SQLException {
        return dao.get(Address.class, id);
    }

    @Override
    public void update(Class<Address> clazz, int id, String fieldName, int value)
            throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        dao.update(Address.class, id, fieldName, value);
    }

    @Override
    public void delete(Class<Address> clazz, int id) throws DaoException, SQLException {
        dao.delete(Address.class, id);
    }
}
