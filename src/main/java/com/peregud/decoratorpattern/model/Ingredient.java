package com.peregud.decoratorpattern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ingredient")
@Table(name = "ingredient")
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", unique = true)
    private int ingredientId;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "ingredient_cost")
    private double ingredientCost;
}
