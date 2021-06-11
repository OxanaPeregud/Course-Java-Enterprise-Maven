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
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", unique = true)
    private Long courseId;

    @Column
    private String name;

    @OneToMany(mappedBy = "course")
    private Set<Teacher> teacher = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<Task> tasks = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Admin admin;
}
