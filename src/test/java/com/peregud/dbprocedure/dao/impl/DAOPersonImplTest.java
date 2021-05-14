package com.peregud.dbprocedure.dao.impl;

import com.peregud.dbprocedure.model.Person;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class DAOPersonImplTest {

    @Before
    public void setUp() throws Exception {
        PreparedStatement preparedStmt = mock(PreparedStatement.class);
        Connection conn = mock(Connection.class);
        DataSource ds = mock(DataSource.class);
        ResultSet rs = mock(ResultSet.class);
        Person person;
        assertNotNull(ds);
        when(conn.prepareStatement(any(String.class))).thenReturn(preparedStmt);
        when(ds.getConnection()).thenReturn(conn);

        person = new Person();
        person.setPersonID(1);
        person.setFirstName("First Name");
        person.setLastName("Last Name");
        person.setAge(0);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(person.getFirstName());
        when(rs.getString(3)).thenReturn(person.getLastName());
        when(rs.getInt(4)).thenReturn(person.getAge());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void save() {
        DataSource ds = mock(DataSource.class);
        Person person = mock(Person.class);
        new DAOPersonImpl(ds).save(person);
    }

    @Test
    void get() {
        DataSource ds = mock(DataSource.class);
        DAOPersonImpl dao = new DAOPersonImpl(ds);
        Person person = dao.get(0);
        assertEquals(new Person(0, null, null, 0), person);
    }

    @Test
    void update() {
        DataSource ds = mock(DataSource.class);
        Person person = mock(Person.class);
        new DAOPersonImpl(ds).update(person);
    }

    @Test
    void delete() {
        DataSource ds = mock(DataSource.class);
        new DAOPersonImpl(ds).delete(0);
    }
}
