package com.peregud.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Address")
@Table(name = "Address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;
    @Column
    private String street;
    @Column
    private int house;
    @Column
    private int apartment;
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<PersonAddress> personAddress = new ArrayList<>();
}
