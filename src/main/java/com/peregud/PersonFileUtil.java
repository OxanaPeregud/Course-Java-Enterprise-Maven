package com.peregud;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class PersonFileUtil {

    private PersonFileUtil() {
    }

    public static void personInFile(String filepath) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(filepath))) {
            for (Person person : PersonGeneratorUtil.filterPersonList()) {
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
                PersonGeneratorUtil.filterPersonList().add(person);
                list.add(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void displayPersonList(String filepath) {
        for (int i = 0; i < personFromFile(filepath).size(); i++) {
            System.out.println(ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + " " +
                    personFromFile(filepath).get(i).getFirstName() + ", " +
                    ResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + " " +
                    personFromFile(filepath).get(i).getLastName());
        }
    }
}
