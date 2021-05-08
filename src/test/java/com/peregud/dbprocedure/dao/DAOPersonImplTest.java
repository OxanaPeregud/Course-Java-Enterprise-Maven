package com.peregud.dbprocedure.dao;

import com.peregud.dbprocedure.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DAOPersonImplTest {

    @Test
    void save() {
        DAOPersonImpl DAOPersonImpl = mock(DAOPersonImpl.class);
        Person person = new Person(1, "James", "Smith", 50);
        when(DAOPersonImpl.get(1)).thenReturn(person);
        DAOPersonImpl.save(person);
        verify(DAOPersonImpl, times(1)).save(
                new Person(1, "James", "Smith", 50));
        assertEquals(new Person(1, "James", "Smith", 50), DAOPersonImpl.get(1));
    }

    @Test
    void get() {
        DAOPersonImpl DAOPersonImpl = mock(DAOPersonImpl.class);
        when(DAOPersonImpl.get(1)).thenReturn(new Person(1, "James", "Smith", 50));
        Person person = DAOPersonImpl.get(1);
        assertEquals(new Person(1, "James", "Smith", 50), person);
        assertNotEquals(new Person(2, "James", "Smith", 50), person);
    }
}
