package com.peregud.dbprocedure.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class ConnectorUtil {
    private Connection conn;
    private final String SQL_URL = "jdbc:mysql://localhost:3306/persondb";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(SQL_URL, USER, PASSWORD);
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
