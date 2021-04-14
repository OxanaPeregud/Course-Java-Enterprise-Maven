package com.peregud.pattern_builder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class PersonFileUtil {

    private PersonFileUtil() {
    }

    public static void personInFile(String filepath, List<Person.PersonBuilder> list) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(filepath))) {
            for (Person.PersonBuilder person : list) {
                oop.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Person.PersonBuilder> personFromFile(String filepath) {
        List<Person.PersonBuilder> list = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filepath);
             ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
            while (fileInputStream.available() > 0) {
                Person.PersonBuilder person = (Person.PersonBuilder) ois.readObject();
                list.add(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
