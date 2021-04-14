package com.peregud.resource_bundle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class PersonFileUtil {

    private PersonFileUtil() {
    }

    public static void personInFile(String filepath, List<Person> list) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(filepath))) {
            for (Person person : list) {
                oop.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> personFromFile(String filepath) {
        List<Person> list = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(filepath);
             ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
            while (fileInputStream.available() > 0) {
                Person person = (Person) ois.readObject();
                list.add(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
