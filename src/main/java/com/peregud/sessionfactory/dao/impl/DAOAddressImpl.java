package com.peregud.sessionfactory.dao.impl;

import com.peregud.sessionfactory.model.Address;
import com.peregud.sessionfactory.dao.DAOAddress;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.util.DataUtil;

public class DAOAddressImpl implements DAOAddress {

    @Override
    public Address save(Address address) throws DaoException {
        return DataUtil.save(address);
    }

    @Override
    public Address get(int id) throws DaoException {
        return DataUtil.get(Address.class, id);
    }

    @Override
    public void update(int id, int value)
            throws DaoException, NoSuchFieldException, IllegalAccessException {
        DataUtil.update(Address.class, id, "house", value);
    }

    @Override
    public void delete(int id) throws DaoException {
        DataUtil.delete(Address.class, id);
    }
}
