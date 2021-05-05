package com.peregud.daoutil.service;

import com.peregud.daoutil.model.Address;
import com.peregud.daoutil.repository.DAOAddressRepository;
import com.peregud.daoutil.repository.DAOAddressRepositoryImpl;
import com.peregud.daoutil.view.AddressView;

import java.sql.SQLException;
import java.util.List;

public class AddressService implements DBDataService<Address> {
    private static final AddressView ADDRESS_VIEW = new AddressView();
    private static final DAOAddressRepository ADDRESS = new DAOAddressRepositoryImpl();
    private final Address address = new Address();

    @Override
    public void saveNewData(List<Address> list) {
        try {
            for (Address address : list) {
                ADDRESS.save(address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            ADDRESS_VIEW.displayByID(ADDRESS.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            address.setHouse(ADDRESS.get(id).getHouse() + change);
            address.setAddressID(id);
            ADDRESS.update(address);
            ADDRESS_VIEW.displayByID(ADDRESS.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            ADDRESS.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
