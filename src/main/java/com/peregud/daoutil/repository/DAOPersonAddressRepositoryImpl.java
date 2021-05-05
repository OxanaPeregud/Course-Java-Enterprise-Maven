package com.peregud.daoutil.repository;

import com.peregud.daoutil.model.PersonAddress;
import com.peregud.daoutil.util.DAOUtil;
import com.peregud.daoutil.util.ReflectionUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DAOPersonAddressRepositoryImpl implements DAOPersonAddressRepository {
    private static final String SQL_SAVE = "INSERT INTO personDB.person_address(person_id, address_id)" + "VALUE (?, ?)";
    private static final String SQL_GET = "SELECT * FROM personDB.person_address WHERE person_id = ";
    private static final String SQL_UPDATE = "UPDATE personDB.person_address SET address_id = ? WHERE person_id = ?";
    private static final String SQL_DELETE = "DELETE FROM personDB.person_address WHERE person_id = ";
    private final DAOUtil<PersonAddress> DAOUtil = new DAOUtil<>();

    @Override
    public void save(PersonAddress personAddress) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, personAddress.getPersonID());
        param.put(2, personAddress.getAddressID());
        DAOUtil.executePreparedStatement(SQL_SAVE, param);
    }

    @Override
    public PersonAddress get(Serializable id) {
        Map<String, String> param = new HashMap<>();
        param.put(ReflectionUtil.annotatedField(PersonAddress.class, "personID"), "personID");
        param.put(ReflectionUtil.annotatedField(PersonAddress.class, "addressID"), "addressID");
        PersonAddress personAddress = new PersonAddress();
        DAOUtil.executeResultSet(SQL_GET + id, param, PersonAddress.class, personAddress);
        return personAddress;
    }

    @Override
    public void update(PersonAddress personAddress) {
        Map<Integer, Object> param = new HashMap<>();
        param.put(1, personAddress.getAddressID());
        param.put(2, personAddress.getPersonID());
        DAOUtil.executePreparedStatement(SQL_UPDATE, param);
    }

    @Override
    public void delete(Serializable id) {
        DAOUtil.executeStatement(SQL_DELETE + id);
    }
}
