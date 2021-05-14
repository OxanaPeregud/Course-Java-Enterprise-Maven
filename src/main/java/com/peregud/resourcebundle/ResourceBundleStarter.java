package com.peregud.resourcebundle;

import java.nio.file.Paths;
import java.util.List;

public class ResourceBundleStarter {
    public static String filepath = String.valueOf(Paths.get("src", "main", "resources", "PersonList.txt"));

    public static void start() {
        List<Person> list = PersonUtil.generate(100);
        PersonGeneratorUtil.createPersonList(list).forEach(System.out::println);
        PersonFileUtil.personInFile(filepath, PersonGeneratorUtil.createPersonList(list));
        List<Person> readPersonList = PersonGeneratorUtil.createPersonList(list);
        DisplayUtil.displayPersonList(readPersonList);
    }
}
