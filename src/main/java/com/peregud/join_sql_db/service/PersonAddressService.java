package com.peregud.join_sql_db.service;

import com.peregud.join_sql_db.model.PersonAddress;
import com.peregud.join_sql_db.repository.*;
import com.peregud.join_sql_db.view.AddressView;
import com.peregud.join_sql_db.view.PersonAddressView;
import com.peregud.join_sql_db.view.PersonView;

import java.sql.SQLException;
import java.util.List;

public class PersonAddressService implements DBDataService<PersonAddress> {
    private static final PersonAddressView PERSON_ADDRESS_VIEW;
    private static final DAOPersonAddress PERSON_ADDRESS;
    private final PersonAddress personAddress = new PersonAddress();
    private static final PersonView PERSON_VIEW;
    private static final DAOPerson PERSON;
    private static final DAOAddress ADDRESS;
    private static final AddressView ADDRESS_VIEW;

    static {
        PERSON_ADDRESS_VIEW = new PersonAddressView();
        PERSON_ADDRESS = new DAOPersonAddressImpl();
        PERSON_VIEW = new PersonView();
        PERSON = new DAOPersonImpl();
        ADDRESS = new DAOAddressImpl();
        ADDRESS_VIEW = new AddressView();
    }

    @Override
    public void saveNewData(List<PersonAddress> list) {
        try {
            for (PersonAddress personAddress : list) {
                PERSON_ADDRESS.save(personAddress);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            PERSON_VIEW.displayByID(PERSON.get(id));
            PERSON_ADDRESS_VIEW.displayAddressByID(PERSON_ADDRESS.get(id),
                    ADDRESS.get(PERSON_ADDRESS.get(id).getAddressID()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            PERSON_VIEW.displayByID(PERSON.get(id));
            PERSON_ADDRESS_VIEW.displayByID(PERSON_ADDRESS.get(id));
            personAddress.setAddressID(change);
            personAddress.setPersonID(id);
            PERSON_ADDRESS.update(personAddress);
            PERSON_VIEW.displayByID(PERSON.get(id));
            PERSON_ADDRESS_VIEW.displayByID(PERSON_ADDRESS.get(id));
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
            PERSON_ADDRESS_VIEW.displayAllData(PERSON_ADDRESS.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
