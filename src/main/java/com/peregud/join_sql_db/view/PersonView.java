package com.peregud.join_sql_db.view;

import com.peregud.join_sql_db.repository.DAOPerson;
import com.peregud.join_sql_db.repository.DAOPersonImpl;

import java.sql.SQLException;

public class PersonView implements DBView {
    private static final DAOPerson PERSON;

    static {
        PERSON = new DAOPersonImpl();
    }

    @Override
    public void displayByID(int id) throws SQLException {
        if (PERSON.get(id) != null) {
            System.out.println(PERSON.get(id));
        } else {
            System.out.println("There is no person under entered ID");
        }
    }

    @Override
    public void displayAllData() throws SQLException {
        PERSON.getAll().forEach(System.out::println);
    }
}
