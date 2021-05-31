package com.peregud.decoratorpattern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pizza")
@Table(name = "pizza")
public class Pizza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id", unique = true)
    private int pizzaId;

    @Column(name = "pizza_name")
    private String pizzaName;

    @Column(name = "pizza_cost")
    private double pizzaCost;
}
