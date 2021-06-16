package com.peregud.univeradmin.model;

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
@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", unique = true)
    private Long adminId;

    @Column
    private String name;

    @OneToMany(mappedBy = "admin")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "admin")
    private Set<Teacher> teacher = new HashSet<>();
}
