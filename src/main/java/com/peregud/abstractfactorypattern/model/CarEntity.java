package com.peregud.abstractfactorypattern.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car")
public class CarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", unique = true)
    private Long carId;

    @Column(name = "car_brand")
    private String carBrand;

    @OneToMany(mappedBy = "carModel")
    private Set<CarModel> carModels = new HashSet<>();
}
