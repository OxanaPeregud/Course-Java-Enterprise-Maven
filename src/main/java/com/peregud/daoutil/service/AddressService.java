package com.peregud.daoutil.service;

import com.peregud.daoutil.model.Address;
import com.peregud.daoutil.repository.DAOAddressRepository;
import com.peregud.daoutil.repository.DAOAddressRepositoryImpl;
import com.peregud.daoutil.view.AddressView;

import java.sql.SQLException;
import java.util.List;

public class AddressService implements DBDataService<Address> {
    private final AddressView addressView = new AddressView();
    private final DAOAddressRepository daoAddress = new DAOAddressRepositoryImpl();
    private final Address address = new Address();

    @Override
    public void saveNewData(List<Address> list) {
        try {
            for (Address address : list) {
                daoAddress.save(address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            addressView.displayByID(daoAddress.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            address.setHouse(daoAddress.get(id).getHouse() + change);
            address.setAddressID(id);
            daoAddress.update(address);
            addressView.displayByID(daoAddress.get(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            daoAddress.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
