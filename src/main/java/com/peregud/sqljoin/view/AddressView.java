package com.peregud.sqljoin.view;

import com.peregud.sqljoin.model.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressView implements DBView<Address> {

    @Override
    public void displayByID(Address address) throws SQLException {
        if (address != null) {
            System.out.println(address);
        } else {
            System.out.println("There is no address under entered ID");
        }
    }

    @Override
    public void displayAllData(List<Address> list) throws SQLException {
        if (list != null) {
            list.forEach(System.out::println);
        }
    }
}
