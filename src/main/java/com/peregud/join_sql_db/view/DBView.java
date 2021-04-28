package com.peregud.join_sql_db.view;

import java.sql.SQLException;

public interface DBView {

    void displayByID(int id) throws SQLException;

    void displayAllData() throws SQLException;

}
