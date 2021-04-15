package com.peregud.pattern_builder;

import java.nio.file.Paths;
import java.util.List;

public class PatternBuilderStarter {
    public static String filepath = String.valueOf(Paths.get("src", "main", "resources", "PersonList.txt"));

    public static void main(String[] args) {
        List<Person> list = PersonUtil.build(100);
        PersonGeneratorUtil.createPersonList(list).forEach(System.out::println);
        PersonFileUtil.personInFile(filepath, PersonGeneratorUtil.createPersonList(list));
        List<Person> readPersonList = PersonGeneratorUtil.createPersonList(list);
        DisplayUtil.displayPersonList(readPersonList);
    }
}
