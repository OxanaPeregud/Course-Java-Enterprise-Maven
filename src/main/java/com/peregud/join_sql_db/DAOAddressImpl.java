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
    private static final String SQL_SAVE;
    private static final String SQL_UPDATE;
    private static final String SQL_DELETE;
    private static final String SQL_GET;

    static {
        SQL_SAVE = "INSERT INTO peopleDB.address(id, street, house) VALUES(?,?,?)";
        SQL_UPDATE = "UPDATE peopleDB.address SET house=? WHERE id=?";
        SQL_DELETE = "DELETE FROM peopleDB.address WHERE id=?";
        SQL_GET = "SELECT * FROM peopleDB.address";
    }

    public DAOAddressImpl() {
    }

    @Override
    public void save(Address address) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, address.getId());
            preparedStmt.setString(2, address.getStreet());
            preparedStmt.setInt(3, address.getHouse());
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
            preparedStmt = conn.prepareStatement(SQL_UPDATE);
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
            preparedStmt = conn.prepareStatement(SQL_DELETE);
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
            preparedStmt = conn.prepareStatement(SQL_GET);
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
