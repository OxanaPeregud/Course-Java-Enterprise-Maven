package com.peregud.join_sql_db;

import java.util.Arrays;
import java.util.List;

public class CreatorUtil {

    public static List<People> createPeople() {
        return Arrays.asList(
                new People("James", "Smith", 30),
                new People("Robert", "Johnson", 15),
                new People("Michael", "Williams", 22),
                new People("David", "Brown", 37),
                new People("Richard", "Miller", 25)
        );
    }

    public static List<Address> createAddress() {
        return Arrays.asList(
                new Address("Wall Street", 154),
                new Address("Broadway", 72),
                new Address("Bowery", 8),
                new Address("Houston Street", 43),
                new Address("Canal Street", 11)
        );
    }

    public static List<PeopleAddress> createPeopleAddressID() {
        return Arrays.asList(
                new PeopleAddress(1, 1),
                new PeopleAddress(1, 2),
                new PeopleAddress(2, 2),
                new PeopleAddress(2, 3),
                new PeopleAddress(3, 3),
                new PeopleAddress(4, 4),
                new PeopleAddress(4, 5),
                new PeopleAddress(5, 5)
        );
    }
}
