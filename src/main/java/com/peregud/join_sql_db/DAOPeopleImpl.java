package com.peregud.join_sql_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPeopleImpl implements DAOPeople {
    private PreparedStatement preparedStmt = null;
    private ResultSet rs = null;

    @Override
    public void save(People people) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(
                    "INSERT INTO peopleDB.people(first_name, last_name, age) VALUES(?,?,?)");
            preparedStmt.setString(1, people.getFirstName());
            preparedStmt.setString(2, people.getLastName());
            preparedStmt.setInt(3, people.getAge());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
                ConnectorUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(People people) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement("UPDATE peopleDB.people SET age=? WHERE id=?");
            preparedStmt.setInt(1, people.getAge());
            preparedStmt.setInt(2, people.getId());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
                ConnectorUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement("DELETE FROM peopleDB.people WHERE id=?");
            preparedStmt.setInt(1, id);
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
                ConnectorUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<People> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement("SELECT * FROM peopleDB.people");
            rs = preparedStmt.executeQuery();
            List<People> list = new ArrayList<>();
            while (rs.next()) {
                People person = new People();
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setAge(rs.getInt("age"));
                list.add(person);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
                ConnectorUtil.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
