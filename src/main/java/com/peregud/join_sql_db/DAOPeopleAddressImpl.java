package com.peregud.join_sql_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOPeopleAddressImpl implements DAOPeopleAddress {
    private PreparedStatement preparedStmt = null;
    private static final String SQL_SAVE;

    static {
        SQL_SAVE = "INSERT INTO peopleDB.people_address(people_id, address_id) VALUES(?,?)";
    }

    public DAOPeopleAddressImpl() {
    }

    @Override
    public void save(PeopleAddress peopleAddress) {
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(SQL_SAVE);
            preparedStmt.setInt(1, peopleAddress.getPeopleID());
            preparedStmt.setInt(2, peopleAddress.getAddressID());
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
    public void update(PeopleAddress peopleAddress) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<PeopleAddress> getAll() {
        return null;
    }
}
