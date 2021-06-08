package com.peregud.statepattern;

public interface State {
    void nextState(Parcel parcel);
    void previousState(Parcel parcel);
    void currentState();
}
