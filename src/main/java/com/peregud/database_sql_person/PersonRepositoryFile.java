package com.peregud.database_sql_person;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryFile implements PersonRepository {
    private static final String FILEPATH = String.valueOf(Paths.get("src", "main", "resources", "PersonList.txt"));

    @Override
    public void personInput(List<Person> list) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(FILEPATH))) {
            for (Person person : list) {
                oop.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> personOutput() {
        List<Person> list = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(FILEPATH);
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
