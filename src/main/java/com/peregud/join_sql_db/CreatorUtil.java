package com.peregud.join_sql_db;

import java.util.Arrays;
import java.util.List;

public class CreatorUtil {

    public static List<People> createPeople() {
        return Arrays.asList(
                new People("James", "Smith", 30, 1),
                new People("Robert", "Johnson", 15, 2),
                new People("Michael", "Williams", 22, 2),
                new People("David", "Brown", 37, 3),
                new People("John", "Black", 21, 3),
                new People("Bob", "White", 18, 4),
                new People("Richard", "Miller", 25, 5)
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
}
