package com.peregud.sqljoin.service;

import com.peregud.sqljoin.model.Person;
import com.peregud.sqljoin.repository.DAOPerson;
import com.peregud.sqljoin.repository.DAOPersonAddress;
import com.peregud.sqljoin.repository.DAOPersonAddressImpl;
import com.peregud.sqljoin.repository.DAOPersonImpl;
import com.peregud.sqljoin.view.PersonView;

import java.sql.SQLException;
import java.util.List;

public class PersonService implements DBDataService<Person> {
    private static final PersonView PERSON_VIEW;
    private static final DAOPerson PERSON;
    private final Person person = new Person();
    private static final DAOPersonAddress PERSON_ADDRESS;

    static {
        PERSON_VIEW = new PersonView();
        PERSON = new DAOPersonImpl();
        PERSON_ADDRESS = new DAOPersonAddressImpl();
    }

    @Override
    public void saveNewData(List<Person> list) {
        try {
            for (Person person : list) {
                PERSON.save(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            PERSON_VIEW.displayByID(PERSON.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            person.setAge(PERSON.get(id).getAge() + change);
            person.setPersonID(id);
            PERSON.update(person);
            PERSON_VIEW.displayByID(PERSON.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            PERSON.delete(id);
            PERSON_ADDRESS.delete(PERSON_ADDRESS.get(id).getPersonID());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            PERSON_VIEW.displayAllData(PERSON.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
