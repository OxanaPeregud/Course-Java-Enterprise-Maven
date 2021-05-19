package com.peregud.hibernate;

import com.peregud.hibernate.model.Person;
import com.peregud.hibernate.model.PersonAddress;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class JPAHibernatePersonTest extends JPAHibernateTest {

    @Test
    public void testMerge_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Person person = new Person(1, "First Name", "Last Name", 22, personAddressList);
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        assertEquals(person, em.find(Person.class, 1));
    }

    @Test
    public void testFind_success() {
        assertNotNull(em.find(Person.class, 1));
    }

    @Test
    public void testRemove_success() {
        em.getTransaction().begin();
        em.remove(em.find(Person.class, 1));
        em.getTransaction().commit();
        assertNull(em.find(Person.class, 1));
    }
}
