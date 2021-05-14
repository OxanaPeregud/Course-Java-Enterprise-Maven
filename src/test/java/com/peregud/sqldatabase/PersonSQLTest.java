package com.peregud.sqldatabase;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class PersonSQLTest {
    private static final String SQL_URL = "jdbc:mysql://localhost:3306/list";

    @Test
    public void personInput() {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.executeUpdate("delete from list.person");
            String sql = "insert into list.person(first_name, last_name, age) " + "VALUE (?, ?, ?);";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "Smith");
            preparedStatement.setInt(3, 30);
            preparedStatement.executeUpdate();

            String firstName1 = "John";
            String firstName2 = "Bob";
            String lastName1 = "Smith";
            String lastName2 = "Black";
            int age1 = 30;
            int age2 = 35;

            try (ResultSet rs = stmt.executeQuery("select * from list.person")) {
                assertTrue(rs.next());
                assertEquals(firstName1, rs.getString("first_name"));
                assertNotEquals(firstName2, rs.getString("first_name"));
                assertEquals(lastName1, rs.getString("last_name"));
                assertNotEquals(lastName2, rs.getString("last_name"));
                assertEquals(age1, rs.getInt("age"));
                assertNotEquals(age2, rs.getInt("age"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.rollback();
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
