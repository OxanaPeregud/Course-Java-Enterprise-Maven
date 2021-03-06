package com.peregud.sessionfactory.model;

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
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "updateAge",
                procedureName = "updateAge",
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN, name = "id", type = Integer.class),
                        @StoredProcedureParameter(
                                mode = ParameterMode.OUT, name = "age", type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "deletePerson",
                procedureName = "deletePerson",
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN, name = "id", type = Integer.class)
                }
        )})
@Entity(name = "Person")
@Table(name = "Person")
public class Person implements Serializable {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private int age;
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "person",
            cascade = {CascadeType.ALL},
            orphanRemoval = true)
    private List<PersonAddress> personAddress = new ArrayList<>();
}
