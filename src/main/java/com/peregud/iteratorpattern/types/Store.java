package com.peregud.iteratorpattern.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Store {
    FIRST_STORE("first_store"),
    SECOND_STORE("second_store");
    private final String store;
}
