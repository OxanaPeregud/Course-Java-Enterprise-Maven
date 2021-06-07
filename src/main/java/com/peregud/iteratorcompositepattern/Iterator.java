package com.peregud.iteratorcompositepattern;

public interface Iterator {
    boolean hasNext();
    Object next();
    void remove();
}
