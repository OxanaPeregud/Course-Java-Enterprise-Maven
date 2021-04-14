package com.peregud.pattern_builder;

import java.io.Serializable;
import java.util.Objects;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder implements Serializable {
        private String firstName;
        private String lastName;
        private int age;

        public PersonBuilder() {
        }

        public PersonBuilder(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public boolean underAge() {
            return this.age < 21;
        }

        @Override
        public String toString() {
            return "PersonBuilder{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PersonBuilder)) return false;
            PersonBuilder that = (PersonBuilder) o;
            return age == that.age && firstName.equals(that.firstName) && lastName.equals(that.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, age);
        }
    }
}
