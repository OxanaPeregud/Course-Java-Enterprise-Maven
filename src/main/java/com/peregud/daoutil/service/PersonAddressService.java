package com.peregud.daoutil.service;

import com.peregud.daoutil.model.PersonAddress;
import com.peregud.daoutil.repository.DAOPersonAddressRepository;
import com.peregud.daoutil.repository.DAOPersonAddressRepositoryImpl;
import com.peregud.daoutil.repository.DAOPersonRepository;
import com.peregud.daoutil.repository.DAOPersonRepositoryImpl;
import com.peregud.daoutil.view.PersonAddressView;
import com.peregud.daoutil.view.PersonView;

import java.sql.SQLException;
import java.util.List;

public class PersonAddressService implements DBDataService<PersonAddress> {
    private static final PersonAddressView PERSON_ADDRESS_VIEW = new PersonAddressView();
    private static final DAOPersonAddressRepository PERSON_ADDRESS = new DAOPersonAddressRepositoryImpl();
    private final PersonAddress personAddress = new PersonAddress();
    private static final PersonView PERSON_VIEW = new PersonView();
    private static final DAOPersonRepository PERSON = new DAOPersonRepositoryImpl();

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
            PERSON_ADDRESS_VIEW.displayByID(PERSON_ADDRESS.get(id));
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
}
