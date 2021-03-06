package com.peregud.patternbuilder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonBuilderTest {
    List<Person> list = new ArrayList<>();

    public void addToList() {
        list.add(new Person("James", "Jones", 22));
        list.add(new Person("David", "Brown", 15));
        list.add(new Person("Joseph", "Davis", 17));
        list.add(new Person("David", "Brown", 15));
        list.add(new Person("Robert", "Miller", 19));
        list.add(new Person("Robert", "Miller", 21));
    }

    @Test
    public void getList() {
        addToList();
        assertEquals("[Person{firstName='James', lastName='Jones', age=22}, " +
                        "Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='Joseph', lastName='Davis', age=17}, " +
                        "Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='Robert', lastName='Miller', age=19}, " +
                        "Person{firstName='Robert', lastName='Miller', age=21}]",
                list.toString());
    }

    @Test
    public void createPersonList() {
        addToList();
        assertEquals("[[Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='Joseph', lastName='Davis', age=17}, " +
                        "Person{firstName='Robert', lastName='Miller', age=19}]]",
                Collections.singletonList(PersonGeneratorUtil.createPersonList(list)).toString());
    }

    @Test
    public void getValueResourceBundle() {
        assertEquals("Имя", ResourceBundleUtil.getValueResourceBundle("firstName"));
        assertEquals("Фамилия", ResourceBundleUtil.getValueResourceBundle("lastName"));
    }
}
