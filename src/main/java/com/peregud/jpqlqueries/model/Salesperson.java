package com.peregud.jpqlqueries.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "salesperson")
public class Salesperson implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "salesperson_id", unique = true)
    private Long salespersonId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Double salary;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Store store;
}
