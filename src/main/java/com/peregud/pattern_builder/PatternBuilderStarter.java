package com.peregud.pattern_builder;

import java.nio.file.Paths;
import java.util.List;

public class PatternBuilderStarter {
    public static String filepath = String.valueOf(Paths.get("src", "main", "resources", "PersonList.txt"));

    public static void start() {
        List<Person> list = PersonUtil.build(100);
        List<Person> personGenerateList = PersonGeneratorUtil.createPersonList(list);
        DisplayUtil.displayPersonList(personGenerateList);
        PersonFileUtil.personInFile(filepath, PersonGeneratorUtil.createPersonList(list));
        List<Person> personList = PersonFileUtil.personFromFile(PatternBuilderStarter.filepath);
        DisplayUtil.displayPersonList(personList);
    }
}
