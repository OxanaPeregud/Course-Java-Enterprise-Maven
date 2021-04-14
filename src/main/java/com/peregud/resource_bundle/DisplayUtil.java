package com.peregud.resource_bundle;

import java.util.List;

public class DisplayUtil {

    public static void displayPersonList(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + " " +
                    PersonFileUtil.personFromFile(Starter.filepath).get(i).getFirstName() + ", " +
                    ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + " " +
                    PersonFileUtil.personFromFile(Starter.filepath).get(i).getLastName());
        }
    }
}
