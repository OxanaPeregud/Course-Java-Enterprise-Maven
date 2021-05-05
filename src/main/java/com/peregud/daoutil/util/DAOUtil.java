package com.peregud.daoutil.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Map;

public class DAOUtil<T> {

    public void executePreparedStatement(String sql, Map<Integer, Object> param) {
        try {
            preparedStatement(ConnectorUtil.getConnection(), sql, param);
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

    public void preparedStatement(Connection conn, String sql, Map<Integer, Object> param) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            int index = 1;
            for (Map.Entry<Integer, Object> entry : param.entrySet()) {
                preparedStatement.setObject(index, entry.getValue());
                index++;
            }
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void executeResultSet(String sql, Map<String, String> param, Class<?> clazz, T t) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = ConnectorUtil.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    Field field = clazz.getDeclaredField(entry.getValue());
                    field.setAccessible(true);
                    field.set(t, rs.getObject(entry.getKey()));
                }
            }
        } catch (SQLException | IllegalAccessException | NoSuchFieldException e) {
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
    }

    public void executeStatement(String sql) {
        Statement stmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute(sql);
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
}
