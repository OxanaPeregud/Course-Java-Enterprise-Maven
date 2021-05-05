package com.peregud.daoutil.repository;

import com.peregud.daoutil.model.Address;
import com.peregud.daoutil.util.DAOUtil;
import com.peregud.daoutil.util.ReflectionUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DAOAddressRepositoryImpl implements DAOAddressRepository {
    private static final String SQL_SAVE = "INSERT INTO personDB.address(address_id, street, house, apartment) " +
            "VALUE (?, ?, ?, ?)";
    private static final String SQL_GET = "SELECT * FROM personDB.address WHERE address_id = ";
    private static final String SQL_UPDATE = "UPDATE personDB.address SET house = ? WHERE address_id = ?";
    private static final String SQL_DELETE = "DELETE FROM personDB.address WHERE address_id = ";
    private final DAOUtil<Address> DAOUtil = new DAOUtil<>();

    @Override
    public void save(Address address) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, address.getAddressID());
        param.put(2, address.getStreet());
        param.put(3, address.getHouse());
        param.put(4, address.getApartment());
        DAOUtil.executePreparedStatement(SQL_SAVE, param);
    }

    @Override
    public Address get(Serializable id) {
        Map<String, String> param = new HashMap<>();
        param.put(ReflectionUtil.annotatedField(Address.class, "addressID"), "addressID");
        param.put(ReflectionUtil.annotatedField(Address.class, "street"), "street");
        param.put(ReflectionUtil.annotatedField(Address.class, "house"), "house");
        param.put(ReflectionUtil.annotatedField(Address.class, "apartment"), "apartment");
        Address address = new Address();
        DAOUtil.executeResultSet(SQL_GET + id, param, Address.class, address);
        return address;
    }

    @Override
    public void update(Address address) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, address.getHouse());
        param.put(2, address.getAddressID());
        DAOUtil.executePreparedStatement(SQL_UPDATE, param);
    }

    @Override
    public void delete(Serializable id) {
        DAOUtil.executeStatement(SQL_DELETE + id);
    }
}
