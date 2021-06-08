package com.peregud.statepattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parcel {
    private State state;

    public Parcel() {
        state = new OrderedState();
    }

    public void previousState() {
        state.previousState(this);
    }

    public void nextState() {
        state.nextState(this);
    }

    public void currentState() {
        state.currentState();
    }
}
