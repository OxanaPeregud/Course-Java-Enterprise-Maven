package com.peregud.sqldatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class PersonListUtil {

    private PersonListUtil() {
    }

    public static List<Person> createPersonList(List<Person> list) {
        return list.stream()
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName))
                .distinct()
                .filter(Person::underAge)
                .collect(Collectors.toList());
    }
}
