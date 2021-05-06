package com.peregud.lombok_sql_join.service;

import com.peregud.lombok_sql_join.model.Address;
import com.peregud.lombok_sql_join.repository.DAOAddressRepository;
import com.peregud.lombok_sql_join.repository.DAOAddressRepositoryImpl;
import com.peregud.lombok_sql_join.view.AddressView;

import java.sql.SQLException;
import java.util.List;

public class AddressService implements DBDataService<Address> {
    private static final AddressView ADDRESS_VIEW;
    private static final DAOAddressRepository ADDRESS;
    private final Address address = new Address();

    static {
        ADDRESS_VIEW = new AddressView();
        ADDRESS = new DAOAddressRepositoryImpl();
    }

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

    @Override
    public void displayAll() {
        try {
            ADDRESS_VIEW.displayAllData(ADDRESS.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
