package com.peregud.sessionfactory;

import com.peregud.sessionfactory.model.Person;
import com.peregud.sessionfactory.model.PersonAddress;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SessionFactoryPersonTest extends SessionFactoryTest {

    @Test
    public void testSave_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Person person = new Person(1, "John", "Smith", 30, personAddressList);
        session.save(person);
        assertEquals("John", person.getFirstName());
    }

    @Test
    public void testGet_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Person person = new Person(2, "James", "Garcia", 35, personAddressList);
        session.save(person);
        assertEquals(person, session.get(Person.class, person.getId()));
    }

    @Test
    public void testUpdate_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Person person = new Person(3, "Bob", "Black", 22, personAddressList);
        session.save(person);
        person.setAge(30);
        assertEquals(30, person.getAge());
    }

    @Test
    public void testDelete_success() {
        List<PersonAddress> personAddressList = new ArrayList<>();
        Person person = new Person(4, "Dan", "White", 50, personAddressList);
        session.delete(person);
        assertNull(session.get(Person.class, person.getId()));
    }
}
