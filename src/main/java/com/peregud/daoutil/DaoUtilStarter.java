package com.peregud.daoutil;

import com.peregud.daoutil.service.AddressService;
import com.peregud.daoutil.service.PersonAddressService;
import com.peregud.daoutil.service.PersonService;
import com.peregud.daoutil.util.DBCreatorUtil;
import com.peregud.daoutil.util.DataBuilderUtil;

public class DaoUtilStarter {

    public static void start() {
        DBCreatorUtil.createPersonAddressDatabase();
        PersonService personService = new PersonService();
        AddressService addressService = new AddressService();
        PersonAddressService personAddressService = new PersonAddressService();
        personService.saveNewData(DataBuilderUtil.buildPerson(5));
        addressService.saveNewData(DataBuilderUtil.buildAddress(5));
        personAddressService.saveNewData(DataBuilderUtil.buildPersonAddressID(10));
        personService.getByID(3);
        personService.updateData(4, 2);
        personService.updateData(5, 2);
        addressService.updateData(4, 1);
        addressService.updateData(5, 1);
        personService.deleteData(1);
        addressService.deleteData(1);
    }
}
