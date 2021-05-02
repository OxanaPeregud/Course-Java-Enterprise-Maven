package com.peregud.lombok_sql_join.view;

import com.peregud.lombok_sql_join.model.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonView implements DBView<Person> {

    @Override
    public void displayByID(Person person) throws SQLException {
        if (person != null) {
            System.out.println(person);
        }
    }

    @Override
    public void displayAllData(List<Person> list) throws SQLException {
        if (list != null) {
            list.forEach(System.out::println);
        }
    }
}
