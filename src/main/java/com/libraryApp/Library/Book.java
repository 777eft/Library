package com.libraryApp.Library;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@AllArgsConstructor

public class Book {

    @Id
    private String title;

    private String category;

    private int releaseYear;

    private String author;

    private String genre;

    private int isbn;

}
