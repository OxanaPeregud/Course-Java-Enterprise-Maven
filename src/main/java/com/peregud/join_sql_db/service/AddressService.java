package com.peregud.join_sql_db.service;

import com.peregud.join_sql_db.model.Address;
import com.peregud.join_sql_db.repository.*;
import com.peregud.join_sql_db.view.AddressView;

import java.sql.SQLException;

public class AddressService implements DBDataService {
    private static final AddressView ADDRESS_VIEW;
    private static final DAOAddress ADDRESS;
    private final Address address = new Address();

    static {
        ADDRESS_VIEW = new AddressView();
        ADDRESS = new DAOAddressImpl();
    }

    @Override
    public void saveNewData() {
        try {
            ADDRESS.save(new Address("Wall Street", 154, 11));
            ADDRESS.save(new Address("Broadway", 72, 10));
            ADDRESS.save(new Address("Bowery", 8, 122));
            ADDRESS.save(new Address("Houston Street", 43, 387));
            ADDRESS.save(new Address("Canal Street", 11, 55));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID(int id) {
        try {
            ADDRESS_VIEW.displayByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData(int id, int change) {
        try {
            address.setHouse(ADDRESS.get(id).getHouse() + change);
            address.setId(id);
            ADDRESS.update(address);
            ADDRESS_VIEW.displayByID(id);
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
            ADDRESS_VIEW.displayAllData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
