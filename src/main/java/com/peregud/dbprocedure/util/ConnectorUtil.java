package com.peregud.dbprocedure.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

@UtilityClass
public class ConnectorUtil {
    private Connection conn;
    private final String SQL_URL = "url";
    private final String USER = "login";
    private final String PASSWORD = "password";
    private final String DATABASE_DRIVER_NAME = "driverName";
    private final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("database");

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(getProperty(DATABASE_DRIVER_NAME));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(getProperty(SQL_URL), getProperty(USER), getProperty(PASSWORD));
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
