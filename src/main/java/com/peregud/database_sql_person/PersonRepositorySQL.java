package com.peregud.database_sql_person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositorySQL implements PersonRepository {
    private static final String SQL_URL = "jdbc:mysql://localhost:3306/list";

    @Override
    public void personInput(List<Person> list) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            String sql = "insert into list.person(first_name, last_name, age) " + "VALUE (?, ?, ?);";
            preparedStatement = conn.prepareStatement(sql);
            for (Person person : list) {
                preparedStatement.setString(1, person.getFirstName());
                preparedStatement.setString(2, person.getLastName());
                preparedStatement.setInt(3, person.getAge());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Person> personOutput() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from list.person");
            List<Person> list = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person();
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setAge(rs.getInt("age"));
                list.add(person);
            }
            return list;
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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
