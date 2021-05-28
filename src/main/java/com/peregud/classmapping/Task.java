package com.peregud.classmapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "task")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
}
