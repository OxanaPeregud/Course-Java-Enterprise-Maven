package com.peregud.daoutil.service;

import com.peregud.daoutil.model.Person;
import com.peregud.daoutil.repository.DAOPersonRepository;
import com.peregud.daoutil.repository.DAOPersonRepositoryImpl;
import com.peregud.daoutil.view.PersonView;

import java.sql.SQLException;
import java.util.List;

public class PersonService implements DBDataService<Person> {
    private static final PersonView PERSON_VIEW = new PersonView();
    private static final DAOPersonRepository PERSON = new DAOPersonRepositoryImpl();
    private final Person person = new Person();

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
}
