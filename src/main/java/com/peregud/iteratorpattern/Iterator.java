package com.peregud.iteratorpattern;

public interface Iterator {
    boolean hasNext();
    Object next();
    void remove();
}
