package com.peregud.join_sql_db;

import java.io.Serializable;

public class People {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public People() {
    }

    public People(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +
                ", Last Name: " + lastName +
                ", Age: " + age;
    }
}
