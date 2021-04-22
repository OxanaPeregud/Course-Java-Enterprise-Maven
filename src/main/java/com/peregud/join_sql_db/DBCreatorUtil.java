package com.peregud.join_sql_db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreatorUtil {

    public static void createDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "CREATE SCHEMA IF NOT EXISTS `PeopleDB` DEFAULT CHARACTER SET utf8;";
            String sql2 = "CREATE TABLE IF NOT EXISTS `PeopleDB`.`People`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `first_name`     VARCHAR(20)     NULL,\n" +
                    "  `last_name`      VARCHAR(20)     NULL,\n" +
                    "  `age`            INT             NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            String sql3 = "CREATE TABLE IF NOT EXISTS `PeopleDB`.`Address`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `street`         VARCHAR(20)     NULL,\n" +
                    "  `house`          INT             NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
