package com.peregud.lombok_sql_join.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectorUtil {
    private static Connection conn;
    private static final String SQL_URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        SQL_URL = "jdbc:mysql://localhost:3306";
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

    public static void preparedStatement(Connection conn, String sql, Map<Integer, Object> param) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int index = 1;
        for (Map.Entry<Integer, Object> entry : param.entrySet()) {
            preparedStatement.setObject(index, entry.getValue());
            index++;
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
