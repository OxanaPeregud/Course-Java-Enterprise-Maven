package com.peregud.join_sql_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOAddressImpl implements DAOAddress {
    private PreparedStatement preparedStmt = null;
    private ResultSet rs = null;

    @Override
    public void save(Address address) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sql = "INSERT INTO peopleDB.address(street, house) VALUES(?,?)";
            preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, address.getStreet());
            preparedStmt.setInt(2, address.getHouse());
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
    public void update(Address address) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
            String sql2 = "UPDATE peopleDB.address SET house=? WHERE id=?";
            preparedStmt = conn.prepareStatement(sql1);
            preparedStmt = conn.prepareStatement(sql2);
            preparedStmt.setInt(1, address.getHouse());
            preparedStmt.setInt(2, address.getId());
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
            String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
            String sql2 = "DELETE FROM peopleDB.address WHERE id=?";
            preparedStmt = conn.prepareStatement(sql1);
            preparedStmt = conn.prepareStatement(sql2);
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
    public List<Address> getAll() {
        try {
            Connection conn = ConnectorUtil.getConnection();
            String sql = "SELECT * FROM peopleDB.address";
            preparedStmt = conn.prepareStatement(sql);
            rs = preparedStmt.executeQuery();
            List<Address> list = new ArrayList<>();
            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setStreet(rs.getString("street"));
                address.setHouse(rs.getInt("house"));
                list.add(address);
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
