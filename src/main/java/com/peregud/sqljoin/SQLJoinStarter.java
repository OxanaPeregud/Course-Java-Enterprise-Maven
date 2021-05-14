package com.peregud.sqljoin;

import com.peregud.sqljoin.model.Address;
import com.peregud.sqljoin.model.Person;
import com.peregud.sqljoin.repository.DAOAddress;
import com.peregud.sqljoin.repository.DAOAddressImpl;
import com.peregud.sqljoin.repository.DAOPerson;
import com.peregud.sqljoin.repository.DAOPersonImpl;
import com.peregud.sqljoin.service.AddressService;
import com.peregud.sqljoin.service.PersonAddressService;
import com.peregud.sqljoin.service.PersonService;
import com.peregud.sqljoin.util.CreateDataUtil;
import com.peregud.sqljoin.util.DBCreatorUtil;

import java.sql.SQLException;
import java.util.List;

public class SQLJoinStarter {
    public static void start() throws SQLException {
        DBCreatorUtil.createPersonAddressDatabase();
        PersonService personService = new PersonService();
        AddressService addressService = new AddressService();
        PersonAddressService personAddressService = new PersonAddressService();
        personService.saveNewData(CreateDataUtil.createPerson());
        addressService.saveNewData(CreateDataUtil.createAddress());
        personAddressService.saveNewData(CreateDataUtil.createPersonAddressID());

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

        personAddressService.displayAllPersonAddress();
    }
}
