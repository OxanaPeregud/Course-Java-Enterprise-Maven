package com.peregud.dbprocedure.dao;

import com.peregud.dbprocedure.model.Address;
import com.peregud.dbprocedure.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DAOAddressImplTest {

    @Test
    void get() {
        DAOAddressImpl DAOAddressImpl = mock(DAOAddressImpl.class);
        when(DAOAddressImpl.get(1)).thenReturn(new Address(1, "Wall Street", 11, 125));
        Address address = DAOAddressImpl.get(1);
        assertEquals(new Address(1, "Wall Street", 11, 125), address);
    }
}