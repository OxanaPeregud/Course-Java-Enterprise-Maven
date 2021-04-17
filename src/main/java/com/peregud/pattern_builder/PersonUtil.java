package com.peregud.pattern_builder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonUtil {
    private static final List<String> FIRST_NAMES;
    private static final List<String> LAST_NAMES;
    private static final Random RANDOM;

    static {
        FIRST_NAMES = Arrays.asList("James", "Robert", "Michael", "James", "David", "Richard", "Joseph",
                "Thomas", "Charles", "James");
        LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller",
                "Davis", "Smith", "Smith");
        RANDOM = new Random();
    }

    public static List<Person> build(int count) {
        return Stream.generate(() -> Person.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .age((int) (Math.random() * (31 - 15)) + 15).build())
                .limit(count)
                .collect(Collectors.toList());
    }
}
