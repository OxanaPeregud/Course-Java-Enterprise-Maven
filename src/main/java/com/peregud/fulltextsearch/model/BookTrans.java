package com.peregud.fulltextsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookTrans {
    private String title;
    private LocalDate publishingDate;
}
