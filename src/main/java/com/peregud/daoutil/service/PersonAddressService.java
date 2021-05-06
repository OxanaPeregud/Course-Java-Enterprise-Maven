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
    private final PersonAddressView personAddressView = new PersonAddressView();
    private final DAOPersonAddressRepository daoPersonAddress = new DAOPersonAddressRepositoryImpl();
    private final PersonAddress personAddress = new PersonAddress();
    private final PersonView personView = new PersonView();
    private final DAOPersonRepository person = new DAOPersonRepositoryImpl();

    @Override
    public void saveNewData(List<PersonAddress> list) {
        try {
            for (PersonAddress personAddress : list) {
                daoPersonAddress.save(personAddress);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            personAddressView.displayByID(daoPersonAddress.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            personView.displayByID(person.get(id));
            personAddressView.displayByID(daoPersonAddress.get(id));
            personAddress.setAddressID(change);
            personAddress.setPersonID(id);
            daoPersonAddress.update(personAddress);
            personView.displayByID(person.get(id));
            personAddressView.displayByID(daoPersonAddress.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            daoPersonAddress.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
