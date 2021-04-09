package com.peregud;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static List<Person> list = new ArrayList<>();

    public static void main(String[] args) {

        String filepath = String.valueOf(Paths.get("src", "main", "resources", "PersonList.txt"));

        PersonGeneratorUtil.addToList();
        PersonGeneratorUtil.sortList();
        PersonGeneratorUtil.filterPersonList().forEach(System.out::println);
        PersonFileUtil.personInFile(filepath);
        PersonFileUtil.personFromFile(filepath);
    }
}
