package com.peregud.join_sql_db.model;

public class PersonAddress {
    private int personID;
    private int addressID;

    public PersonAddress() {
    }

    public PersonAddress(int personID, int addressID) {
        this.personID = personID;
        this.addressID = addressID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return "Person ID: " + personID +
                ", Address ID: " + addressID;
    }
}
