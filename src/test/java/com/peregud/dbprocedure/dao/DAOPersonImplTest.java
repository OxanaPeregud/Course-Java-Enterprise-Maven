package com.peregud.dbprocedure.dao;

import com.peregud.dbprocedure.model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DAOPersonImplTest {

    @Test
    void save() {
        DAOPersonImpl DAOPersonImpl = mock(DAOPersonImpl.class);
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        Person person = new Person(1, "James", "Smith", 50);
        when(DAOPersonImpl.save(argument.capture())).thenReturn(new Person(1, "James", "Smith", 50));
        assertEquals(new Person(1, "James", "Smith", 50), DAOPersonImpl.save(person));
        assertNotEquals(new Person(1, "Bob", "Smith", 50), DAOPersonImpl.save(person));
        assertEquals(50, argument.getValue().getAge());
        assertNotEquals(30, argument.getValue().getAge());
    }

    @Test
    void get() {
        DAOPersonImpl DAOPersonImpl = mock(DAOPersonImpl.class);
        when(DAOPersonImpl.get(1)).thenReturn(new Person(1, "James", "Smith", 50));
        assertEquals(new Person(1, "James", "Smith", 50), DAOPersonImpl.get(1));
        assertNull(DAOPersonImpl.get(2));
        assertNotEquals(new Person(2, "James", "Smith", 50), DAOPersonImpl.get(1));
    }

    @Test
    void delete() {
        DAOPersonImpl DAOPersonImpl = mock(DAOPersonImpl.class);
        when(DAOPersonImpl.delete(1)).thenReturn(1);
        assertEquals(1, DAOPersonImpl.delete(1));
        assertNotEquals(0, DAOPersonImpl.delete(1));
    }
}
