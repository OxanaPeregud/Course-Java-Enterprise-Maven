package com.peregud.dbprocedure.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorUtilTest {

    @Test
    void getConnection() throws SQLException {
        Connection connection = ConnectorUtil.getConnection();
        assertNotNull(connection);
    }

    @Test
    void closeConnection() throws SQLException {
        Connection connection = ConnectorUtil.closeConnection();
        assertNull(connection);
    }

    @Test
    void getProperty() {
        assertEquals("root", ConnectorUtil.getProperty("login"));
    }

    @Test
    public void testPrivateConstructor() {
        Class<ConnectorUtil> clazz = null;
        try {
            clazz = ConnectorUtil.class;
            Constructor<?>[] constructor = clazz.getDeclaredConstructors();
            constructor[0].setAccessible(true);
            constructor[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertFalse(Modifier.isPrivate(clazz.getModifiers()));
    }
}
