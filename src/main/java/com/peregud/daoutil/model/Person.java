package com.peregud.daoutil.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @FieldName(key = "person_id")
    private int personID;
    @FieldName(key = "first_name")
    private String firstName;
    @FieldName(key = "last_name")
    private String lastName;
    @FieldName(key = "age")
    private int age;
}
