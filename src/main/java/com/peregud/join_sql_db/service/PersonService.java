package com.peregud.join_sql_db.service;

import com.peregud.join_sql_db.model.Person;
import com.peregud.join_sql_db.repository.DAOPerson;
import com.peregud.join_sql_db.repository.DAOPersonAddress;
import com.peregud.join_sql_db.repository.DAOPersonAddressImpl;
import com.peregud.join_sql_db.repository.DAOPersonImpl;
import com.peregud.join_sql_db.view.PersonView;

import java.sql.SQLException;

public class PersonService implements DBDataService {
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
    public void saveNewData() {
        try {
            PERSON.save(new Person("James", "Smith", 30));
            PERSON.save(new Person("Robert", "Johnson", 15));
            PERSON.save(new Person("Michael", "Williams", 22));
            PERSON.save(new Person("David", "Brown", 37));
            PERSON.save(new Person("Richard", "Miller", 25));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            PERSON_VIEW.displayByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            person.setAge(PERSON.get(id).getAge() + change);
            person.setId(id);
            PERSON.update(person);
            PERSON_VIEW.displayByID(id);
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
            PERSON_VIEW.displayAllData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}