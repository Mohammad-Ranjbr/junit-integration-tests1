package com.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "library_test") // Query to rename table : ALTER TABLE LibraryDemo RENAME TO Storage2
public class Library {

    @Id
    private String id;
    private String book_name;
    private String isbn;
    private int aisle;
    private String author;

}
