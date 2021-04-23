package com.peregud.join_sql_db;

public class PeopleAddress {
    private int peopleID;
    private int addressID;

    public PeopleAddress(int peopleID, int addressID) {
        this.peopleID = peopleID;
        this.addressID = addressID;
    }

    public int getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(int peopleID) {
        this.peopleID = peopleID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
}
