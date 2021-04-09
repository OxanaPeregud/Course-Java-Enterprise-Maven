package com.peregud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import java.util.Collections;

public class PersonTest {

    public void addToList() {
        PersonGeneratorUtil.LIST.add(new Person("James", "Jones", 22));
        PersonGeneratorUtil.LIST.add(new Person("David", "Brown", 15));
        PersonGeneratorUtil.LIST.add(new Person("Joseph", "Davis", 17));
        PersonGeneratorUtil.LIST.add(new Person("David", "Brown", 15));
        PersonGeneratorUtil.LIST.add(new Person("Robert", "Miller", 19));
        PersonGeneratorUtil.LIST.add(new Person("Robert", "Miller", 21));
    }

    @Test
    public void getList() {
        addToList();
        assertEquals("[[Person{firstName='James', lastName='Jones', age=22}, " +
                        "Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='Joseph', lastName='Davis', age=17}, " +
                        "Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='Robert', lastName='Miller', age=19}, " +
                        "Person{firstName='Robert', lastName='Miller', age=21}]]",
                Collections.singletonList(PersonGeneratorUtil.LIST).toString());
    }

    @Test
    public void sortList() {
        addToList();
        PersonGeneratorUtil.sortList();
        assertEquals("[[Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='James', lastName='Jones', age=22}, " +
                        "Person{firstName='Joseph', lastName='Davis', age=17}, " +
                        "Person{firstName='Robert', lastName='Miller', age=19}, " +
                        "Person{firstName='Robert', lastName='Miller', age=21}]]",
                Collections.singletonList(PersonGeneratorUtil.LIST).toString());
    }

    @Test
    public void distinctList() {
        addToList();
        assertEquals("[[Person{firstName='James', lastName='Jones', age=22}, " +
                        "Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='Joseph', lastName='Davis', age=17}, " +
                        "Person{firstName='Robert', lastName='Miller', age=19}, " +
                        "Person{firstName='Robert', lastName='Miller', age=21}]]",
                Collections.singletonList(PersonGeneratorUtil.distinctPersonList()).toString());
    }

    @Test
    public void filterList() {
        addToList();
        assertEquals("[[Person{firstName='David', lastName='Brown', age=15}, " +
                        "Person{firstName='Joseph', lastName='Davis', age=17}, " +
                        "Person{firstName='Robert', lastName='Miller', age=19}]]",
                Collections.singletonList(PersonGeneratorUtil.filterPersonList()).toString());
    }

    @Test
    public void getValueResourceBundle() {
        assertEquals("Имя", ResourceBundleUtil.getValueResourceBundle("FIRST_NAME"));
        assertEquals("Фамилия", ResourceBundleUtil.getValueResourceBundle("LAST_NAME"));
    }
}
