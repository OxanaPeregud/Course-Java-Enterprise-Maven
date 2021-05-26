package com.peregud.sessionfactory.dao.impl;

import com.peregud.sessionfactory.dao.DAOAddress;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.model.Address;

import java.sql.SQLException;

public class DAOAddressImpl extends AbstractDAO<Address> implements DAOAddress {

    @Override
    public Address save(Address address) throws DaoException, SQLException {
        return super.save(address);
    }

    @Override
    public Address get(Class<Address> clazz, int id) throws DaoException, SQLException {
        return super.get(Address.class, id);
    }

    @Override
    public void update(Class<Address> clazz, int id, String fieldName, int value)
            throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        super.update(Address.class, id, fieldName, value);
    }

    @Override
    public void delete(Class<Address> clazz, int id) throws DaoException, SQLException {
        super.delete(Address.class, id);
    }

    @Override
    public void callProcedure(String procedure, int id) throws DaoException {
        super.callProcedure(procedure, id);
    }
}
