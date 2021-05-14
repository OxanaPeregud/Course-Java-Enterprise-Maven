package com.peregud.dbprocedure.dao.impl;

import com.peregud.dbprocedure.dao.DAOAddress;
import com.peregud.dbprocedure.model.Address;
import com.peregud.dbprocedure.util.DBUtil;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DAOAddressImpl implements DAOAddress {
    private static final String SQL_SAVE = "INSERT INTO personDB.address(address_id, street, house, apartment) " +
            "VALUE (?, ?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM personDB.address WHERE address_id = ";
    private static final String SQL_UPDATE = "UPDATE personDB.address SET house = ? WHERE address_id = ?";
    private static final String SQL_DELETE = "DELETE FROM personDB.address WHERE address_id = ";
    private DataSource ds;

    public DAOAddressImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Address save(Address address) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, address.getAddressID());
        param.put(2, address.getStreet());
        param.put(3, address.getHouse());
        param.put(4, address.getApartment());
        DBUtil.executePreparedStatement(SQL_SAVE, param);
        return address;
    }

    @Override
    public Address get(Serializable id) {
        Address address = new Address();
        return DBUtil.executeResultSet(SQL_GET + id, address);
    }

    @Override
    public void update(Address address) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, address.getHouse());
        param.put(2, address.getAddressID());
        DBUtil.executePreparedStatement(SQL_UPDATE, param);
    }

    @Override
    public void delete(Serializable id) {
        DBUtil.executeStatement(SQL_DELETE + id);
    }
}
