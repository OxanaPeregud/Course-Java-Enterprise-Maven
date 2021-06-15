package com.peregud.fulltextsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table
@Indexed(index = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Field(store = Store.YES)
    public String title;

    @Field
    public String description;

    @Field
    public int rating;

    @Field(name = "publishing_date", store = Store.YES)
    public LocalDate publishingDate;
}
