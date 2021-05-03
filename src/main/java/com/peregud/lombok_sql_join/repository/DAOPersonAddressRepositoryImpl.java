package com.peregud.lombok_sql_join.repository;

import com.peregud.lombok_sql_join.model.PersonAddress;
import com.peregud.lombok_sql_join.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOPersonAddressRepositoryImpl implements DAOPersonAddressRepository {
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public void save(PersonAddress personAddress) {
        Map<Integer, Object> param = new HashMap<>();
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlSave =
                    "INSERT INTO personDB.person_address(person_id, address_id) " + "VALUE (?, ?)";
            param.put(1, personAddress.getPersonID());
            param.put(2, personAddress.getAddressID());
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
    public PersonAddress get(Serializable id) {
        PersonAddress personAddress = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sqlGet = "SELECT * FROM personDB.person_address WHERE person_id = ";
            rs = stmt.executeQuery(sqlGet + id);
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
        Map<Integer, Object> param = new HashMap<>();
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlUpdate = "UPDATE personDB.person_address SET address_id = ? WHERE person_id = ?";
            param.put(1, personAddress.getAddressID());
            param.put(2, personAddress.getPersonID());
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
            String sqlDelete = "DELETE FROM personDB.person_address WHERE person_id = ";
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
    public List<PersonAddress> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sqlGetAll = "SELECT * FROM personDB.person_address";
            rs = stmt.executeQuery(sqlGetAll);
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
}
