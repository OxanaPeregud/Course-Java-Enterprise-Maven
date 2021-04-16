package com.peregud.database_sql_person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositorySQL implements PersonRepository {
    private static final String SQL_URL = "jdbc:mysql://localhost:3306/group";

    @Override
    public void personInput(List<Person> list) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            String sql = "insert into list.person(first_name, last_name, age) " + "VALUE (?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Person> personOutput() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(SQL_URL, "root", "1234");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from list.person");
            List<Person> list = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person();
                person.setFirstName(rs.getString("First Name"));
                person.setLastName(rs.getString("Last Name"));
                person.setAge(rs.getInt("Age"));
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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
