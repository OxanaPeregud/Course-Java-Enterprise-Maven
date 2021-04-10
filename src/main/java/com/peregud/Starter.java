package com.peregud;

import java.nio.file.Paths;

public class Starter {
    public static void main(String[] args) {

        String filepath = String.valueOf(Paths.get("src", "main", "resources", "PersonList.txt"));

        PersonGeneratorUtil.addToList();
        PersonGeneratorUtil.sortList();
        PersonGeneratorUtil.filterPersonList().forEach(System.out::println);
        PersonFileUtil.personInFile(filepath);
        PersonFileUtil.personFromFile(filepath);
        PersonFileUtil.displayPersonList(filepath);
    }
}
