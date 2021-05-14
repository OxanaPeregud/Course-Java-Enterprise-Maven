package com.peregud.sqldatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonGeneratorService {
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

    public static List<Person> generate(int count) {
        return Stream.generate(() -> new Person(
                FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())),
                LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())),
                (int) (Math.random() * (31 - 15)) + 15))
                .limit(count)
                .collect(Collectors.toList());
    }
}
