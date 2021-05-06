package com.peregud.daoutil.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @FieldName(key = "address_id")
    private int addressID;
    @FieldName(key = "street")
    private String street;
    @FieldName(key = "house")
    private int house;
    @FieldName(key = "apartment")
    private int apartment;
}
