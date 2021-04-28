package com.peregud.join_sql_db.model;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int addressId;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, int addressId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressId = addressId;
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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Person ID: " + id +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", Age: " + age +
                ", Address ID: " + addressId;
    }
}
