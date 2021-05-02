package com.peregud.lombok_sql_join.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int personID;
    private String firstName;
    private String lastName;
    private int age;
}
