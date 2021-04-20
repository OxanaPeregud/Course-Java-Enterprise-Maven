package com.peregud.database_sql_person;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Person implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private String passport;
    private String address;
    private Date dateOfBirth;
    private DateTimeAtCreation dateTimeCreate;
    private Time timeToLunch;
    private String letter;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public boolean underAge() {
        return this.age < 21;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
