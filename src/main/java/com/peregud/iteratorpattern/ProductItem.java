package com.peregud.iteratorpattern;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductItem {
    private int id;
    private String name;
    private double price;
    private boolean inStock;
}
