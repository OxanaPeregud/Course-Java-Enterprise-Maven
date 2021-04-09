package com.peregud;

import java.util.*;
import java.util.stream.Collectors;

public final class PersonGeneratorUtil {
    private static final List<String> FIRST_NAMES;
    private static final List<String> LAST_NAMES;
    private static final Random RANDOM;
    private static final Person PERSON;

    private PersonGeneratorUtil() {
    }

    static {
        FIRST_NAMES = Arrays.asList("James", "Robert", "Michael", "James", "David", "Richard", "Joseph",
                "Thomas", "Charles", "James");
        LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller",
                "Davis", "Smith", "Smith");
        RANDOM = new Random();
        PERSON = new Person();
    }

    public static void addToList() {
        for (int i = 1; i < 100; i++) {
            PERSON.getList().add(new Person(
                    FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())),
                    LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())),
                    (int) (Math.random() * (31 - 15)) + 15));
        }
    }

    public static void sortList() {
        PERSON.getList().sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
    }

    public static List<Person> distinctPersonList() {
        return PERSON.getList().stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Person> filterPersonList() {
        return distinctPersonList().stream()
                .filter(Person::underAge)
                .collect(Collectors.toList());
    }
}
