package com.peregud.lombok.util;

import com.peregud.lombok.model.Address;
import com.peregud.lombok.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataBuilderUtil {
    private static final List<String> FIRST_NAMES;
    private static final List<String> LAST_NAMES;
    private static final List<String> STREETS;
    private static final Random RANDOM = new Random();

    static {
        FIRST_NAMES = Arrays.asList("James", "Robert", "Michael", "David", "Richard");
        LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones");
        STREETS = Arrays.asList("Wall Street", "Broadway", "Bowery", "Houston Street", "Canal Street");
    }

    public static List<Person> buildPerson(int count) {
        return Stream.generate(() -> Person.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .age((int) (Math.random() * (75 - 1)) + 1)
                .addressId((int) (Math.random() * (6 - 1)) + 1)
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }

    public static List<Address> buildAddress(int count) {
        return Stream.generate(() -> Address.builder()
                .street(STREETS.get(RANDOM.nextInt(STREETS.size())))
                .house((int) (Math.random() * (150 - 1)) + 1)
                .apartment((int) (Math.random() * (250 - 1)) + 1)
                .build())
                .limit(count)
                .collect(Collectors.toList());
    }
}
