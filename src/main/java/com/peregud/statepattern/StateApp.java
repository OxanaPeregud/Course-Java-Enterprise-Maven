package com.peregud.statepattern;

public class StateApp {

    public static void main(String[] args) {

        Parcel parcel = new Parcel();
        parcel.previousState();
        parcel.currentState();

        parcel.nextState();
        parcel.currentState();

        parcel.nextState();
        parcel.currentState();

        parcel.nextState();
        parcel.currentState();

    }
}
