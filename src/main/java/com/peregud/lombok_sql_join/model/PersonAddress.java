package com.peregud.lombok_sql_join.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAddress {
    private int personID;
    private int addressID;
}
