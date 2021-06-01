package com.peregud.abstractfactorypattern;

public interface AbstractFactory<T> {
    T create(Enum<?> type);
}
