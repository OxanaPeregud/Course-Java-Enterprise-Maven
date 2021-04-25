package com.peregud.join_sql_db;

import java.sql.SQLException;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws SQLException {
        DBCreatorUtil.createDatabase();
        SaveDataUtil.savePeople(CreatorUtil.createPeople());
        SaveDataUtil.saveAddress(CreatorUtil.createAddress());
        SaveDataUtil.savePeopleAddress(CreatorUtil.createPeopleAddressID());

        DAOPeopleImpl daoPeople = new DAOPeopleImpl();
        List<People> peopleFromDB = daoPeople.getAll();
        ChangeDataUtil.changePersonAge(peopleFromDB, peopleFromDB.size(), 2);
        ChangeDataUtil.changePersonAge(peopleFromDB, peopleFromDB.size() - 1, 2);
        daoPeople.delete(1);
        DBView<People> viewPeople = new DBView<>();
        viewPeople.display(peopleFromDB);

        DAOAddressImpl daoAddress = new DAOAddressImpl();
        List<Address> addressFromDB = daoAddress.getAll();
        ChangeDataUtil.changeHouse(addressFromDB, addressFromDB.size(), 1);
        ChangeDataUtil.changeHouse(addressFromDB, addressFromDB.size() - 1, 1);
        daoAddress.delete(1);
        DBView<Address> viewAddress = new DBView<>();
        viewAddress.display(addressFromDB);
    }
}
