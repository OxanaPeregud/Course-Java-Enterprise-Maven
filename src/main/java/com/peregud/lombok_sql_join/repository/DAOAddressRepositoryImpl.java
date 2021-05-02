package com.peregud.lombok_sql_join.repository;

import com.peregud.lombok_sql_join.model.Address;
import com.peregud.lombok_sql_join.util.ConnectorUtil;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAddressRepositoryImpl implements DAOAddressRepository {
    private PreparedStatement preparedStmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public void save(Address address) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlSave =
                    "INSERT INTO personDB.address(address_id, street, house, apartment) " + "VALUE (?, ?, ?, ?)";
            preparedStmt = conn.prepareStatement(sqlSave);
            preparedStmt.setInt(1, address.getAddressID());
            preparedStmt.setString(2, address.getStreet());
            preparedStmt.setInt(3, address.getHouse());
            preparedStmt.setInt(4, address.getApartment());
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
        return address;
    }

    @Override
    public void update(Address address) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sqlUpdate = "UPDATE personDB.address SET house = ? WHERE address_id = ?";
            preparedStmt = conn.prepareStatement(sqlUpdate);
            preparedStmt.setInt(1, address.getHouse());
            preparedStmt.setInt(2, address.getAddressID());
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
            String sqlDelete = "DELETE FROM personDB.address WHERE address_id = ";
            stmt.execute(sqlDelete + id);
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
    public List<Address> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            String sqlGetAll = "SELECT * FROM personDB.address";
            ;
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
