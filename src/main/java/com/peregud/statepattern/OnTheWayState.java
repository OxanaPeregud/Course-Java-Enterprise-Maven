package com.peregud.statepattern;

public class OnTheWayState implements State {

    @Override
    public void nextState(Parcel parcel) {
        parcel.setState(new DeliveredState());
    }

    @Override
    public void previousState(Parcel parcel) {
        System.out.println("Parcel has been ordered by client");
    }

    @Override
    public void currentState() {
        System.out.println("Parcel is on its way to local post office");
    }

    @Override
    public String toString() {
        return "OnTheWayState{}";
    }
}
