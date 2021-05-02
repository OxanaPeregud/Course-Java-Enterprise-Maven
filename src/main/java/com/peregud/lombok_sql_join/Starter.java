package com.peregud.lombok_sql_join;

import com.peregud.lombok_sql_join.view.AddressView;
import com.peregud.lombok_sql_join.view.DBView;
import com.peregud.lombok_sql_join.view.PersonView;
import com.peregud.lombok_sql_join.model.Address;
import com.peregud.lombok_sql_join.model.Person;
import com.peregud.lombok_sql_join.repository.DAOAddressRepository;
import com.peregud.lombok_sql_join.repository.DAOAddressRepositoryImpl;
import com.peregud.lombok_sql_join.repository.DAOPersonRepository;
import com.peregud.lombok_sql_join.repository.DAOPersonRepositoryImpl;
import com.peregud.lombok_sql_join.service.AddressService;
import com.peregud.lombok_sql_join.service.PersonAddressService;
import com.peregud.lombok_sql_join.service.PersonService;
import com.peregud.lombok_sql_join.util.DataBuilderUtil;
import com.peregud.lombok_sql_join.util.DBCreatorUtil;

import java.sql.SQLException;
import java.util.List;

public class Starter {

    public static void main(String[] args) throws SQLException {
        DBCreatorUtil.createPersonAddressDatabase();
        PersonService personService = new PersonService();
        AddressService addressService = new AddressService();
        PersonAddressService personAddressService = new PersonAddressService();
        personService.saveNewData(DataBuilderUtil.buildPerson(5));
        addressService.saveNewData(DataBuilderUtil.buildAddress(5));
        personAddressService.saveNewData(DataBuilderUtil.buildPersonAddressID(10));
        DAOPersonRepository daoPerson = new DAOPersonRepositoryImpl();
        DAOAddressRepository daoAddress = new DAOAddressRepositoryImpl();
        List<Person> personFromDB = daoPerson.getAll();
        List<Address> addressFromDB = daoAddress.getAll();
        personService.updateData(personFromDB.size() - 1, 2);
        personService.updateData(personFromDB.size(), 2);
        addressService.updateData(addressFromDB.size() - 1, 1);
        addressService.updateData(addressFromDB.size(), 1);
        personService.deleteData(1);
        addressService.deleteData(1);
        DBView<Person> personDBView = new PersonView();
        personDBView.displayAllData(personFromDB);
        DBView<Address> addressDBView = new AddressView();
        addressDBView.displayAllData(addressFromDB);
    }
}
