package com.peregud.join_sql_db.service;

import com.peregud.join_sql_db.model.PersonAddress;
import com.peregud.join_sql_db.repository.DAOPersonAddress;
import com.peregud.join_sql_db.repository.DAOPersonAddressImpl;
import com.peregud.join_sql_db.view.PersonAddressView;
import com.peregud.join_sql_db.view.PersonView;

import java.sql.SQLException;

public class PersonAddressService implements DBDataService {
    private static final PersonAddressView PERSON_ADDRESS_VIEW;
    private static final DAOPersonAddress PERSON_ADDRESS;
    private final PersonAddress personAddress = new PersonAddress();
    private static final PersonView PERSON_VIEW;

    static {
        PERSON_ADDRESS_VIEW = new PersonAddressView();
        PERSON_ADDRESS = new DAOPersonAddressImpl();
        PERSON_VIEW = new PersonView();
    }

    @Override
    public void saveNewData() {
        try {
            PERSON_ADDRESS.save(new PersonAddress(1, 1));
            PERSON_ADDRESS.save(new PersonAddress(1, 2));
            PERSON_ADDRESS.save(new PersonAddress(2, 2));
            PERSON_ADDRESS.save(new PersonAddress(2, 3));
            PERSON_ADDRESS.save(new PersonAddress(3, 3));
            PERSON_ADDRESS.save(new PersonAddress(4, 4));
            PERSON_ADDRESS.save(new PersonAddress(4, 5));
            PERSON_ADDRESS.save(new PersonAddress(5, 5));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            PERSON_VIEW.displayByID(id);
            PERSON_ADDRESS_VIEW.displayByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            PERSON_VIEW.displayByID(id);
            PERSON_ADDRESS_VIEW.displayByID(id);
            personAddress.setAddressID(change);
            personAddress.setPersonID(id);
            PERSON_ADDRESS.update(personAddress);
            PERSON_VIEW.displayByID(id);
            PERSON_ADDRESS_VIEW.displayByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            PERSON_ADDRESS.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            PERSON_ADDRESS_VIEW.displayAllData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
