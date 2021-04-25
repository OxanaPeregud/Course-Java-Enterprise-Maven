package com.peregud.join_sql_db;

import java.sql.SQLException;
import java.util.List;

public class ChangeDataUtil {

    public static void changePersonAge(List<People> list, int index, int changeAge) throws SQLException {
        DAOPeople daoPeople = new DAOPeopleImpl();
        People person = new People();
        person.setAge(list.get(index - 1).getAge() + changeAge);
        person.setId(index);
        daoPeople.update(person);
    }

    public static void changeHouse(List<Address> list, int index, int changeHouse) throws SQLException {
        DAOAddress daoAddress = new DAOAddressImpl();
        Address address = new Address();
        address.setHouse(list.get(index - 1).getHouse() + changeHouse);
        address.setId(index);
        daoAddress.update(address);
    }
}
