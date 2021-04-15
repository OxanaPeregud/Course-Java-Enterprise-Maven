package com.peregud.pattern_builder;

import java.util.List;

public class DisplayUtil {
    public static void displayPersonList(List<Person> list) {
        List<Person> personList = PersonFileUtil.personFromFile(PatternBuilderStarter.filepath);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + " " +
                    personList.get(i).getFirstName() + ", " +
                    ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + " " +
                    personList.get(i).getLastName());
        }
    }
}
