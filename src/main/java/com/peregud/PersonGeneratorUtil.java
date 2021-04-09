package com.peregud;

import java.util.*;
import java.util.stream.Collectors;

public final class PersonGeneratorUtil {
    private static final List<String> FIRST_NAMES;
    private static final List<String> LAST_NAMES;
    private static final Random RANDOM;
    public static final List<Person> LIST;

    private PersonGeneratorUtil() {
    }

    static {
        FIRST_NAMES = Arrays.asList("James", "Robert", "Michael", "James", "David", "Richard", "Joseph",
                "Thomas", "Charles", "James");
        LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller",
                "Davis", "Smith", "Smith");
        RANDOM = new Random();
        LIST = new ArrayList<>();
    }

    public static void addToList() {
        for (int i = 1; i < 100; i++) {
            LIST.add(new Person(
                    FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())),
                    LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())),
                    (int) (Math.random() * (31 - 15)) + 15));
        }
    }

    public static void sortList() {
        LIST.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
    }

    public static List<Person> distinctPersonList() {
        return LIST.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Person> filterPersonList() {
        return distinctPersonList().stream()
                .filter(Person::underAge)
                .collect(Collectors.toList());
    }
}
