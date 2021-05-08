package com.peregud.dbprocedure.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class ConnectorUtil {
    private static Connection conn;
    private static final String SQL_URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        SQL_URL = "jdbc:mysql://localhost:3306/persondb";
        USER = "root";
        PASSWORD = "1234";
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(SQL_URL, USER, PASSWORD);
        }
        return conn;
    }

    public static void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
