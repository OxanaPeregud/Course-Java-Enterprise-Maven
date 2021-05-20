package com.peregud.sessionfactory;

import com.peregud.sessionfactory.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SessionFactoryPersonTest extends SessionFactoryTest {

    @Test
    public void testSave_success() {
        Person person = Person.builder().firstName("John").lastName("Smith").age(20).build();
        session.save(person);
        assertEquals("John", person.getFirstName());
    }

    @Test
    public void testGet_success() {
        Person person = Person.builder().firstName("James").lastName("Garcia").age(35).build();
        session.save(person);
        assertEquals(person, session.get(Person.class, person.getId()));
        assertEquals("James", person.getFirstName());
    }

    @Test
    public void testUpdate_success() {
        Person person = Person.builder().firstName("Bob").lastName("Black").age(22).build();
        session.save(person);
        person.setAge(30);
        assertEquals(30, person.getAge());
    }

    @Test
    public void testDelete_success() {
        Person person = Person.builder().firstName("Dan").lastName("White").age(50).build();
        session.save(person);
        session.delete(person);
        assertNull(session.get(Person.class, person.getId()));
    }
}
