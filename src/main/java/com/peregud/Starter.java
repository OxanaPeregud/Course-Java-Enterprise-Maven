package com.peregud;

import java.nio.file.Paths;
import java.util.List;

public class Starter {
    public static String filepath = String.valueOf(Paths.get("src", "main", "resources", "PersonList.txt"));

    public static void main(String[] args) {
        List<Person> list = PersonUtil.generate(100);
        PersonGeneratorUtil.createPersonList(list).forEach(System.out::println);
        PersonFileUtil.personInFile(filepath, PersonGeneratorUtil.createPersonList(list));
        List<Person> readPersonList = PersonGeneratorUtil.createPersonList(list);
        DisplayUtil.displayPersonList(readPersonList);
    }
}
