package com.peregud.dbprocedure.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DBUtil {

    public static void executePreparedStatement(String sql, Map<Integer, Object> param) {
        PreparedStatement preparedStmt = null;
        try {
            Connection conn = ConnectorUtil.getConnection();
            preparedStmt = conn.prepareStatement(sql);
            int index = 1;
            for (Map.Entry<Integer, Object> entry : param.entrySet()) {
                preparedStmt.setObject(index, entry.getValue());
                index++;
            }
            preparedStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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

    public static <T> T executeResultSet(String sql, T t) {
        Statement stmt = null;
        ResultSet rs = null;
        Map<String, String> param = new HashMap<>();
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            try {
                stmt = ConnectorUtil.getConnection().createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    param.put(ReflectionUtil.annotatedField(clazz, name), name);
                    for (Map.Entry<String, String> entry : param.entrySet()) {
                        field = clazz.getDeclaredField(entry.getValue());
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
        return t;
    }

    public static void executeStatement(String sql) {
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

    public static void executeBatch(List<String> sqlList) {
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = ConnectorUtil.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            for (String sql : sqlList) {
                stmt.addBatch(sql);
            }
            stmt.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void executeProcedure(String sql, Map<Integer, Object> paramIn,
                                        Map<Integer, Integer> paramOut) {
        CallableStatement cs = null;
        Connection conn = null;
        try {
            conn = ConnectorUtil.getConnection();
            conn.setAutoCommit(false);
            cs = conn.prepareCall(sql);
            int index = 1;
            for (Map.Entry<Integer, Object> entry : paramIn.entrySet()) {
                cs.setObject(index, entry.getValue());
                index++;
            }
            for (Map.Entry<Integer, Integer> entry : paramOut.entrySet()) {
                cs.registerOutParameter(index, entry.getValue());
                index++;
            }
            cs.execute();
            conn.commit();
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                ConnectorUtil.closeConnection();
                if (cs != null) {
                    cs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
