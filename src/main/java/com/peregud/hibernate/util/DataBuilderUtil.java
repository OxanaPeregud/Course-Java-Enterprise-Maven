package com.peregud.hibernate.util;

import com.peregud.hibernate.model.Address;
import com.peregud.hibernate.model.Person;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class DataBuilderUtil {
    private final List<String> FIRST_NAMES;
    private final List<String> LAST_NAMES;
    private final List<String> STREETS;
    private final Random RANDOM = new Random();

    static {
        FIRST_NAMES = Arrays.asList("James", "Robert", "Michael", "David", "Richard");
        LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones");
        STREETS = Arrays.asList("Wall Street", "Broadway", "Bowery", "Houston Street", "Canal Street");
    }

    public List<Person> buildPerson(int count) {
        return Stream.generate(() -> Person.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .age((int) (Math.random() * (75 - 1)) + 1)
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Address> buildAddress(int count) {
        return Stream.generate(() -> Address.builder()
                .street(STREETS.get(RANDOM.nextInt(STREETS.size())))
                .house((int) (Math.random() * (150 - 1)) + 1)
                .apartment((int) (Math.random() * (250 - 1)) + 1)
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }
}
