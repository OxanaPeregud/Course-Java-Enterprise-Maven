package com.peregud.dbprocedure.dao;

import com.peregud.dbprocedure.model.PersonAddress;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DAOPersonAddressImplTest {

    @Test
    void save() {
        DAOPersonAddressImpl DAOPersonAddressImpl = mock(DAOPersonAddressImpl.class);
        ArgumentCaptor<PersonAddress> argument = ArgumentCaptor.forClass(PersonAddress.class);
        PersonAddress personAddress = new PersonAddress(1, 2);
        when(DAOPersonAddressImpl.save(argument.capture())).thenReturn(new PersonAddress(1, 2));
        assertEquals(new PersonAddress(1, 2), DAOPersonAddressImpl.save(personAddress));
        assertNotEquals(new PersonAddress(1, 3), DAOPersonAddressImpl.save(personAddress));
        assertEquals(2, argument.getValue().getAddressID());
        assertNotEquals(3, argument.getValue().getAddressID());
    }

    @Test
    void get() {
        DAOPersonAddressImpl DAOPersonAddressImpl = mock(DAOPersonAddressImpl.class);
        when(DAOPersonAddressImpl.get(1)).thenReturn(new PersonAddress(1, 2));
        assertEquals(new PersonAddress(1, 2), DAOPersonAddressImpl.get(1));
        assertNull(DAOPersonAddressImpl.get(2));
        assertNotEquals(new PersonAddress(2, 3), DAOPersonAddressImpl.get(1));
    }

    @Test
    void delete() {
        DAOPersonAddressImpl DAOPersonAddressImpl = mock(DAOPersonAddressImpl.class);
        when(DAOPersonAddressImpl.delete(1)).thenReturn(1);
        assertEquals(1, DAOPersonAddressImpl.delete(1));
        assertNotEquals(0, DAOPersonAddressImpl.delete(1));
    }
}
