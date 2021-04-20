package com.peregud.database_sql_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseService {
    private static final String SQL_URL = "jdbc:mysql://localhost:3306";

    public static void createDatabase() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            String sql1 = "CREATE SCHEMA IF NOT EXISTS `List` DEFAULT CHARACTER SET utf8;";
            String sql2 = "CREATE TABLE IF NOT EXISTS `List`.`Person`\n" +
                    "(\n" +
                    "  `id`               INT          NOT NULL AUTO_INCREMENT,\n" +
                    "  `first_name`       VARCHAR(20)  NULL,\n" +
                    "  `last_name`        VARCHAR(20)  NULL,\n" +
                    "  `age`              INT          NULL,\n" +
                    "  `salary`           DECIMAL      NULL,\n" +
                    "  `passport`         CHAR(10)     NULL,\n" +
                    "  `address`          VARCHAR(200) NULL,\n" +
                    "  `date_of_birth`    DATE         NULL,\n" +
                    "  `date_time_create` DATETIME     NULL,\n" +
                    "  `time_to_lunch`    TIME         NULL,\n" +
                    "  `letter`           TEXT         NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
