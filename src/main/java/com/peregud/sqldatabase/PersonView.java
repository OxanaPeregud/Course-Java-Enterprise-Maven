package com.peregud.sqldatabase;

import java.util.List;

public class PersonView {

    public static void displayPersonFullList(List<Person> list) {
        for (Person person : list) {
            System.out.println(ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + " " +
                    person.getFirstName() + ", " +
                    ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + " " +
                    person.getLastName() + ", " +
                    ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.AGE) + " " +
                    person.getAge());
        }
    }

    public static void displayPersonFirstAndLastName(List<Person> list) {
        if (list != null) {
            for (Person person : list) {
                System.out.println(ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + " " +
                        person.getFirstName() + ", " +
                        ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + " " +
                        person.getLastName());
            }
        }
    }
}
