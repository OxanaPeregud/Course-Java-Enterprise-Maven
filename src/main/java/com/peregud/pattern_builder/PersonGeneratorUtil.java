package com.peregud.pattern_builder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class PersonGeneratorUtil {

    private PersonGeneratorUtil() {
    }

    public static List<Person> createPersonList(List<Person> list) {
        return list.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName))
                .distinct()
                .filter(Person::underAge)
                .collect(Collectors.toList());
    }
}
