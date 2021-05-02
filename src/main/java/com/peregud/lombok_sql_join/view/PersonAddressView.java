package com.peregud.lombok_sql_join.view;

import com.peregud.lombok_sql_join.model.PersonAddress;

import java.sql.SQLException;
import java.util.List;

public class PersonAddressView implements DBView<PersonAddress> {

    @Override
    public void displayByID(PersonAddress personAddress) throws SQLException {
        if (personAddress != null) {
            System.out.println(personAddress);
        }
    }

    @Override
    public void displayAllData(List<PersonAddress> list) throws SQLException {
        if (list != null) {
            list.forEach(System.out::println);
        }
    }
}
