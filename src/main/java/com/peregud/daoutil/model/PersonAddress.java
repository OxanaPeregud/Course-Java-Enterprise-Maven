package com.peregud.daoutil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAddress {
    @FieldName(key = "person_id")
    private int personID;
    @FieldName(key = "address_id")
    private int addressID;
}
