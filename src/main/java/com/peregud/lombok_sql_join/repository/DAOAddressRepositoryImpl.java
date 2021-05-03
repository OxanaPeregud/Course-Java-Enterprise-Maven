package com.peregud.lombok_sql_join.repository;

import com.peregud.lombok_sql_join.model.Address;
import com.peregud.lombok_sql_join.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOAddressRepositoryImpl implements DAOAddressRepository {
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public void save(Address address) {
        Map<Integer, Object> param = new HashMap<>();
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlSave =
                    "INSERT INTO personDB.address(address_id, street, house, apartment) " + "VALUE (?, ?, ?, ?)";
            param.put(1, address.getAddressID());
            param.put(2, address.getStreet());
            param.put(3, address.getHouse());
            param.put(4, address.getApartment());
            ConnectorUtil.preparedStatement(conn, sqlSave, param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Address get(Serializable id) {
        Address address = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sqlGet = "SELECT * FROM personDB.address WHERE address_id = ";
            rs = stmt.executeQuery(sqlGet + id);
            while (rs.next()) {
                address = new Address();
                address.setAddressID(rs.getInt("address_id"));
                address.setStreet(rs.getString("street"));
                address.setHouse(rs.getInt("house"));
                address.setApartment(rs.getInt("apartment"));
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
        return address;
    }

    @Override
    public void update(Address address) {
        Map<Integer, Object> param = new HashMap<>();
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlUpdate = "UPDATE personDB.address SET house = ? WHERE address_id = ?";
            param.put(1, address.getHouse());
            param.put(2, address.getAddressID());
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
            String sqlDelete = "DELETE FROM personDB.address WHERE address_id = ";
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
    public List<Address> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sqlGetAll = "SELECT * FROM personDB.address";
            rs = stmt.executeQuery(sqlGetAll);
            List<Address> list = new ArrayList<>();
            while (rs.next()) {
                Address address = new Address();
                address.setAddressID(rs.getInt("address_id"));
                address.setStreet(rs.getString("street"));
                address.setHouse(rs.getInt("house"));
                address.setApartment(rs.getInt("apartment"));
                list.add(address);
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
