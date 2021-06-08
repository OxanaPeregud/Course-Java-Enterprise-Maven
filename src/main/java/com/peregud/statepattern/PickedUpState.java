package com.peregud.statepattern;

public class PickedUpState implements State {

    @Override
    public void nextState(Parcel parcel) {
        System.out.println("Parcel has been already picked up by client");
    }

    @Override
    public void previousState(Parcel parcel) {
        parcel.setState(new DeliveredState());
    }

    @Override
    public void currentState() {
        System.out.println("Parcel is being picked up by client");
    }

    @Override
    public String toString() {
        return "PickedUpState{}";
    }
}
