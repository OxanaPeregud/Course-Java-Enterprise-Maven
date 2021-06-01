package com.peregud.abstractfactorypattern.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "motorcycle_model")
public class MotorcycleModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motorcycle_model_id", unique = true)
    private Long motorcycleModelId;

    @Column(name = "motorcycle_model")
    private String motorcycleModel;

    @Column
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "motorcycle_id")
    private MotorcycleEntity motorcycleEntity;

    @Override
    public int hashCode() {
        return Objects.hash(motorcycleModelId);
    }
}
