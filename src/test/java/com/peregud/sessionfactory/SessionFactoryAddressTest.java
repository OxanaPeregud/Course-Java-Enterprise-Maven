package com.peregud.sessionfactory;

import com.peregud.sessionfactory.model.Address;
import com.peregud.sessionfactory.model.PersonAddress;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SessionFactoryAddressTest extends SessionFactoryTest {

    @Test
    public void testSave_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Address address = new Address(1, "Wall Street", 10, 20, personAddressList);
        session.save(address);
        assertEquals("Wall Street", address.getStreet());
    }

    @Test
    public void testGet_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Address address = new Address(2, "Broadway", 11, 50, personAddressList);
        session.save(address);
        assertEquals(address, session.get(Address.class, address.getId()));
    }

    @Test
    public void testUpdate_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Address address = new Address(3, "Houston Street", 5, 100, personAddressList);
        session.save(address);
        address.setHouse(70);
        assertEquals(70, address.getHouse());
    }

    @Test
    public void testDelete_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Address address = new Address(4, "Canal Street", 1, 1, personAddressList);
        session.delete(address);
        Assert.assertNull(session.get(Address.class, address.getId()));
    }
}
