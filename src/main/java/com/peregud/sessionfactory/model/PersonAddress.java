package com.peregud.sessionfactory.model;

import javax.persistence.*;

@Entity(name = "PersonAddress")
@Table(name = "Person_Address")
public class PersonAddress {
    @EmbeddedId
    private PersonAddressId id;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("personId")
    private Person person;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("addressId")
    private Address address;
}
