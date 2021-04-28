package com.peregud.join_sql_db.view;

import com.peregud.join_sql_db.model.Address;
import com.peregud.join_sql_db.model.PersonAddress;

import java.sql.SQLException;
import java.util.List;

public class PersonAddressView implements DBView<PersonAddress> {

    @Override
    public void displayByID(PersonAddress personAddress) throws SQLException {
        if (personAddress != null) {
            System.out.println(personAddress);
        } else {
            System.out.println("There is no person under entered ID");
        }
    }

    public void displayAddressByID(PersonAddress personAddress, Address address) throws SQLException {
        if (personAddress != null) {
            System.out.println(address);
        } else {
            System.out.println("There is no employee address under entered ID");
        }
    }

    @Override
    public void displayAllData(List<PersonAddress> list) throws SQLException {
        if (list != null) {
            list.forEach(System.out::println);
        }
    }
}
