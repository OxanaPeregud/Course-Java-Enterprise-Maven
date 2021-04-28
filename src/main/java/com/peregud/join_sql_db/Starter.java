package com.peregud.join_sql_db;

import com.peregud.join_sql_db.service.AddressService;
import com.peregud.join_sql_db.service.PersonAddressService;
import com.peregud.join_sql_db.service.PersonService;
import com.peregud.join_sql_db.util.DBCreatorUtil;

public class Starter {
    public static void main(String[] args) {
        DBCreatorUtil.createPersonAddressDatabase();
        PersonService personService = new PersonService();
        AddressService addressService = new AddressService();
        PersonAddressService personAddressService = new PersonAddressService();
        personService.saveNewData();
        addressService.saveNewData();
        personAddressService.saveNewData();

        personService.updateData(4, 2);
        personService.updateData(5, 2);

        addressService.updateData(4, 1);
        addressService.updateData(5, 1);

        personService.deleteData(1);
        addressService.deleteData(1);
    }
}
