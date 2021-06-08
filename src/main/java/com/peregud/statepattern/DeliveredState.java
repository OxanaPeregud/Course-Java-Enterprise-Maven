package com.peregud.statepattern;

public class DeliveredState implements State {

    @Override
    public void nextState(Parcel parcel) {
        parcel.setState(new PickedUpState());
    }

    @Override
    public void previousState(Parcel parcel) {
        parcel.setState(new OnTheWayState());
    }

    @Override
    public void currentState() {
        System.out.println("Parcel has been delivered to local post office, but not picked up by client yet");
    }

    @Override
    public String toString() {
        return "DeliveredState{}";
    }
}
