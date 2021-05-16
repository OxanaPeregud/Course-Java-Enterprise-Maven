package com.peregud.hibernate;

import com.peregud.hibernate.model.PersonTest;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class JPAHibernatePersonTest extends JPAHibernateTest {

    @Test
    public void testGetById_success() {
        PersonTest personTest = em.find(PersonTest.class, 1);
        assertNotNull(personTest);
    }

    @Test
    public void testGetAll_success() {
        List<PersonTest> personTests = em.createNamedQuery("PersonTest.getAll", PersonTest.class)
                .getResultList();
        assertEquals(1, personTests.size());
    }

    @Test
    public void testPersist_success() {
        em.getTransaction().begin();
        em.persist(new PersonTest(10, "John"));
        em.getTransaction().commit();
        List<PersonTest> personTests = em.createNamedQuery("PersonTest.getAll", PersonTest.class)
                .getResultList();
        assertNotNull(personTests);
        assertEquals(2, personTests.size());
    }

    @Test
    public void testDelete_success(){
        PersonTest personTest = em.find(PersonTest.class, 1);
        em.getTransaction().begin();
        em.remove(personTest);
        em.getTransaction().commit();
        List<PersonTest> personTests = em.createNamedQuery("PersonTest.getAll", PersonTest.class)
                .getResultList();
        assertEquals(0, personTests.size());
    }
}
