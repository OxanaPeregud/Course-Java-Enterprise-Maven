package com.peregud.join_sql_db.repository;

import com.peregud.join_sql_db.model.Address;
import com.peregud.join_sql_db.model.Person;
import com.peregud.join_sql_db.util.ConnectorUtil;
import com.peregud.join_sql_db.model.PersonAddress;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class DAOPersonAddressImpl implements DAOPersonAddress {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private static final String SQL_SAVE;
    private static final String SQL_GET;
    private static final String SQL_UPDATE;
    private static final String SQL_DELETE;
    private static final String SQL_GET_ALL;
    private static final String SQL_GET_PERSON_ADDRESS;

    static {
        SQL_SAVE = "INSERT INTO personDB.person_address(person_id, address_id) " + "VALUE (?, ?)";
        SQL_GET = "SELECT * FROM personDB.person_address WHERE person_id = ";
        SQL_UPDATE = "UPDATE personDB.person_address SET address_id = ? WHERE person_id = ?";
        SQL_DELETE = "DELETE FROM personDB.person_address WHERE person_id = ";
        SQL_GET_ALL = "SELECT * FROM personDB.person_address";
        SQL_GET_PERSON_ADDRESS = "SELECT * FROM personDB.person, personDB.address, personDB.person_address\n" +
                "WHERE personDB.person_address.person_id = personDB.person.person_id and\n" +
                "personDB.person_address.address_id = personDB.address.address_id";
    }

    @Override
    public void save(PersonAddress personAddress) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, personAddress.getPersonID());
            preparedStmt.setInt(2, personAddress.getAddressID());
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
    public PersonAddress get(Serializable id) {
        PersonAddress personAddress = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET + id);
            while (rs.next()) {
                personAddress = new PersonAddress();
                personAddress.setPersonID(rs.getInt("person_id"));
                personAddress.setAddressID(rs.getInt("address_id"));
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
        return personAddress;
    }

    @Override
    public void update(PersonAddress personAddress) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_UPDATE);
            preparedStmt.setInt(1, personAddress.getAddressID());
            preparedStmt.setInt(2, personAddress.getPersonID());
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
    public List<PersonAddress> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            List<PersonAddress> list = new ArrayList<>();
            while (rs.next()) {
                PersonAddress personAddress = new PersonAddress();
                personAddress.setPersonID(rs.getInt("person_id"));
                personAddress.setAddressID(rs.getInt("address_id"));
                list.add(personAddress);
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

    public Map<Person, Address> getPersonAddress() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_PERSON_ADDRESS);
            Map<Person, Address> map = new LinkedHashMap<>();
            while (rs.next()) {
                PersonAddress personAddress = new PersonAddress();
                personAddress.setPersonID(rs.getInt("person_id"));
                personAddress.setAddressID(rs.getInt("address_id"));
                Person person = new Person();
                person.setPersonID(rs.getInt("person_id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setAge(rs.getInt("age"));
                Address address = new Address();
                address.setAddressID(rs.getInt("address_id"));
                address.setStreet(rs.getString("street"));
                address.setHouse(rs.getInt("house"));
                address.setApartment(rs.getInt("apartment"));
                map.put(person, address);
            }
            return map;
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
