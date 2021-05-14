package com.peregud.sqljoin.view;

import com.peregud.sqljoin.model.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonView implements DBView<Person> {

    @Override
    public void displayByID(Person person) throws SQLException {
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("There is no person under entered ID");
        }
    }

    @Override
    public void displayAllData(List<Person> list) throws SQLException {
        if (list != null) {
            list.forEach(System.out::println);
        }
    }
}
