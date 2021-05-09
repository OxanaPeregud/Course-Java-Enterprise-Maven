package com.peregud.dbprocedure.dao;

import com.peregud.dbprocedure.model.Address;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DAOAddressImplTest {

    @Test
    void save() {
        DAOAddressImpl DAOAddressImpl = mock(DAOAddressImpl.class);
        ArgumentCaptor<Address> argument = ArgumentCaptor.forClass(Address.class);
        Address address = new Address(1, "Wall Street", 11, 125);
        when(DAOAddressImpl.save(argument.capture())).thenReturn(new Address(1, "Wall Street", 11, 125));
        assertEquals(new Address(1, "Wall Street", 11, 125), DAOAddressImpl.save(address));
        assertNotEquals(new Address(1, "Wall Street", 11, 320), DAOAddressImpl.save(address));
        assertEquals(11, argument.getValue().getHouse());
        assertNotEquals(30, argument.getValue().getHouse());
    }

    @Test
    void get() {
        DAOAddressImpl DAOAddressImpl = mock(DAOAddressImpl.class);
        when(DAOAddressImpl.get(1)).thenReturn(new Address(1, "Wall Street", 11, 125));
        assertEquals(new Address(1, "Wall Street", 11, 125), DAOAddressImpl.get(1));
        assertNull(DAOAddressImpl.get(2));
        assertNotEquals(new Address(2, "Wall Street", 11, 125), DAOAddressImpl.get(1));
    }

    @Test
    void delete() {
        DAOAddressImpl DAOAddressImpl = mock(DAOAddressImpl.class);
        when(DAOAddressImpl.delete(1)).thenReturn(1);
        assertEquals(1, DAOAddressImpl.delete(1));
        assertNotEquals(0, DAOAddressImpl.delete(1));
    }
}
