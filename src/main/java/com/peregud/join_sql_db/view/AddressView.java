package com.peregud.join_sql_db.view;

import com.peregud.join_sql_db.repository.DAOAddress;
import com.peregud.join_sql_db.repository.DAOAddressImpl;

import java.sql.SQLException;

public class AddressView implements DBView {
    private static final DAOAddress ADDRESS;

    static {
        ADDRESS = new DAOAddressImpl();
    }

    @Override
    public void displayByID(int id) throws SQLException {
        if (ADDRESS.get(id) != null) {
            System.out.println(ADDRESS.get(id));
        } else {
            System.out.println("There is no address under entered ID");
        }
    }

    @Override
    public void displayAllData() throws SQLException {
        ADDRESS.getAll().forEach(System.out::println);
    }
}
