package com.peregud.join_sql_db.model;

public class Address {
    private int addressID;
    private String street;
    private int house;
    private int apartment;

    public Address() {
    }

    public Address(String street, int house, int apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
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

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address ID: " + addressID +
                ", Street: " + street +
                ", House: " + house +
                ", Apartment: " + apartment;
    }
}
