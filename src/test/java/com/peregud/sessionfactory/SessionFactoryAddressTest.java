package com.peregud.sessionfactory;

import com.peregud.sessionfactory.model.Address;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionFactoryAddressTest extends SessionFactoryTest {

    @Test
    public void testSave_success() {
        Address address = Address.builder().street("Wall Street").house(10).apartment(20).build();
        session.save(address);
        assertEquals("Wall Street", address.getStreet());
    }

    @Test
    public void testGet_success() {
        Address address = Address.builder().street("Broadway").house(11).apartment(50).build();
        session.save(address);
        assertEquals(address, session.get(Address.class, address.getId()));
    }

    @Test
    public void testUpdate_success() {
        Address address = Address.builder().street("Houston Street").house(5).apartment(100).build();
        session.save(address);
        address.setHouse(70);
        assertEquals(70, address.getHouse());
    }

    @Test
    public void testDelete_success() {
        Address address = Address.builder().street("Canal Street").house(1).apartment(1).build();
        session.save(address);
        session.delete(address);
        Assert.assertNull(session.get(Address.class, address.getId()));
    }
}
