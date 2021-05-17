package com.peregud.hibernate;

import com.peregud.hibernate.model.Address;
import com.peregud.hibernate.model.PersonAddress;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class JPAHibernateAddressTest extends JPAHibernateTest {

    @Test
    public void testMerge_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Address address = new Address(1, "Street", 10, 20, personAddressList);
        em.getTransaction().begin();
        em.merge(address);
        em.getTransaction().commit();
        assertEquals(address, em.find(Address.class, 1));
    }

    @Test
    public void testFind_success() {
        assertNotNull(em.find(Address.class, 1));
    }

    @Test
    public void testRemove_success() {
        em.getTransaction().begin();
        em.remove(em.find(Address.class, 1));
        em.getTransaction().commit();
        assertNull(em.find(Address.class, 1));
    }
}
