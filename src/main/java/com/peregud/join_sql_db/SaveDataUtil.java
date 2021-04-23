package com.peregud.join_sql_db;

import java.sql.SQLException;
import java.util.List;

public class SaveDataUtil {

    public static void savePeople(List<People> people) throws SQLException {
        DAOPeople daoPeople = new DAOPeopleImpl();
        for (People person : people) {
            daoPeople.save(person);
        }
    }

    public static void saveAddress(List<Address> address) throws SQLException {
        DAOAddress daoAddress = new DAOAddressImpl();
        for (Address add : address) {
            daoAddress.save(add);
        }
    }

    public static void savePeopleAddress(List<PeopleAddress> address) throws SQLException {
        DAOPeopleAddress daoPeopleAddress = new DAOPeopleAddressImpl();
        for (PeopleAddress peopleAdd : address) {
            daoPeopleAddress.save(peopleAdd);
        }
    }
}
