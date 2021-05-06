package com.peregud.daoutil.service;

import com.peregud.daoutil.model.Person;
import com.peregud.daoutil.repository.DAOPersonRepository;
import com.peregud.daoutil.repository.DAOPersonRepositoryImpl;
import com.peregud.daoutil.view.PersonView;

import java.sql.SQLException;
import java.util.List;

public class PersonService implements DBDataService<Person> {
    private final PersonView personView = new PersonView();
    private final DAOPersonRepository daoPerson = new DAOPersonRepositoryImpl();
    private final Person person = new Person();

    @Override
    public void saveNewData(List<Person> list) {
        try {
            for (Person person : list) {
                daoPerson.save(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            personView.displayByID(daoPerson.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            person.setAge(daoPerson.get(id).getAge() + change);
            person.setPersonID(id);
            daoPerson.update(person);
            personView.displayByID(daoPerson.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            daoPerson.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
