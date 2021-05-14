package com.peregud.lombok;

import com.peregud.lombok.view.AddressView;
import com.peregud.lombok.view.DBView;
import com.peregud.lombok.model.Address;
import com.peregud.lombok.model.Person;
import com.peregud.lombok.repository.DAOAddressRepository;
import com.peregud.lombok.repository.DAOAddressRepositoryImpl;
import com.peregud.lombok.repository.DAOPersonRepository;
import com.peregud.lombok.repository.DAOPersonRepositoryImpl;
import com.peregud.lombok.service.AddressService;
import com.peregud.lombok.service.PersonService;
import com.peregud.lombok.util.DataBuilderUtil;
import com.peregud.lombok.util.DBCreatorUtil;
import com.peregud.lombok.view.PersonView;

import java.sql.SQLException;
import java.util.List;

public class LombokStarter {

    public static void start() throws SQLException {
        DBCreatorUtil.createPersonAddressDatabase();
        PersonService personService = new PersonService();
        AddressService addressService = new AddressService();
        personService.saveNewData(DataBuilderUtil.buildPerson(5));
        addressService.saveNewData(DataBuilderUtil.buildAddress(5));
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
