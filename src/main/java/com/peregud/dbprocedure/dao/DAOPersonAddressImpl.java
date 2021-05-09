package com.peregud.dbprocedure.dao;

import com.peregud.dbprocedure.model.PersonAddress;
import com.peregud.dbprocedure.util.DBUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DAOPersonAddressImpl implements DAOPersonAddress {
    private static final String SQL_SAVE = "INSERT INTO personDB.person_address(person_id, address_id)" + "VALUE (?, ?)";
    private static final String SQL_GET = "SELECT * FROM personDB.person_address WHERE person_id = ";
    private static final String SQL_UPDATE = "UPDATE personDB.person_address SET address_id = ? WHERE person_id = ?";
    private static final String SQL_DELETE = "DELETE FROM personDB.person_address WHERE person_id = ";

    @Override
    public PersonAddress save(PersonAddress personAddress) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, personAddress.getPersonID());
        param.put(2, personAddress.getAddressID());
        DBUtil.executePreparedStatement(SQL_SAVE, param);
        return personAddress;
    }

    @Override
    public PersonAddress get(Serializable id) {
        PersonAddress personAddress = new PersonAddress();
        return DBUtil.executeResultSet(SQL_GET + id, personAddress);
    }

    @Override
    public void update(PersonAddress personAddress) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, personAddress.getAddressID());
        param.put(2, personAddress.getPersonID());
        DBUtil.executePreparedStatement(SQL_UPDATE, param);
    }

    @Override
    public int delete(Serializable id) {
        return DBUtil.executeStatement(SQL_DELETE + id);
    }
}
