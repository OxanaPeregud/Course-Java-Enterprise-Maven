package com.peregud.statepattern;

public class OrderedState implements State {

    @Override
    public void nextState(Parcel parcel) {
        parcel.setState(new OnTheWayState());
    }

    @Override
    public void previousState(Parcel parcel) {
        System.out.println("Parcel is in its initial state");
    }

    @Override
    public void currentState() {
        System.out.println("Parcel has been ordered, but is still remaining in stock");
    }

    @Override
    public String toString() {
        return "OrderedState{}";
    }
}
