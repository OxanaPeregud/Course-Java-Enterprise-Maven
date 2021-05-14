package com.peregud.lombok.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "addressId")
public class Person {
    private int personID;
    private String firstName;
    private String lastName;
    private int age;
    private int addressId;
}
