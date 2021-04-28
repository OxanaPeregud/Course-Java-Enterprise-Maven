package com.peregud.join_sql_db.view;

import com.peregud.join_sql_db.repository.DAOAddress;
import com.peregud.join_sql_db.repository.DAOAddressImpl;
import com.peregud.join_sql_db.repository.DAOPersonAddress;
import com.peregud.join_sql_db.repository.DAOPersonAddressImpl;

import java.sql.SQLException;

public class PersonAddressView implements DBView {
    private static final DAOPersonAddress PERSON_ADDRESS;
    private static final DAOAddress ADDRESS;

    static {
        PERSON_ADDRESS = new DAOPersonAddressImpl();
        ADDRESS = new DAOAddressImpl();
    }

    @Override
    public void displayByID(int id) throws SQLException {
        if (PERSON_ADDRESS.get(id) != null) {
            System.out.println(ADDRESS.get(PERSON_ADDRESS.get(id).getAddressID()));
        } else {
            System.out.println("There is no person address under entered ID");
        }
    }

    @Override
    public void displayAllData() throws SQLException {

    }
}
