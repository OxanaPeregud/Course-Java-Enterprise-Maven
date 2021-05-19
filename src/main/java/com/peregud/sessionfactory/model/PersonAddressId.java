package com.peregud.sessionfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PersonAddressId implements Serializable {
    @Column(name = "person_id")
    private int personId;
    @Column(name = "address_id")
    private int addressId;
}
