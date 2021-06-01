package com.peregud.abstractfactorypattern.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "car_model")
public class CarModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_model_id", unique = true)
    private Long carModelId;

    @Column(name = "car_model")
    private String carModel;

    @Column
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

    @Override
    public int hashCode() {
        return Objects.hash(carModelId);
    }
}
