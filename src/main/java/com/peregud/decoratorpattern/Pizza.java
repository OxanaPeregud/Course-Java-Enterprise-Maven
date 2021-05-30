package com.peregud.decoratorpattern;

import com.peregud.decoratorpattern.model.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Pizza {
    private String description;
    private Size size;
    private double cost;

    public Pizza(Size size) {
        this.size = size;
    }

    public abstract String description();

    public abstract double cost();
}
