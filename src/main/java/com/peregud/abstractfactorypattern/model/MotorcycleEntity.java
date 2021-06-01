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
@Table(name = "motorcycle")
public class MotorcycleEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motorcycle_id", unique = true)
    private Long motorcycleId;

    @Column(name = "motorcycle_brand")
    private String motorcycleBrand;

    @OneToMany(mappedBy = "motorcycleModel")
    private Set<MotorcycleModel> motorcycleModels = new HashSet<>();
}
