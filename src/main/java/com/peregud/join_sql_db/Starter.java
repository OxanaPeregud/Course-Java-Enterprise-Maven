package com.peregud.join_sql_db;

import com.peregud.join_sql_db.model.Address;
import com.peregud.join_sql_db.model.Person;
import com.peregud.join_sql_db.repository.DAOAddress;
import com.peregud.join_sql_db.repository.DAOAddressImpl;
import com.peregud.join_sql_db.repository.DAOPerson;
import com.peregud.join_sql_db.repository.DAOPersonImpl;
import com.peregud.join_sql_db.service.AddressService;
import com.peregud.join_sql_db.service.PersonService;
import com.peregud.join_sql_db.util.CreateDataUtil;
import com.peregud.join_sql_db.util.DBCreatorUtil;

import java.sql.SQLException;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws SQLException {
        DBCreatorUtil.createPersonAddressDatabase();
        PersonService personService = new PersonService();
        AddressService addressService = new AddressService();
        personService.saveNewData(CreateDataUtil.createPerson());
        addressService.saveNewData(CreateDataUtil.createAddress());

        DAOPerson daoPerson = new DAOPersonImpl();
        DAOAddress daoAddress = new DAOAddressImpl();

        List<Person> personFromDB = daoPerson.getAll();
        List<Address> addressFromDB = daoAddress.getAll();

        personService.updateData(personFromDB.size() - 1, 2);
        personService.updateData(personFromDB.size(), 2);

        addressService.updateData(addressFromDB.size() - 1, 1);
        addressService.updateData(addressFromDB.size(), 1);

        personService.deleteData(1);
        addressService.deleteData(1);

        personService.displayAllPersonAddress();
    }
}
