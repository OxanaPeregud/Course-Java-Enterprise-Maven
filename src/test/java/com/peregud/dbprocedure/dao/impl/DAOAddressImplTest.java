package com.peregud.dbprocedure.dao.impl;

import com.peregud.dbprocedure.model.Address;
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
class DAOAddressImplTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        Connection conn = mock(Connection.class);
        DataSource ds = mock(DataSource.class);
        ResultSet rs = mock(ResultSet.class);
        Address address;
        assertNotNull(ds);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        when(ds.getConnection()).thenReturn(conn);

        address = new Address();
        address.setAddressID(1);
        address.setStreet("Street");
        address.setHouse(0);
        address.setApartment(0);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(address.getStreet());
        when(rs.getInt(3)).thenReturn(address.getHouse());
        when(rs.getInt(4)).thenReturn(address.getApartment());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void save() {
        DataSource ds = mock(DataSource.class);
        Address address = mock(Address.class);
        new DAOAddressImpl(ds).save(address);
    }

    @Test
    void get() {
        DataSource ds = mock(DataSource.class);
        DAOAddressImpl dao = new DAOAddressImpl(ds);
        Address address = dao.get(0);
        assertEquals(new Address(0, null, 0, 0), address);
    }

    @Test
    void update() {
        DataSource ds = mock(DataSource.class);
        Address address = mock(Address.class);
        new DAOAddressImpl(ds).update(address);
    }

    @Test
    void delete() {
        DataSource ds = mock(DataSource.class);
        new DAOAddressImpl(ds).delete(0);
    }
}
