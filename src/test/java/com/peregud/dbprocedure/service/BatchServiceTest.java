package com.peregud.dbprocedure.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class BatchServiceTest {

    @Before
    public void setUp() throws Exception {
        Connection conn = mock(Connection.class);
        DataSource ds = mock(DataSource.class);
        Statement stmt = mock(Statement.class);
        assertNotNull(ds);
        when(conn.createStatement()).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(conn);
    }

    @Test
    void save() {
        DataSource ds = mock(DataSource.class);
        new BatchService(ds);
        BatchService.save();
    }
}
