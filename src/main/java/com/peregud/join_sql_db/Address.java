package com.peregud.join_sql_db;

public class Address {
    private int id;
    private String street;
    private int house;

    public Address() {
    }

    public Address(String street, int house) {
        this.street = street;
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Street: " + street +
                ", house: " + house;
    }
}
