package com.peregud.dbprocedure.dao.impl;

import com.peregud.dbprocedure.model.PersonAddress;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DAOPersonAddressImplTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        Connection conn = mock(Connection.class);
        DataSource ds = mock(DataSource.class);
        ResultSet rs = mock(ResultSet.class);
        PersonAddress personAddress;
        assertNotNull(ds);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        when(ds.getConnection()).thenReturn(conn);

        personAddress = new PersonAddress();
        personAddress.setPersonID(1);
        personAddress.setAddressID(1);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getInt(2)).thenReturn(personAddress.getPersonID());
        when(rs.getInt(3)).thenReturn(personAddress.getAddressID());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void save() {
        DataSource ds = mock(DataSource.class);
        PersonAddress personAddress = mock(PersonAddress.class);
        new DAOPersonAddressImpl(ds).save(personAddress);
    }

    @Test
    void get() {
        DataSource ds = mock(DataSource.class);
        DAOPersonAddressImpl dao = new DAOPersonAddressImpl(ds);
        PersonAddress personAddress = dao.get(0);
        assertEquals(new PersonAddress(0, 0), personAddress);
    }

    @Test
    void update() {
        DataSource ds = mock(DataSource.class);
        PersonAddress personAddress = mock(PersonAddress.class);
        new DAOPersonAddressImpl(ds).update(personAddress);
    }

    @Test
    void delete() {
        DataSource ds = mock(DataSource.class);
        new DAOPersonAddressImpl(ds).delete(0);
    }
}
