package com.peregud.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "PersonTest.getAll", query = "SELECT p FROM PersonTest p")
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonTest {
    @Id
    private Integer id;
    private String name;
}
