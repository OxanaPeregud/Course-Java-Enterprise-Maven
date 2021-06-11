package com.peregud.univeradmin.util;

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
    private final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("database");

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(getProperty(SQL_URL), getProperty(USER), getProperty(PASSWORD));
        }
        return conn;
    }

    public Connection closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        return null;
    }

    public String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
