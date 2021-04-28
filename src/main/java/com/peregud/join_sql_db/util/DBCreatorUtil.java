package com.peregud.join_sql_db.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreatorUtil {

    public static void createPersonAddressDatabase() {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sql1 = "DROP SCHEMA IF EXISTS `PersonDB`";
            String sql2 = "CREATE SCHEMA IF NOT EXISTS `PersonDB` DEFAULT CHARACTER SET utf8";
            String sql3 = "DROP TABLE IF EXISTS `PersonDB`.`Person`";
            String sql4 = "CREATE TABLE IF NOT EXISTS `PersonDB`.`Person`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `first_name`     VARCHAR(20)     NULL,\n" +
                    "  `last_name`      VARCHAR(20)     NULL,\n" +
                    "  `age`            INT             NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            String sql5 = "DROP TABLE IF EXISTS `PersonDB`.`Address`";
            String sql6 = "CREATE TABLE IF NOT EXISTS `PersonDB`.`Address`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `street`         VARCHAR(20)     NULL,\n" +
                    "  `house`          INT             NULL,\n" +
                    "  `apartment`      INT             NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ");";
            String sql7 = "DROP TABLE IF EXISTS `PersonDB`.`Person_Address`";
            String sql8 = "CREATE TABLE IF NOT EXISTS `PersonDB`.`Person_Address`\n" +
                    "(\n" +
                    "  `id`             INT             NOT NULL AUTO_INCREMENT,\n" +
                    "  `person_id`      INT             NOT NULL,\n" +
                    "  `address_id`     INT             NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_person_address_idx` (`address_id` ASC) VISIBLE,\n" +
                    "  INDEX `fk_address_person_idx` (`person_id` ASC) VISIBLE,\n" +
                    "  CONSTRAINT `fk_person_address`\n" +
                    "  FOREIGN KEY (`person_id`)\n" +
                    "  REFERENCES `PersonDB`.`Person` (`id`)\n" +
                    "  ON DELETE CASCADE\n" +
                    "  ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_address_person`\n" +
                    "  FOREIGN KEY (`address_id`)\n" +
                    "  REFERENCES `PersonDB`.`Person` (`id`)\n" +
                    "  ON DELETE CASCADE\n" +
                    "  ON UPDATE CASCADE\n" +
                    ");";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            stmt.executeUpdate(sql5);
            stmt.executeUpdate(sql6);
            stmt.executeUpdate(sql7);
            stmt.executeUpdate(sql8);
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
