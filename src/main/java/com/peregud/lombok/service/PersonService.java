package com.peregud.lombok.service;

import com.peregud.lombok.model.Person;
import com.peregud.lombok.repository.DAOPersonRepository;
import com.peregud.lombok.repository.DAOPersonRepositoryImpl;
import com.peregud.lombok.view.PersonView;

import java.sql.SQLException;
import java.util.List;

public class PersonService implements DBDataService<Person> {
    private static final PersonView PERSON_VIEW;
    private static final DAOPersonRepository PERSON;
    private final Person person = new Person();

    static {
        PERSON_VIEW = new PersonView();
        PERSON = new DAOPersonRepositoryImpl();
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
