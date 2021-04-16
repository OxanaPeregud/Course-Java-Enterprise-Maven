package com.peregud.database_sql_person;

import java.util.List;

public class PersonView {

    public static void displayPersonList(List<Person> list) {
        for (Person person : list) {
            System.out.println(ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + " " +
                    person.getFirstName() + ", " +
                    ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + " " +
                    person.getLastName());
        }
    }
}