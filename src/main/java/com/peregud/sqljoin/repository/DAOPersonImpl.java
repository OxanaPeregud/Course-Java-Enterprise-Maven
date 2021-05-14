package com.peregud.sqljoin.repository;

import com.peregud.sqljoin.util.ConnectorUtil;
import com.peregud.sqljoin.model.Person;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonImpl implements DAOPerson {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String SQL_SAVE;
    private static final String SQL_GET;
    private static final String SQL_UPDATE;
    private static final String SQL_DELETE;
    private static final String SQL_GET_ALL;

    static {
        SQL_SAVE = "INSERT INTO personDB.person(person_id, first_name, last_name, age) " + "VALUE (?, ?, ?, ?)";
        SQL_GET = "SELECT * FROM personDB.person WHERE person_id = ";
        SQL_UPDATE = "UPDATE personDB.person SET age = ? WHERE person_id = ?";
        SQL_DELETE = "DELETE FROM personDB.person WHERE person_id = ";
        SQL_GET_ALL = "SELECT * FROM personDB.person";
    }
    @Override
    public void save(Person person) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, person.getPersonID());
            preparedStmt.setString(2, person.getFirstName());
            preparedStmt.setString(3, person.getLastName());
            preparedStmt.setInt(4, person.getAge());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Person get(Serializable id) {
        Person person = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET + id);
            while (rs.next()) {
                person = new Person();
                person.setPersonID(rs.getInt("person_id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (preparedStmt != null) {
                    preparedStmt.close();
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
        return person;
    }

    @Override
    public void update(Person person) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_UPDATE);
            preparedStmt.setInt(1, person.getAge());
            preparedStmt.setInt(2, person.getPersonID());
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Serializable id) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute(SQL_DELETE + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Person> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            List<Person> list = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person();
                person.setPersonID(rs.getInt("person_id"));
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
                ConnectorUtil.closeConnection();
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
