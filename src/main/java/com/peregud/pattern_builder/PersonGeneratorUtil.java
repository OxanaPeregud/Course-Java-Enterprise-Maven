package com.peregud.pattern_builder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class PersonGeneratorUtil {

    private PersonGeneratorUtil() {
    }

    public static List<Person.PersonBuilder> createPersonList(List<Person.PersonBuilder> list) {
        return list.stream()
                .sorted(Comparator.comparing(Person.PersonBuilder::getFirstName)
                        .thenComparing(Person.PersonBuilder::getLastName))
                .distinct()
                .filter(Person.PersonBuilder::underAge)
                .collect(Collectors.toList());
    }
}
