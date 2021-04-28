package com.peregud.join_sql_db.util;

import com.peregud.join_sql_db.model.Address;
import com.peregud.join_sql_db.model.Person;

import java.util.Arrays;
import java.util.List;

public class CreateDataUtil {

    public static List<Person> createPerson() {
        return Arrays.asList(
                new Person("James", "Smith", 30, 1),
                new Person("Robert", "Johnson", 15, 2),
                new Person("Michael", "Williams", 22, 2),
                new Person("David", "Brown", 37, 3),
                new Person("John", "Black", 21, 3),
                new Person("Bob", "White", 18, 4),
                new Person("Richard", "Miller", 25, 5)
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
}
