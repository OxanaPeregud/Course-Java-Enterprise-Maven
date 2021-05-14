package com.peregud.sqljoin.view;

import com.peregud.sqljoin.model.Address;
import com.peregud.sqljoin.model.Person;
import com.peregud.sqljoin.model.PersonAddress;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PersonAddressView implements DBView<PersonAddress> {

    @Override
    public void displayByID(PersonAddress personAddress) throws SQLException {
        if (personAddress != null) {
            System.out.println(personAddress);
        } else {
            System.out.println("There is no person under entered ID");
        }
    }

    @Override
    public void displayAllData(List<PersonAddress> list) throws SQLException {
        if (list != null) {
            list.forEach(System.out::println);
        }
    }

    public void displayAllDataPersonAddress(Map<Person, Address> map) throws SQLException {
        if (map != null) {
            for (Map.Entry<Person, Address> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}
