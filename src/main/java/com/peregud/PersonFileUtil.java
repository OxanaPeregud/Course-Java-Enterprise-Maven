package com.peregud;

import java.io.*;

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

    public static void personFromFile(String filepath) {
        try (FileInputStream fileInputStream = new FileInputStream(filepath);
             ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
            while (fileInputStream.available() > 0) {
                Person person = (Person) ois.readObject();
                PersonGeneratorUtil.filterPersonList().add(person);
                System.out.println(
                        PersonResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.FIRST_NAME) + ": " +
                                person.getFirstName() + ", " +
                                PersonResourceBundleUtil.getValueResourceBundle(ResourceBundleKeyUtil.LAST_NAME) + ": " +
                                person.getLastName());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
