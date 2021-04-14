package com.peregud.pattern_builder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonBuilderTest {
    List<Person.PersonBuilder> list = new ArrayList<>();

    public void addToList() {
        list.add(new Person.PersonBuilder("James", "Jones", 22));
        list.add(new Person.PersonBuilder("David", "Brown", 15));
        list.add(new Person.PersonBuilder("Joseph", "Davis", 17));
        list.add(new Person.PersonBuilder("David", "Brown", 15));
        list.add(new Person.PersonBuilder("Robert", "Miller", 19));
        list.add(new Person.PersonBuilder("Robert", "Miller", 21));
    }

    @Test
    public void getList() {
        addToList();
        assertEquals("[PersonBuilder{firstName='James', lastName='Jones', age=22}, " +
                        "PersonBuilder{firstName='David', lastName='Brown', age=15}, " +
                        "PersonBuilder{firstName='Joseph', lastName='Davis', age=17}, " +
                        "PersonBuilder{firstName='David', lastName='Brown', age=15}, " +
                        "PersonBuilder{firstName='Robert', lastName='Miller', age=19}, " +
                        "PersonBuilder{firstName='Robert', lastName='Miller', age=21}]",
                list.toString());
    }

    @Test
    public void createPersonList() {
        addToList();
        assertEquals("[[PersonBuilder{firstName='David', lastName='Brown', age=15}, " +
                        "PersonBuilder{firstName='Joseph', lastName='Davis', age=17}, " +
                        "PersonBuilder{firstName='Robert', lastName='Miller', age=19}]]",
                Collections.singletonList(PersonGeneratorUtil.createPersonList(list)).toString());
    }

    @Test
    public void getValueResourceBundle() {
        assertEquals("Имя", ResourceBundleUtil.getValueResourceBundle("firstName"));
        assertEquals("Фамилия", ResourceBundleUtil.getValueResourceBundle("lastName"));
    }
}
