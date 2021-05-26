package com.peregud.sessionfactory.util;

import com.peregud.sessionfactory.model.Address;
import com.peregud.sessionfactory.model.Person;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@UtilityClass
public class DataGeneratorUtil {
    private final List<String> FIRST_NAMES;
    private final List<String> LAST_NAMES;
    private final List<String> STREETS;
    private final Random RANDOM = new Random();

    static {
        FIRST_NAMES = Arrays.asList("James", "Robert", "Michael", "David", "Richard");
        LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones");
        STREETS = Arrays.asList("Wall Street", "Broadway", "Bowery", "Houston Street", "Canal Street");
    }

    public Person buildPerson() {
        return Person.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .age((int) (Math.random() * (75 - 1)) + 1)
                .build();
    }

    public Address buildAddress() {
        return Address.builder()
                .street(STREETS.get(RANDOM.nextInt(STREETS.size())))
                .house((int) (Math.random() * (150 - 1)) + 1)
                .apartment((int) (Math.random() * (250 - 1)) + 1)
                .build();
    }
}
