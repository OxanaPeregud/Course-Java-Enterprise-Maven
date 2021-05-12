package com.peregud.dbprocedure.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ProcedureServiceTest {

    @Before
    public void setUp() throws Exception {
        Connection conn = mock(Connection.class);
        DataSource ds = mock(DataSource.class);
        CallableStatement cs = mock(CallableStatement.class);
        assertNotNull(ds);
        String sql = "sql";
        when(conn.prepareCall(sql)).thenReturn(cs);
        when(ds.getConnection()).thenReturn(conn);
    }

    @Test
    void updateAge() {
        DataSource ds = mock(DataSource.class);
        new ProcedureService(ds);
        ProcedureService.updateAge();
    }

    @Test
    void updateAddress() {
        DataSource ds = mock(DataSource.class);
        new ProcedureService(ds);
        ProcedureService.updateAddress();
    }

    @Test
    void deleteData() {
        DataSource ds = mock(DataSource.class);
        new ProcedureService(ds);
        ProcedureService.deleteData();
    }

    @Test
    void deleteUpdateData() {
        DataSource ds = mock(DataSource.class);
        new ProcedureService(ds);
        ProcedureService.deleteUpdateData();
    }
}
