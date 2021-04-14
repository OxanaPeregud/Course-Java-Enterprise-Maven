package com.peregud.pattern_builder;

import java.util.List;

public class DisplayUtil {
    public static void displayPersonList(List<Person.PersonBuilder> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + " " +
                    PersonFileUtil.personFromFile(PatternBuilderStarter.filepath).get(i).getFirstName() + ", " +
                    ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + " " +
                    PersonFileUtil.personFromFile(PatternBuilderStarter.filepath).get(i).getLastName());
        }
    }
}
