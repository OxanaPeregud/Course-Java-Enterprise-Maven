package com.peregud.lombok.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int addressID;
    private String street;
    private int house;
    private int apartment;
}
