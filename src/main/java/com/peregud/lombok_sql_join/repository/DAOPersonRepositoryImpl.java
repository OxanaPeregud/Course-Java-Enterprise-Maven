package com.peregud.lombok_sql_join.repository;

import com.peregud.lombok_sql_join.model.Person;
import com.peregud.lombok_sql_join.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOPersonRepositoryImpl implements DAOPersonRepository {
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public void save(Person person) {
        Map<Integer, Object> param = new HashMap<>();
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlSave =
                    "INSERT INTO personDB.person(person_id, first_name, last_name, age) " + "VALUE (?, ?, ?, ?)";
            param.put(1, person.getPersonID());
            param.put(2, person.getFirstName());
            param.put(3, person.getLastName());
            param.put(4, person.getAge());
            ConnectorUtil.preparedStatement(conn, sqlSave, param);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
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
            String sqlGet = "SELECT * FROM personDB.person WHERE person_id = ";
            rs = stmt.executeQuery(sqlGet + id);
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
        Map<Integer, Object> param = new HashMap<>();
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlUpdate = "UPDATE personDB.person SET age = ? WHERE person_id = ?";
            param.put(1, person.getAge());
            param.put(2, person.getPersonID());
            ConnectorUtil.preparedStatement(conn, sqlUpdate, param);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
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
            String sqlDelete = "DELETE FROM personDB.person WHERE person_id = ";
            stmt.execute(sqlDelete + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
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
            String sqlGetAll = "SELECT * FROM personDB.person";
            rs = stmt.executeQuery(sqlGetAll);
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
