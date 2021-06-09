package com.peregud.jpqlqueries.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "store")
public class Store implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "store_id", unique = true)
    private Long storeId;

    @Column
    private String name;

    @Column
    private String address;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column
    private Double revenue;

    @OneToMany(mappedBy = "store")
    private Set<Salesperson> salespeople = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return storeId.equals(store.storeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId);
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                ", revenue=" + revenue +
                '}';
    }
}
