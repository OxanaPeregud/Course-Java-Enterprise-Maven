package com.peregud.dbprocedure.util;

import com.peregud.dbprocedure.dao.impl.DAOPersonImpl;
import com.peregud.dbprocedure.model.Person;
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
class DBUtilTest {

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
        person.setFirstName("John");
        person.setLastName("Smith");

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(person.getFirstName());
        when(rs.getString(3)).thenReturn(person.getLastName());
        when(preparedStmt.executeQuery()).thenReturn(rs);
    }

    @Test
    public void createPerson() {
        DataSource ds = mock(DataSource.class);
        Person person = mock(Person.class);
        new DAOPersonImpl(ds).save(person);
    }

    @Test
    public void createAndRetrievePerson() {
        DataSource ds = mock(DataSource.class);
        Person person = mock(Person.class);
        DAOPersonImpl dao = new DAOPersonImpl(ds);
        dao.save(person);
        Person person1 = dao.get(1);
        assertEquals(new Person(1, "James", "Smith", 50), person1);
    }
}
