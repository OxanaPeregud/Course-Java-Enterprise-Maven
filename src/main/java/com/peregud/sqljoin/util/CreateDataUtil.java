package com.peregud.sqljoin.util;

import com.peregud.sqljoin.model.Address;
import com.peregud.sqljoin.model.Person;
import com.peregud.sqljoin.model.PersonAddress;

import java.util.Arrays;
import java.util.List;

public class CreateDataUtil {

    public static List<Person> createPerson() {
        return Arrays.asList(
                new Person("James", "Smith", 30),
                new Person("Robert", "Johnson", 15),
                new Person("Michael", "Williams", 22),
                new Person("David", "Brown", 37),
                new Person("Richard", "Miller", 25)
        );
    }

    public static List<Address> createAddress() {
        return Arrays.asList(
                new Address("Wall Street", 154, 11),
                new Address("Broadway", 72, 10),
                new Address("Bowery", 8, 122),
                new Address("Houston Street", 43, 387),
                new Address("Canal Street", 11, 55)
        );
    }

    public static List<PersonAddress> createPersonAddressID() {
        return Arrays.asList(
                new PersonAddress(1, 1),
                new PersonAddress(1, 2),
                new PersonAddress(2, 2),
                new PersonAddress(2, 3),
                new PersonAddress(3, 3),
                new PersonAddress(4, 4),
                new PersonAddress(4, 5),
                new PersonAddress(5, 5)
        );
    }
}
